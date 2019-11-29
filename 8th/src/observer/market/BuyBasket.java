package observer.market;

import observer.visitor.Visitor;
import org.springframework.context.annotation.Primary;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class BuyBasket {
    private List<Product> proList = new ArrayList<>();

    public void accept(Visitor visiter) {
        for (Product product: proList) {
            product.accept(visiter);
        }
    }
    public void addProduct(Product product) {
        proList.add(product);
    }
    public void removeProduct(Product product) {
        for (Product pp: proList) {
            if(pp.equals(product)) {
                proList.remove(pp);
                break;
            }
        }
    }
}
