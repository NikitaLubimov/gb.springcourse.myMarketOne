package Market;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {

    @Autowired
    private List<Product> productList;

    @PostConstruct
    private void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "KitKat", 150));
        productList.add(new Product(2, "Milk", 200));
        productList.add(new Product(3, "ColaCola", 160));
        productList.add(new Product(4, "Bread", 100));
        productList.add(new Product(5, "Pivko", 120));
    }

    public Product getProductForId(int id) {
        return productList.stream().filter(product -> product.getId() == id).findFirst().orElseThrow();
    }

    public void getAllProduct() {
        for (Product p : productList) {
            System.out.printf("Id: %d. Title: %s. Price: %d",p.getId(),p.getTitle(),p.getPrice());
            System.out.println();
        }
    }
}
