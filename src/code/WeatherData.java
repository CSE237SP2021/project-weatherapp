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
	private static String zipQuery = "zip=";
    private static String cityNameQuery = "q=";
	private static String baseURL =  "http://api.openweathermap.org/data/2.5/weather?";
	private static String apiQuery = "&appid=";

	
	private static String createZipUrl(String zip) {
		return baseURL + zipQuery + zip + ",US" + apiQuery + apiKey; 
	}

    private static String createCityUrl(String city){
        return baseURL + cityNameQuery + city + apiQuery + apiKey; 
    }
	
    public static String makeRequest(String zip, boolean hasZipCode) throws IOException, InterruptedException {

        URL urlForGetRequest; 
        if(!hasZipCode){
            urlForGetRequest = new URL(createCityUrl(zip));
        }else{
            urlForGetRequest = new URL(createZipUrl(zip));
        }
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
            
            String responseString = response.toString();
            
//            Searching for description in the JSON and added to the response string
            int start = responseString.indexOf("description") + 14;
            int end = responseString.indexOf("\"", start);
            
            String returnString = responseString.substring(start, end);
            
//            Searching for temp_min and adding to response string
            start = responseString.indexOf("temp_min") + 10;
            end = responseString.indexOf(",", start);
            
            double kelvin_min = Double.parseDouble(responseString.substring(start, end));
            double fahrenheit_min = ((kelvin_min - 273.15) * (9/5)) + 32;
  
            returnString += " with a low of " + (Math.round(fahrenheit_min));
            
//          Searching for temp_max and adding to response string
            start = responseString.indexOf("temp_max") + 10;
            end = responseString.indexOf(",", start);
            
            double kelvin_max = Double.parseDouble(responseString.substring(start, end));
            double fahrenheit_max = ((kelvin_max - 273.15) * (9/5)) + 32;
            
            returnString += " and a high of " + (Math.round(fahrenheit_max) + ". ");
         
//            returns the description of weather, the min and the max temperature
            return returnString;

        } else {
//        	if get request failed
            System.out.println("GET NOT WORKED");
        }
        return "no response";
    }

}