package observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PersonObserver implements PropertyChangeListener {
    public PersonObserver(PersonMgr model) {
        model.addChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
       System.out.println("Changed property: " + event.getPropertyName() + " [old -> "
                 + event.getOldValue() + "] | [new -> " + event.getNewValue() +"]");
    }
}
