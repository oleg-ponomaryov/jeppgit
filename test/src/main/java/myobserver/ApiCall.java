package myobserver;

import java.util.ArrayList;
import java.util.List;

public class ApiCall {

	public static void main(String...args) {
		List<Observer> obs = new ArrayList<Observer>();
		
		Observer o1 = new ObserverImpl();
		o1.setOperation("DELETE");
		o1.setRecord("#2");

		Observer o2 = new ObserverImpl();
		o2.setOperation("EDIT");
		o2.setRecord("#3");

		obs.add(o1);
		obs.add(o2);
		
		Subject subj = new SubjectImpl(obs);
		subj.notifyObservers();
	}
}
