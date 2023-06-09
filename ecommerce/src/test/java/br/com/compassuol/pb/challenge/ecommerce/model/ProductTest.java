import br.com.compassuol.pb.challenge.ecommerce.model.Product;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getProductId() {
        Product product = new Product();
        product.setProductId(1L);

        assertEquals(1L, product.getProductId());
    }

    @Test
    void getName() {
        Product product = new Product();
        product.setName("Product A");

        assertEquals("Product A", product.getName());
    }

    @Test
    void getPrice() {
        Product product = new Product();
        product.setPrice(BigDecimal.valueOf(9.99));

        assertEquals(BigDecimal.valueOf(9.99), product.getPrice());
    }

    @Test
    void getDescription() {
        Product product = new Product();
        product.setDescription("This is a product.");

        assertEquals("This is a product.", product.getDescription());
    }

    @Test
    void setProductId() {
        Product product = new Product();
        product.setProductId(1L);

        assertEquals(1L, product.getProductId());
    }

    @Test
    void setName() {
        Product product = new Product();
        product.setName("Product A");

        assertEquals("Product A", product.getName());
    }

    @Test
    void setPrice() {
        Product product = new Product();
        product.setPrice(BigDecimal.valueOf(9.99));

        assertEquals(BigDecimal.valueOf(9.99), product.getPrice());
    }

    @Test
    void setDescription() {
        Product product = new Product();
        product.setDescription("This is a product.");

        assertEquals("This is a product.", product.getDescription());
    }

    @Test
    void testEquals() {
        Product product1 = new Product();
        product1.setProductId(1L);

        Product product2 = new Product();
        product2.setProductId(1L);

        Product product3 = new Product();
        product3.setProductId(2L);

        assertEquals(product1, product2);
        assertNotEquals(product1, product3);
    }

    @Test
    void testHashCode() {
        Product product1 = new Product();
        product1.setProductId(1L);

        Product product2 = new Product();
        product2.setProductId(1L);

        assertEquals(product1.hashCode(), product2.hashCode());
    }
}
