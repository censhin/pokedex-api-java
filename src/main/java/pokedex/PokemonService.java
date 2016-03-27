package pokedex;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

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

    public static void post(JSONObject body) {
        PokemonService.toPokemon(body);
//        dao.create(toPokemon(body));
    }

    private static Pokemon toPokemon(JSONObject body) {
        Map genderRatio = (Map)body.getJSONObject("genderRatio");
        Map experienceGrowth = (Map)body.getJSONObject("experienceGrowth");
        Map ev = (Map)body.getJSONObject("ev");
        Map evolution = (Map)body.getJSONObject("evolution");
        Map baseStats = (Map)body.getJSONObject("baseStats");

        List types = (List)body.getJSONArray("types");
        List abilities = (List)body.getJSONArray("abilities");
        List eggGroups = (List)body.getJSONArray("eggGroups");
        List locations = (List)body.getJSONArray("locations");

        return PokemonAdapter.toPokemon(
                body.getString("name"),
                body.getInt("number"),
                body.getInt("generation"),
                genderRatio,
                types,
                body.getString("classification"),
                body.getString("height"),
                body.getString("weight"),
                body.getInt("captureRate"),
                body.getInt("baseEggSteps"),
                abilities,
                experienceGrowth,
                body.getInt("baseHappiness"),
                ev,
                body.getBoolean("skyBattleEligible"),
                body.getString("wildHoldItem"),
                eggGroups,
                evolution,
                locations,
                baseStats
        );
    }

}
