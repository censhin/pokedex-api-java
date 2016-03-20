package pokedex;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("healthcheck")
public class HealthResource {

  @GET
  @Produces("text/plain")
  public String getHealthCheck() { return "I'm alive!"; }

}
