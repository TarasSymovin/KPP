package lab03;

public class Word {
    private String wordText;

    public Word(String wordText) {
        this.wordText = wordText;
    }

    @Override
    public String toString() {
        return wordText;
    }

    public String getWordText() {
        return wordText;
    }

    public boolean isLatin(){
        return wordText.matches("^[a-zA-Z]+$");
    }

    public boolean isKiril(){
        return wordText.matches("^[а-яА-Я]+$");
    }

    public boolean isDigit(){
        return wordText.matches("^[\\d+,\\d]+$");
    }

    public void setWordText(String wordText) {
        this.wordText = wordText;
    }
}
