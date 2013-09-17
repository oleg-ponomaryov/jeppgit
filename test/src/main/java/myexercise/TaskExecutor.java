package myexercise;

import java.util.ArrayList;
import java.util.List;

public abstract class TaskExecutor<T> {

	private final List<Action<T>> listeners = new ArrayList<Action<T>>(); 

	public TaskExecutor (Action<T> action) {
		listeners.add(action);
	}
	
	protected abstract void execute(); 
	
	public void runTask(T obj) {
		execute();
		for (Action<T> l : listeners) {
			l.onActionPerformed(obj);
		}
	}
}
