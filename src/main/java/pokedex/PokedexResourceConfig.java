package pokedex;

import org.glassfish.jersey.server.ResourceConfig;

public class PokedexResourceConfig extends ResourceConfig {

    public PokedexResourceConfig() {
        register(HealthResource.class);
        register(PokemonCollectionResource.class);
        register(PokemonMemberResource.class);
    }

}
