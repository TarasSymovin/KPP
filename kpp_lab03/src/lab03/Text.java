package lab03;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    private List<Sentence> textContent = new ArrayList<Sentence>();

    public Text(String fileName) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(fileName)));

        Scanner scanner = new Scanner(Path.of(fileName));
        StringBuilder stringBuilderFromFile = new StringBuilder("");
        scanner.useDelimiter(System.getProperty("line.separator"));
        while(scanner.hasNext()){
            stringBuilderFromFile.append(scanner.next());
        }
        scanner.close();

        setText(stringBuilderFromFile.toString());
    }

    public Text(){
        this.textContent = new ArrayList<>();
    }

    public void setText(String text){
        Matcher matcher = Pattern.compile("([^.!?]+[.!?])").matcher(text);
        while (matcher.find())
        {
            List<Word> words = new ArrayList<Word>();
            String sentence = matcher.group(1);
            SentenceType sentenceType = getTypeSentence(sentence.charAt(sentence.length()-1));
            sentence = sentence.replaceFirst(".$","");
            sentence = sentence.trim();

            for (String s : sentence.split("[^A-Za-zА-Яа-я\\d+,\\d+]+")) {

                if (!s.equals(",")){
                    words.add(new Word(s));
                }
            }

            textContent.add(new Sentence(words, sentenceType));
        }
    }

    public void printText(){
        for (Sentence sentence : textContent) {
            System.out.println(sentence);
        }
    }

    private SentenceType getTypeSentence(char type){
        SentenceType sentenceType = null;

        if (type == '.'){
            return sentenceType.STORY;
        }
        else if (type == '!'){
            return sentenceType.MOTIVATION;
        }
        else if (type == '?'){
            return sentenceType.QUESTION;
        }

        return sentenceType;
    }

    public int countLatinWord(){
        int count = 0;

        for (Sentence sentence : textContent){
            for (Word word : sentence.getSentenceText()){
                if (word.isLatin()){
                    count++;
                }
            }
        }
        return count;
    }

    public int countKirilWord(){
        int count = 0;

        for (Sentence sentence : textContent){
            for (Word word : sentence.getSentenceText()){
                if (word.isKiril()){
                    count++;
                }
            }
        }

        return count;
    }

    public int countDigit(){
        int count = 0;

        for (Sentence sentence : textContent){
            for (Word word : sentence.getSentenceText()){
                if (word.isDigit()){
                    count++;
                }
            }
        }

        return count;
    }

    public int countElseWord(){

        int count = 0;

        for (Sentence sentence : textContent){
            count += sentence.getSentenceText().size();
        }

        return count - countDigit() - countKirilWord() - countLatinWord();
    }

    public void removeSentenceWithBadWord(){
        List<Integer> list = new ArrayList<>();

        for (Sentence sentence : textContent){
            int latinCount = 0;
            int digitCount = 0;
            int kirilCount = 0;

            for (Word word : sentence.getSentenceText()){
                if (word.isKiril()){
                    kirilCount++;
                }
                else if(word.isLatin()){
                    latinCount++;
                }
                else if (word.isDigit()){
                    digitCount++;
                }
            }

            list.add(sentence.getSentenceText().size() - latinCount - digitCount - kirilCount);
        }

        int max = Collections.max(list);

        Sentence removableSentence = null;

        for (Sentence sentence : textContent){
            int count = 0;
            int latinCount = 0;
            int digitCount = 0;
            int kirilCount = 0;

            for (Word word : sentence.getSentenceText()){
                if (word.isKiril()){
                    kirilCount++;
                }
                else if(word.isLatin()){
                    latinCount++;
                }
                else if (word.isDigit()){
                    digitCount++;
                }
            }

            count = sentence.getSentenceText().size() - latinCount - digitCount - kirilCount;

            if (count == max){
                removableSentence = sentence;
            }
        }

        textContent.remove(removableSentence);
    }

    public void markDigit(){
        for (Sentence sentence : textContent){
            for (Word word : sentence.getSentenceText()){
                if (word.isDigit()){
                    if (word.getWordText().matches("[+-]?([0-9]*[.])?[0-9]+")){
                        word.setWordText(word.getWordText() + "(int)");
                    }
                    else {
                        word.setWordText(word.getWordText() + "(float)");
                    }
                }
            }
        }
    }

    public String printSecondWord(char c){
        String result = "";

        for (Sentence sentence : textContent){
            if (sentence.getSentenceText().size() >= 2){
                if (sentence.getSentenceText().get(1).getWordText().charAt(0) == c){
                    result += sentence.getSentenceText().get(1).getWordText() + " ";
                }
            }
        }
        result = result.replaceFirst(".$","");
        return result;
    }

    public String printWordFromQuestion(int length){

        List<String> wordList = new ArrayList<>();

        for (Sentence sentence : textContent){
            if (sentence.getType().value == '?'){
                for (Word word : sentence.getSentenceText()){
                    if (word.getWordText().length() == length){
                        wordList.add(word.getWordText());
                    }
                }
            }
        }

        Set<String> words = new LinkedHashSet<>(wordList);
        String result = "";

        for (String s : words){
            result += s + " ";
        }

        result = result.replaceFirst(".$","");

        return result;
    }
}
