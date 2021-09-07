package junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatedTests {

    @RepeatedTest(value = 3, name = "Running repetition {currentRepetition} " + "out of {totalRepetitions}.")
    void repeat3xtest() {
        System.out.println("This test repeats three times");
    }

    @RepeatedTest(2)
    void repeat2xtest(RepetitionInfo repinfo) {
        System.out.println("This code runs at each repetition.");
        Assumptions.assumingThat(repinfo.getCurrentRepetition() == 2,
                () -> System.out.println("This code only runs for repetition 2."));
    }
}
