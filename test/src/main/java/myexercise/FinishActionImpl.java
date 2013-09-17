package myexercise;

public class FinishActionImpl<T> implements Action<T> {
	
	private TaskExecutor<T> executor;
	
	public FinishActionImpl() {
		executor = new TaskExecutor<T>(this) {
			@Override
			protected void execute() {
				System.out.println("Call to execute a FINISH task...");
			}
			
		};
	}
	
	@Override
	public void onActionPerformed(T input) {
		System.out.println("FINISH Action has been performed, the input is:"+input);
	}
	
	@Override
	public TaskExecutor<T> getExecutor() {
		return executor;
	}
}
