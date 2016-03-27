package pokedex;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("pokemon/{name}")
public class PokemonMemberResource {

    @GET
    @Produces("application/json")
    public static String get(@PathParam("name") String name) {
        return PokemonService.get(name);
    }

}
