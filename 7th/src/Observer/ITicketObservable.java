package Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class ITicketObservable {
    protected List<ITicketObserver> observerList = new ArrayList<ITicketObserver>();

    public void addObserver(ITicketObserver observer) {
        observerList.add(observer);
    }

}
