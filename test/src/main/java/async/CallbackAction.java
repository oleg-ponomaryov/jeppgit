package async;

public class CallbackAction implements OnTaskAction{
    @Override
	public void onTaskCompleted(String result) {
        System.out.println("Task is completed, result:"+result);
    }

	@Override
	public void onProgressUpdate(String progress) {
        System.out.println("Task is updated, result:"+progress);
	}
}