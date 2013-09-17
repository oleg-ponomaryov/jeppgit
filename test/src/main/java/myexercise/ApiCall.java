package myexercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApiCall {
 	
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
                    createUpdateTask(resultPiece);
                }
                in.close();
             } catch (MalformedURLException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         // save the result
        createFinishTask(resultBuilder.toString());
     }

    protected void createUpdateTask(String input) {
		new UpdateActionImpl<String>().getExecutor().runTask(input);
    }

    protected void createFinishTask(String input) {
		new FinishActionImpl<String>().getExecutor().runTask(input);
    }
    
    
	public static void main(String... args) {

		ApiCall api = new ApiCall();
		
    	URL url = null;
    	try {
    	    url = new URL("https://dl.dropboxusercontent.com/u/42449039/test.json");
    	} catch (MalformedURLException e) {
    	    e.printStackTrace();
    	}
    	
    	api.doInBackground(url);
    	
	}
}
