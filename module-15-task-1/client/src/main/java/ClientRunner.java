import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;
import task1.domain.Person;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Kiryl_Parfiankou on 3/27/2016.
 */
public class ClientRunner {

    public static String JSON_CONTENT_TYPE = "application/json";

    public static String CONTENT_TYPE_PARAM = "Content-Type";

    public static void main(String[] str) throws Exception{
        System.out.println("Module 15. Test Client.");

        String url = "http://localhost:8080/rest-api-1.0-SNAPSHOT/resources/persons";
        sendGet(url);

        Person person = new Person("lastName", "FirstName", "login1", "Email", 30, "M");
        sendPost(url, person);

        Person person2 = new Person("lastName", "FirstName", "login2", "Email", 30, "M");
        sendPost(url, person2);

        sendGet(url);

        sendDelete(url, "login5");

        sendGet(url);

        person2 = new Person("lastName2", "FirstName2", "login2", "Email", 30, "M");
        sendPut(url, person2);

        sendGet(url);
    }


    public static void sendGet(String url) throws Exception{

        URL urlObj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty(CONTENT_TYPE_PARAM, JSON_CONTENT_TYPE);

        int responseCode = con.getResponseCode();
        System.out.println("Sending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;

        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();
        System.out.println(response.toString());
    }

    public static void sendPost(String url, Person person) throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        String personString = mapper.writeValueAsString(person);

        Client client = ClientBuilder.newClient(new ClientConfig());
        WebTarget webTarget = client.target(url);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        invocationBuilder.header(CONTENT_TYPE_PARAM, JSON_CONTENT_TYPE);

        Response response = invocationBuilder.post(Entity.entity(personString, MediaType.APPLICATION_JSON_TYPE));

        System.out.println("Sending 'POST' request to " + url);
        System.out.println("Response Code : " + response.getStatus());
    }

    public static void sendDelete(String url, String login) {

        Client client = ClientBuilder.newClient(new ClientConfig());
        WebTarget webTarget = client.target(url);
        WebTarget personWithLogin = webTarget.path(login);

        Invocation.Builder invocationBuilder = personWithLogin.request(MediaType.APPLICATION_JSON_TYPE);
        invocationBuilder.header(CONTENT_TYPE_PARAM, MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.delete();

        System.out.println("Sending 'DELETE' request to " + url);
        System.out.println("Response Code : " + response.getStatus());
    }

    public static void sendPut(String url, Person person) {

        String personString = null;
        StringWriter sw = new StringWriter();

        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.marshal(person, sw);
            personString = sw.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        Client client = ClientBuilder.newClient(new ClientConfig());
        WebTarget webTarget = client.target(url);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        invocationBuilder.header(CONTENT_TYPE_PARAM, MediaType.APPLICATION_XML);

        Response response = invocationBuilder.put(Entity.entity(personString, MediaType.APPLICATION_XML_TYPE));

        System.out.println("Sending 'PUT' request to " + url);
        System.out.println("Response Code : " + response.getStatus());
    }
}
