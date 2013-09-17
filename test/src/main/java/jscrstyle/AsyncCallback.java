package jscrstyle;

public interface AsyncCallback<T> {
	  
	  public void onSuccess(T result) throws Exception;
	  public void onFailure(Exception error);
	  
	}
