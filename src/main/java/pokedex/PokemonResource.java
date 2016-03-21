package pokedex;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("pokemon")
public class PokemonResource {

    @GET
    @Produces("application/json")
    public static String get() { return Pokemon.get(); }

}
