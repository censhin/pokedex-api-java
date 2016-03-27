package pokedex;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("pokemon")
public class PokemonResource {

    @GET
    @Produces("application/json")
    public static String get() { return PokemonService.get(); }

}
