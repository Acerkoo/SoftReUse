package strategy.Test;

import strategy.algorithm.AbsoluteStrategy;
import strategy.algorithm.PercentStrategy;
import strategy.algorithm.PriceStrategy;

public class Sale {
    private PriceStrategy ps;
    private float sum;

    public float getTotalPrice() {
        sum = 100;
        float a1 = new AbsoluteStrategy().getTotal(this);
        float a2 = new PercentStrategy().getTotal(this);
        if(a1 < a2) return a1;
        else return a2;
    }

    public float getSum() {
        return sum;
    }
}
