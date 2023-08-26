import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product item1 = new Product(11, "Хлеб", 45);
    Product item2 = new Product(22, "Рис", 85);
    Product item3 = new Product(3, "Торт", 555);

    @Test
    public void test() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        repo.remove(22);
        Product[] expected = {item1, item3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNegative() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(15);
        });
    }
}