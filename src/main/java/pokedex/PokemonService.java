package pokedex;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;

public class PokemonService {

    private static PokemonDao dao = new PokemonDao();

    public static String get() {
        List<Pokemon> pokemon = dao.read();
        JSONArray payload = new JSONArray(pokemon);

        return "{\"pokemon\": " + payload + "}";
    }

    public static String get(String name) {
        List<Pokemon> pokemon = dao.read(name);
        JSONArray payload = new JSONArray(pokemon);

        if(payload.length() == 1) {
            return payload.get(0).toString();
        }

        return "{\"pokemon\": " + payload + "}";
    }

    public static void post(Pokemon body) {
        dao.create(body);
    }

    public static void put(String name, Map<String, ?> body) {
        dao.update(name, body);
    }

    public static void delete(String name) {
        dao.delete(name);
    }

}
