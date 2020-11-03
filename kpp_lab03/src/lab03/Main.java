package lab03;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "src/lab03/text";

        Text text = new Text(filePath);
        text.printText();

        System.out.println(text.countLatinWord());
        System.out.println(text.countKirilWord());
        System.out.println(text.countDigit());
        System.out.println(text.countElseWord());

        text.markDigit();
        text.printText();

        System.out.println(text.printSecondWord('м'));
        System.out.println(text.printWordFromQuestion(5));

        text.removeSentenceWithBadWord();
    }
}
