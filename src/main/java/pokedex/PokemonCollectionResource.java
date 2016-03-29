package pokedex;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("pokemon")
public class PokemonCollectionResource {

    @GET
    @Produces("application/json")
    public String get() {
        return PokemonService.get();
    }

    @POST
    @Consumes("application/json")
    public void post(Pokemon pokemon) {
        PokemonService.post(pokemon);
    }

}
