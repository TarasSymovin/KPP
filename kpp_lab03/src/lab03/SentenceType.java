package lab03;

public enum SentenceType {
    STORY('.'),
    QUESTION('?'),
    MOTIVATION('!');

    public char value;

    SentenceType(char c) {
        this.value = c;
    }

    public char getValue() {
        return value;
    }
}
