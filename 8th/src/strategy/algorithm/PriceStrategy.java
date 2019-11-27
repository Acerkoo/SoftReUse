package strategy.algorithm;

import strategy.Test.Sale;

public interface PriceStrategy {
    public float  getTotal(Sale sale);
}
