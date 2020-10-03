import main.java.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private static Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @BeforeAll
    static void setUp() {
        System.out.println("Starting test at " + LocalDateTime.now());
    }

    @AfterAll
    static void tearDown() {
        System.out.println("Finished test at" + LocalDateTime.now());
    }

    @RepeatedTest(3)
    void repeatedReturnTheSumOfTwoNumbers() {
        double actualResult = calculator.add(1, 2);

        assertEquals(3, actualResult);
    }

    @Test
    void shouldReturnResultOfSubtraction() {
        double actualResult = calculator.sub(1, 2);

        assertEquals(-1, actualResult);
    }

    @Test
    void shouldreturnResultOfMultiplication() {
        assertEquals(12, calculator.mul(4, 3)); // when + then
    }

    @Test
    void shouldReturnResultOfDivision() {
        assertEquals(4, calculator.divide(16, 4));
    }

    @Test
    void divideByZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(1, 0));
    }

    @ParameterizedTest
    @CsvSource({"-10,10", "4,-4", "-0,0"})
    void reverseSign(double result, double input) {
        assertEquals(result, calculator.reverseSign(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "reverse.csv")
    void reverseSignCSV(double result, double input) {
        assertEquals(result, calculator.reverseSign(input));
    }

    @ParameterizedTest(name = "[{index}] result={0}, input={1}")
    @MethodSource(value = "reverseSignArguments")
    void reverseSignMethodSource(double result, double input) {
        assertEquals(result, calculator.reverseSign(input));
    }

    static Stream<Arguments> reverseSignArguments() {
        return Stream.of(
                Arguments.of(-4, 4),
                Arguments.of(10, -10)
        );
    }

    @ParameterizedTest(name = "[{index}] result={0}, input={1}")
    @ArgumentsSource(Parameters.class)
    void reverseSignArgumentsSource(double result, double input) {
        assertEquals(result, calculator.reverseSign(input));
    }

    static class Parameters implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(-4, 4),
                    Arguments.of(10, -10)
            );
        }
    }

}