package Observer;

public class ObserverTest {
    public static void main(String []argc) {
        DBLog dbLog = new DBLog();
        MSM msm = new MSM();
        Discount discount = new Discount();
        BuyTicket buyTicket = new BuyTicket();

        buyTicket.addObserver(dbLog);
        buyTicket.addObserver(msm);
        buyTicket.addObserver(discount);

        buyTicket.buyTicket();
    }
}
