package module11.task1;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Kiryl_Parfiankou on 3/27/2016.
 */
@ApplicationPath("resources")
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        //register(JacksonFeature.class);
        packages("module11.task1.resource");
    }
}
