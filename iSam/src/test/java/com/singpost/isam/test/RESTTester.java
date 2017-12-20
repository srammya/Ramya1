package com.singpost.isam.test;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 
public class RESTTester {
 
public static void main (String args[]) {
 
// This is request which we are sending to server 
String restURL_XML = "http://parabank.parasoft.com/parabank/services/bank/customers/12212/";
 
// sending request and we are passing parameter in url itself
String restURL_JSON = "http://api.openweathermap.org/data/2.5/weather?q=Amsterdam";
 
try {
 
testStatusCode(restURL_XML);
testStatusCode(restURL_JSON);
testMimeType(restURL_XML,"application/xml");
testMimeType(restURL_JSON,"application/json");
testContent(restURL_XML,"lastName","Smith");
testContentJSON(restURL_JSON,"name","Amsterdam");
 
} catch (ClientProtocolException e) {

e.printStackTrace();
} catch (IOException e) {

e.printStackTrace();
} catch (SAXException e) {

e.printStackTrace();
} catch (ParserConfigurationException e) {

e.printStackTrace();
} catch (JSONException e) {

e.printStackTrace();
}
}
 
public static void testStatusCode(String restURL) throws ClientProtocolException, IOException {
 
HttpUriRequest request = new HttpGet(restURL);
HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
 System.out.println(httpResponse.getStatusLine().getStatusCode()+HttpStatus.SC_OK);
//Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_OK);
}
 
public static void testMimeType(String restURL, String expectedMimeType) throws ClientProtocolException, IOException {
 
HttpUriRequest request = new HttpGet(restURL);
HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
 System.out.println(ContentType.getOrDefault(httpResponse.getEntity()).getMimeType());
//Assert.assertEquals(expectedMimeType,ContentType.getOrDefault(httpResponse.getEntity()).getMimeType());
}
 
public static void testContent(String restURL, String element, String expectedValue) throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {
 
 
Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(restURL);
NodeList nodelist = doc.getElementsByTagName(element);
 System.out.println(nodelist.item(0).getTextContent());
//Assert.assertEquals(expectedValue,nodelist.item(0).getTextContent()); 
}
 
public static void testContentJSON(String restURL, String element, String expectedValue) throws ClientProtocolException, IOException, SAXException, ParserConfigurationException, JSONException {
 
HttpUriRequest request = new HttpGet(restURL);
HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
 
// Convert the response to a String format
String result = EntityUtils.toString(httpResponse.getEntity());
 
// Convert the result as a String to a JSON object
JSONObject jo = new JSONObject(result);
jo.getJSONObject(result.toString());
 System.out.println(jo.getString(element));
//Assert.assertEquals(expectedValue, jo.getString(element));
 
}
 
}