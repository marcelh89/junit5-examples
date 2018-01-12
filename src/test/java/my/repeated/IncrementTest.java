package my.repeated;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class IncrementTest {
	
	public static int counter = 1;

    @BeforeEach
    public void increment() {
        System.out.println("Before Each Test");
    }

    @RepeatedTest(value=3, name=RepeatedTest.SHORT_DISPLAY_NAME)
    public void test(RepetitionInfo info) {
        assertTrue(counter == 1);
        System.out.println("Repetition #" + info.getCurrentRepetition());
        counter++;
    }
}