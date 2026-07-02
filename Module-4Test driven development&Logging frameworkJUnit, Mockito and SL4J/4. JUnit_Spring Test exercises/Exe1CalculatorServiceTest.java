import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Exe1CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testAdd_ShouldReturnSumOfTwoNumbers() {
        // Arrange
        int a = 5;
        int b = 10;
        int expectedResult = 15;

        // Act
        int actualResult = calculatorService.add(a, b);

        // Assert
        assertEquals(expectedResult, actualResult, "The add method should correctly sum two numbers.");
    }
}
