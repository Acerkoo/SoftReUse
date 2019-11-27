package observer.market;

import observer.visitor.Visitor;

public class Apple extends Product{
    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getName() + " visit Apple!!");
    }
    public void operationA() {
        System.out.println("operationA");
    }
}
