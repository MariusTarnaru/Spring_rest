import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnotherTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4, 6, 10, 2000})
    void someIntegersAreEven(Integer number) {
        assertEquals(0, number % 2);
        assertTrue(number % 2 == 0);
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = {"JANUARY", "DECEMBER"})
    void someMonthsAre31DaysLong(Month month) {
        int actualDays = month.length(false);
        assertEquals(31, actualDays);
    }
}
