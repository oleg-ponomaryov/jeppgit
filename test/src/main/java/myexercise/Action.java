package myexercise;

public interface Action<T> {
	void onActionPerformed(T input);

	TaskExecutor<T> getExecutor();
}
