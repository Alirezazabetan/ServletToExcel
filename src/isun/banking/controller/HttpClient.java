package isun.banking.controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    
    private static String SERVLET_ADDRESS = "http://localhost:8080/bank/HtmlCRUDServlet";

    public static String sendPost(String postBody) throws Exception {
        
        URL obj = new URL(SERVLET_ADDRESS);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "text/html"); // Send post request
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(postBody);
        out.flush();
        out.close();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + SERVLET_ADDRESS);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
