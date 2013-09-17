package async;

public interface OnTaskAction{
    void onTaskCompleted(String result);
    void onProgressUpdate(String progress);
}
