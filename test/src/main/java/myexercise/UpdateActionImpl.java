package myexercise;

public class UpdateActionImpl<T> implements Action<T> {
	
	private TaskExecutor<T> executor;
	
	public UpdateActionImpl() {
		executor = new TaskExecutor<T>(this) {
			@Override
			protected void execute() {
				System.out.println("Call to execute an UPDATE task...");
			}
			
		};
	}
	
	@Override
	public void onActionPerformed(T input) {
		System.out.println("UPDATE Action has been performed, the input is:"+input);
	}
	
	@Override
	public TaskExecutor<T> getExecutor() {
		return executor;
	}
}
