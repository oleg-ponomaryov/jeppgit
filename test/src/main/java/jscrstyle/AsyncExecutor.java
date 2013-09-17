package jscrstyle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncExecutor {
	
    protected void doInBackground(URL... urls) {
        int count = urls.length;
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            try {
                // Read all the text returned by the server
                InputStreamReader reader = new InputStreamReader(urls[i].openStream());
                BufferedReader in = new BufferedReader(reader);
                String resultPiece;
                while ((resultPiece = in.readLine()) != null) {
                    resultBuilder.append(resultPiece);
                    createTask("PROGRESS", resultPiece);
                }
                in.close();
             } catch (MalformedURLException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
        createTask("FINISHED", resultBuilder.toString());
     }
	

    private void createTask(final String action, final String tresult) {
    	//new Thread(
    	new AsyncTask<String>(new AsyncCallback<String>() {
			@Override
			public void onSuccess(String result) throws Exception {
				System.out.println("On Callback - > " + result);
				// testing errbacks
				//throw new Exception("Error in Callback #1");
			}

			@Override
			public void onFailure(Exception error) {
				System.out.println("Exception - > " + error.getLocalizedMessage());
			}
		}) {
			@Override
			public String executeTask() throws Exception {
				String s = "Action is:"+action+" Result:"+tresult;
				return s;
			}
		}
    	//).start();
    	.run();
    }
    
	public static void main(String[] args) throws MalformedURLException {

		/*
		new Thread(new AsyncTask<String>(new AsyncCallback<String>() {
			public void onSuccess(String result) throws Exception {
				System.out.println("On Callback - > " + result);
				// testing errbacks
				//throw new Exception("Error in Callback #1");
			}

			public void onFailure(Exception error) {
				System.out.println("Exception - > " + error.getLocalizedMessage());
			}
		}) {
			@Override
			public String executeTask() throws Exception {
				System.out
						.println("Doing Something complicated -> don't wait for me to complete.");
				return "Hello World";
			}
		}).start();
	*/
		
		AsyncExecutor ex = new AsyncExecutor();
		ex.doInBackground(new URL("https://dl.dropboxusercontent.com/u/42449039/test.json"));
		
		System.out.println("--DONE ! --");
	}
}
