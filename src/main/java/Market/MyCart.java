package Market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
@Scope("prototype")
public class MyCart {

    @Autowired
    private List<Product> cart;

    @Autowired
    private ProductRepository productRepository;

    public MyCart() {
    }

    public void addProduct(int productId) {
        cart.add(productRepository.getProductForId(productId));
    }

    public void removeProduct(int productId) {
        Iterator<Product> iterator = cart.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == productId) {
                iterator.remove();
            }
        }
    }

    public void getAllProductListForCart() {
        for (Product p:cart) {
            System.out.printf("Id: %d. Title: %s. Price: %d",p.getId(),p.getTitle(),p.getPrice());
            System.out.println();
        }
    }

    public int getSizeList() {
        return cart.size();
    }
}
