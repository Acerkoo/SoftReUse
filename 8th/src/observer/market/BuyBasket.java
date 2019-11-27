package observer.market;

import observer.visitor.Visitor;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class BuyBasket {
    private List<Product> proList = new ArrayList<>();

    public void accept(Visitor visiter) {
        System.out.println(visiter.getClass().getName() + " visit buybasket");
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
