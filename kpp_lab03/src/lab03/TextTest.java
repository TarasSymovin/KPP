package lab03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TextTest {

    @Test
    void printSecondWord() {
        Text text = new Text();

        String s = "Hello world. Hello world world world! Hello wolf hello.";

        text.setText(s);

        String result = "world world wolf";

        Assertions.assertEquals(result, text.printSecondWord('w'));
    }

    @Test
    void printWordFromQuestion() {
        Text text = new Text();

        String s = "Hавello world? Hваello world woваrld world! Hello wolf hello?";

        text.setText(s);

        String result = "Hello world hello";

        Assertions.assertEquals(result, text.printWordFromQuestion(5));
    }
}