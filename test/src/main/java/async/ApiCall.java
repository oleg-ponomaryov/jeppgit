package async;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiCall  {
    private OnTaskAction listener;
    private String result;
    public ApiCall(OnTaskAction listener){
        this.listener=listener;
    }
    protected Long doInBackground(URL... urls) {
        int count = urls.length;
        long totalSize = 0;
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            try {
                // Read all the text returned by the server
                InputStreamReader reader = new InputStreamReader(urls[i].openStream());
                BufferedReader in = new BufferedReader(reader);
                String resultPiece;
                while ((resultPiece = in.readLine()) != null) {
                    resultBuilder.append(resultPiece);
                    onProgressUpdate(resultPiece);                    
                }
                in.close();
             } catch (MalformedURLException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         // save the result
         this.result = resultBuilder.toString();
         onPostExecute(result);
         return totalSize;
     }
    
    protected void onProgressUpdate(String progress) {
        try {
            listener.onProgressUpdate(progress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // called after doInBackground finishes
    protected void onPostExecute(String result) {
        System.out.println("Result:"+this.result);
        try {
            // call callback
            listener.onTaskCompleted(this.result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
    	URL url = null;
    	try {
    	    url = new URL("https://dl.dropboxusercontent.com/u/42449039/test.json");
    	} catch (MalformedURLException e) {
    	    e.printStackTrace();
    	}
    	
    	OnTaskAction callback = new CallbackAction();
    	
    	ApiCall api = new ApiCall(callback);
    	api.doInBackground(url);
    }
}
