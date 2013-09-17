package jscrstyle;

import java.util.ArrayList;
import java.util.List;

public abstract class AsyncTask<T> implements Runnable {

	private List<AsyncCallback<T>> callbacks = new ArrayList<AsyncCallback<T>>();

	private boolean isTaskComplete;
	private List<Exception> exceptions = new ArrayList<Exception>();
	private T result;

	// override this method to create your async task.
	public abstract T executeTask() throws Exception;

	public AsyncTask() {
		// default constructor
	}

	public AsyncTask(AsyncCallback<T> callback) {
		callbacks.add(callback);
	}

	@Override
	public void run() {
		// execute the main task.
		try {
			result = executeTask();
			isTaskComplete = true;
			// execute callbacks
			for (AsyncCallback<T> callback : callbacks) {
				try {
					callback.onSuccess(result);
				} catch (Exception error) {
					exceptions.add(error);
				}
			}
		} catch (Exception error) {
			exceptions.add(error);
		}

		for (AsyncCallback<T> callback : callbacks) {
			for (Exception exception : exceptions) {
				// error back is invoked once per every exception
				callback.onFailure(exception);
			}
		}
	}

	public boolean isTaskComplete() {
		return isTaskComplete;
	}

	public void registerCallback(AsyncCallback<T> callback) {
		callbacks.add(callback);
	}

	public List<AsyncCallback<T>> getCallbacks() {
		return callbacks;
	}
}
