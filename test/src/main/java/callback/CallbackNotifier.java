package callback;

public class CallbackNotifier {

	private CallbackEvent event;
	
	public CallbackNotifier(CallbackEvent event) {
		this.event = event;
	}
	
	public void run() {
		this.event.processEvent();
	}
}
