import br.com.compassuol.pb.challenge.ecommerce.exception.ProductNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductNotFoundExceptionTest {

    @Test
    void constructor_ShouldSetMessage() {
        String errorMessage = "Product not found";

        ProductNotFoundException exception = new ProductNotFoundException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }
}
