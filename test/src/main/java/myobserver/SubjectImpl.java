package myobserver;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements  Subject {

	private List<Observer> observers = new ArrayList<Observer>();  
	
	public SubjectImpl(List<Observer> obs) {
		observers.addAll(obs); 
	}
	
	@Override
	public void addObserver(Observer o) {
		observers.add(o); 
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o); 
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers) {
			o.update(o.getOperation(),o.getRecord());
		}
	}
}
