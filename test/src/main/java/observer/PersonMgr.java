package observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import observer.model.Person;

public class PersonMgr {
	  private List<Person> persons = 
			  new ArrayList<Person>();
	  private List<PropertyChangeListener> listeners = new ArrayList<PropertyChangeListener>();

	  private static final PersonMgr INSTANCE = new PersonMgr();

	  private PersonMgr() {
	  }
	  
	  public static PersonMgr getInstance() {
	      return INSTANCE;
	   }
	  
	  public List<Person> getPersons() {
	    return persons;
	  }

	  public void addChangeListener(PropertyChangeListener newListener) {
	    listeners.add(newListener);
	  }
	  
	  public void notifyListeners(Object object, String property, String oldValue, String newValue) {
		    for (PropertyChangeListener name : listeners) {
		      name.propertyChange(new PropertyChangeEvent(object, property, oldValue, newValue));
		    }
	  }
	  
	  public void setPersons(List<Person> pers) {
		  persons.addAll(pers);
	  }
}
