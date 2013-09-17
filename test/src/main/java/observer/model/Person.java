package observer.model;

import observer.PersonMgr;

public class Person {

    private String firstName;
    private String lastName;
    public static final String FIRSTNAME = "firstName";
    public static final String LASTNAME = "lastName";
    
    PersonMgr mgr = PersonMgr.getInstance();
    
    public Person(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public String getFirstName() {

      return firstName;
    }

    public void setFirstName(String firstName) {
    	mgr.notifyListeners(this, 
          FIRSTNAME,
          this.firstName, 
          this.firstName = firstName);
      
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
    	mgr.notifyListeners(this, 
          LASTNAME, 
          this.lastName, 
          this.lastName = lastName);
    }
 }