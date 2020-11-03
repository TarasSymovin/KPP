package lab03;

import java.util.List;

public class Sentence {
    private List<Word> sentenceText;
    private SentenceType type;

    public Sentence(List<Word> sentenceText, SentenceType type) {
        this.sentenceText = sentenceText;
        this.type = type;
    }

    @Override
    public String toString() {

        String s = "";

        for (Word word : sentenceText){
            s += word.toString();
            s += " ";
        }

        s = s.replaceFirst(".$", String.valueOf(type.value));

        return s;
    }

    public SentenceType getType() {
        return type;
    }

    public List<Word> getSentenceText() {
        return sentenceText;
    }
}
