package myobserver;

public class ObserverImpl implements Observer {

	private String operation;
	private String record;
	
	@Override
	public void update(String operation, String record) {
		System.out.println(String.format("Call for operation:%s, record:%s", operation, record));
	}

	@Override
	public String getOperation() {
		return operation;
	}

	@Override
	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String getRecord() {
		return record;
	}

	@Override
	public void setRecord(String record) {
		this.record = record;
	}
}
