package strategy.algorithm;

import strategy.Test.Sale;

public class AbsoluteStrategy implements PriceStrategy{

    @Override
    public float getTotal(Sale sale) {
        float sum = sale.getSum();
        float ans = sum - ((int)(sum/100))*20;
        System.out.println(this.getClass().getName() + " 满100减20");
        System.out.println( "原价：" + sum + " 现价："+ ans);
        return ans;
    }
}
