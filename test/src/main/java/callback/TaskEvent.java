package callback;

public class TaskEvent extends CallbackEvent {
	@Override
	public void processEvent() {
		System.out.println("Performing task event processing");
	}
}
