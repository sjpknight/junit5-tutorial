package junit5tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
// added so that MethodSource tests don't have to be declared as static
public class ParameterisedTests {

    // annotate the test as being parameterised
    @ParameterizedTest(name = "Run: {index} - Value: {arguments}")
    // use @ValueSource to define the values which will be used in the test
    @ValueSource(ints = {1, 5, 6})
    void intValues(int theParam) {
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest(name = "Run: {index} - Value: (arguments}")
    // pass an empty string as a parameter
    @EmptySource
    // pass a null string as a parameter
    @NullSource
    // do both
    @NullAndEmptySource
    @ValueSource(strings = {"1stString", "2ndString"})
    void stringValues(String theParam) {
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,rogers", "tony,stark", "peter,parker"})
    void csvSource_StringString(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"'steve,rogers', 32, true", "'tony,stark', 12, false", "'peter,parker', 5, true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve?rogers", "tony?stark", "peter?parker"}, delimiter = '?')
    void csvSource_StringWithDifferentDelimiter(String param1, String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv", "src/test/resources/params/shoppinglist2.csv"}, numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringString(String name, double price, int qty, String uom, String provider) {
        System.out.println("name = " + name + ", price = " + price + ", quantity " + qty + ", unit of measure = " + uom + ", provider = " + provider);

    }

    @ParameterizedTest
    @MethodSource(value = "junit5tests.helpers#sourceString") // valid methodSource methods have to return either a stream or a list (which can be converted to a stream)
    void methodSource_String(String param1) {
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest
    @MethodSource(value = "junit5tests.helpers#sourceStream")
    void methodSource_Stream(String param1) {
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest
    @MethodSource(value = "junit5tests.helpers#sourceList_StringDouble")
    void methodSource_StringDoubleList(String param1, double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @MethodSource(value = "junit5tests.helpers#sourceStream_StringDouble")
    void methodSource_StringDoubleStream(String param1, double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

}
