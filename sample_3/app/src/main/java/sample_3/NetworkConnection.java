package sample_3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkConnection{

    String mUrl;
    String mCharset = "UTF-8";
    String mQuery;

    NetworkConnection() throws UnsupportedEncodingException{        
        mUrl = "https://github.com/JacksonFurrier/Software-quality-and-testing";

        String vParamOne = "value1";
        String vParamTwo = "value2";

         mQuery = String.format("param1=%s&param2=%s", 
             URLEncoder.encode(vParamOne, mCharset), 
             URLEncoder.encode(vParamTwo, mCharset));
    }

    NetworkConnection( String aUrl ) throws UnsupportedEncodingException
    {
        mUrl = aUrl;
        String vParamOne = "value1";
        String vParamTwo = "value2";

         mQuery = String.format("param1=%s&param2=%s", 
             URLEncoder.encode(vParamOne, mCharset), 
             URLEncoder.encode(vParamTwo, mCharset));
    }

    public String GetHttpRequest() throws MalformedURLException, IOException{
        URLConnection vConnection = new URL( mUrl + "?" + mQuery).openConnection();
        vConnection.setRequestProperty("Accept-Charset", mCharset);

        InputStream vResponse = vConnection.getInputStream( );

        try (Scanner scanner = new Scanner( vResponse )) {
            String vResponseBody = scanner.useDelimiter("\\A").next();
            return vResponseBody;
        }
        
     }
}