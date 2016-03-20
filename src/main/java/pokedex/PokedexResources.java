package pokedex;

import org.glassfish.jersey.server.ResourceConfig;

public class PokedexResources extends ResourceConfig {
  public PokedexResources() {
    register(HealthResource.class);
  }
}
