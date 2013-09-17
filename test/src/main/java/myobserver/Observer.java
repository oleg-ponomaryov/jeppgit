package myobserver;

public interface Observer {

	void update(String opeartion, String record);
	String getOperation();
	void setOperation(String operation);

	String getRecord();
	void setRecord(String record);
}
