package pokedex;

import javax.ws.rs.*;

@Path("pokemon/{name}")
public class PokemonMemberResource {

    @GET
    @Produces("application/json")
    public String get(@PathParam("name") String name) {
        return PokemonService.get(name);
    }

    @DELETE
    public void delete(@PathParam("name") String name) {
        PokemonService.delete(name);
    }

}
