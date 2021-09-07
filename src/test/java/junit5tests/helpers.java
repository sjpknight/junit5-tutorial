package junit5tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class helpers {

    // must be static if declared outside of test class
    static List<String> sourceString() {
        // some processing done here
        return Arrays.asList("tomato", "carrot", "cabbage");
    }

    static Stream<String> sourceStream() {
        // some processing done here
        return Stream.of("beetroot", "apple", "pear");
    }

    static List<Arguments> sourceList_StringDouble() {
        // processing
        return Arrays.asList(arguments("tomato", 2.0),
                arguments("carrot", 4.5), arguments("cabbage", 7.8));
    }

    static Stream<Arguments> sourceStream_StringDouble() {
        // processing
        return Stream.of(arguments("Apples", 2.0),
                arguments("Pears", 4.5), arguments("Cherrys", 7.8));
    }
}
