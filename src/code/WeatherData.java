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
private static String zipQuery = "zip=?";
private static String cityNameQuery = "city=?";
private static String baseURL =  "http://api.openweathermap.org/data/2.5/weather?";

public static String[] GetWeather() throws Exception {
    URL URLobject = new URL(baseURL + zipQuery + apiKey);
    HttpURLConnection htmlConnection = (HttpURLConnection) URLobject.openConnection();
    connection.setRequestMethod("GET");
}

int response = connection.getResponse();
if (response == HttpURLConnection.HTTP_OK) {
    BufferedReader inputR = new BufferedReader(
    new InputStreamReader(connection.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = inputR.readLine()) != null) {
        response.append(inputLine);
    }
    inputR.close();

    String json = response.toString();
    //Begin parsing json
    json = json.substring(json.indexOf("description"));
    // https://stackoverflow.com/questions/7683448/in-java-how-to-get-substring-from-a-string-till-a-character-c
    String noComma = StringUtils.substringBefore(json, ",");
    return noComma;
    }
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
