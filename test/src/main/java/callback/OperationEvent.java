package callback;

public class OperationEvent extends CallbackEvent {
	@Override
	public void processEvent() {
		System.out.println("Performing operation event processing");
	}
}
