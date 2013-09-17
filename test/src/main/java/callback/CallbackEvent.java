package callback;

public abstract class CallbackEvent {

	private CallbackNotifier notifier;
	
	public CallbackEvent() {
		notifier = new CallbackNotifier(this); 
	}
	
	abstract void  processEvent();
	
	public CallbackNotifier getNotifier() {
		return notifier;
	}
}
