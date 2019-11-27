package strategy.algorithm;

import strategy.Test.Sale;

public class PercentStrategy implements PriceStrategy{
    @Override
    public float getTotal(Sale sale) {
        float sum = sale.getSum();
        float ans = sum*0.7F;
        System.out.println(this.getClass().getName() + " 打七折");
        System.out.println( "原价：" + sum + " 现价："+ ans);
        return ans;
    }
}
