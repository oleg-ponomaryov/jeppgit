package observer;

import java.util.ArrayList;
import java.util.List;

import observer.model.Person;

public class Main {


	  public static void main(String[] args) {
		  
		List<Person> pers = new ArrayList<Person>();
		pers.add(new Person("Lars", "Vogel"));
		pers.add(new Person("Jim", "Knopf"));
		  
	    PersonMgr model = PersonMgr.getInstance();
	    model.setPersons(pers);
	    
	    new PersonObserver(model);
	    // We change the first/last name of the person, observer will get notified
	    for (Person person : model.getPersons()) {
	        person.setLastName(person.getLastName() + "1");
	        person.setFirstName(person.getFirstName() + "1");
	    }
	  }
	} 
