package mvc;
import java.util.List;
import java.util.ArrayList;

public class Publisher {
	private List<Subscriber> subscribers = new ArrayList<Subscriber>();
	
	public void subscribe(Subscriber ob) {
		subscribers.add(ob);
	}
	
	public void unsubscribe(Subscriber ob) {
		subscribers.remove(ob);
	}
	
	public void notifySubs() {
		for (int i = 0; i < subscribers.size(); i++) {
			subscribers.get(i).update();
		}
	}
}
