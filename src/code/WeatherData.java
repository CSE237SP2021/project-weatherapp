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

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherData {
// key: 0492835dd56389d17aac9f004e9f063b

private static String apiKey = "0492835dd56389d17aac9f004e9f063b";
private static String baseURL =  "http://api.openweathermap.org/data/2.5/weather?";

    public JSONObject UsingZipcode(String zipcode) {
		String url = makingURL(WeatherApi.site, zipcode);
		return readJsonFromUrl(url);
	}

    private String makingURL(String baseUrl, String zipcode){
        String URL = baseUrl + "zip=" + zipcode + "?api_key=" + WeatherData.apiKey;
        return URL;
    }
    
    public static void main() {
        // create a client
    var client = HttpClient.newHttpClient();

    // create a request
    var request = HttpRequest.newBuilder(
       URI.create(baseURL + apiKey))
     .header("accept", "application/json")
     .build();

    // use the client to send the request
    var response = client.send(request, new JsonBodyHandler<>(APOD.class));

    // the response:
        System.out.println(response.body().get().description);
    }

}
