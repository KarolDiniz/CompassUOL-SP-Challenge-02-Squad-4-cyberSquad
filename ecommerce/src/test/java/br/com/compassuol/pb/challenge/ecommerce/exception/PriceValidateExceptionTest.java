import br.com.compassuol.pb.challenge.ecommerce.exception.PriceValidateException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceValidateExceptionTest {

    @Test
    void constructor_shouldSetMessage() {
        String message = "Invalid price";
        PriceValidateException exception = new PriceValidateException(message);
        assertEquals(message, exception.getMessage());
    }
}
