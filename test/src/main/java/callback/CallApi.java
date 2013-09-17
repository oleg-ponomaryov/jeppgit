package callback;

import java.util.ArrayList;
import java.util.List;

public class CallApi {

	public static void main(String...args) {
		
		List<CallbackEvent> ls = 
				new ArrayList<CallbackEvent>(); 
		
		ls.add(new TaskEvent());
		ls.add(new OperationEvent());
		
		for (CallbackEvent ev : ls) {
			ev.processEvent();
		}
		
	}
}
