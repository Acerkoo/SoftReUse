package Observer;

public class BuyTicket extends ITicketObservable {
    public void buyTicket() {
        for (ITicketObserver observer: observerList) {
            observer.onBuyTicket();
        }
    }
}
