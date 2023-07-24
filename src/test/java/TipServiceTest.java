import org.example.TipService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipServiceTest {

    @ParameterizedTest(name = "Граничные значения суммы покупки {0}")
    @CsvSource({"1", "500", "999", "1000", "1001", "10000"})
    @DisplayName("Тест на корректность начисления чаевых")
    void roundTipTest(BigDecimal amount) {

        BigDecimal expectedResult;
        if (amount.compareTo(BigDecimal.valueOf(1000)) < 0) {
            expectedResult = amount.multiply(BigDecimal.valueOf(1.1));
        } else {
            expectedResult = amount.multiply(BigDecimal.valueOf(1.05));
        }

        TipService tipService = new TipService();
        BigDecimal actualResult = tipService.roundTips(amount);
        assertEquals(expectedResult, actualResult);
    }
}




