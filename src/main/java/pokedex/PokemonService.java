package pokedex;

import java.util.List;

import org.json.JSONArray;

public class PokemonService {

    public static String get() {
        PokemonDao dao = new PokemonDao();
        List<Pokemon> pokemon = dao.get();
        JSONArray payload = new JSONArray(pokemon);
        return "{\"pokemon\": " + payload + "}";
    }

}
