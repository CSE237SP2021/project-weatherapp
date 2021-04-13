package code; 

import java.net.HttpURLConnection;
import java.util.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.net.*;
import java.io.*;
import java.text.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

// key: 0492835dd56389d17aac9f004e9f063b

public class WeatherData {
	
	private static String apiKey = "0492835dd56389d17aac9f004e9f063b";
	private static String zipQuery = "zip=?";
	private static String cityNameQuery = "city=?";
	private static String baseURL =  "http://api.openweathermap.org/data/2.5/weather?";
	private static String apiQuery = "&appid=";

	
	private static String createUrl(String zip) {
		return baseURL + zipQuery + ",US" + zip + apiQuery + apiKey; 
	}
	
    public static String makeRequest(String zip) throws IOException, InterruptedException {

        URL urlForGetRequest = new URL(createUrl(zip));
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        //conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
        int responseCode = conection.getResponseCode();


        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            // print result
            System.out.println("JSON String Result " + response.toString());
            //GetAndPost.POSTRequest(response.toString());
            return response.toString();
        } else {
            System.out.println("GET NOT WORKED");
        }
        return "no response";
    }

}