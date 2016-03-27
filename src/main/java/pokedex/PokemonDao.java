package pokedex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class PokemonDao {

    private static MongoClient client = new MongoClient();
    private static MongoDatabase db = client.getDatabase("pokedex");

    public List<Pokemon> get() {
        MongoCursor<Document> cursor = db.getCollection("pokemon").find().iterator();
        return this.pokemonIterator(cursor);
    }

    public List<Pokemon> get(String name) {
        MongoCursor<Document> cursor = db.getCollection("pokemon").find(eq("name", name)).iterator();
        return this.pokemonIterator(cursor);
    }

    private List<Pokemon> pokemonIterator(MongoCursor<Document> cursor) {
        List<Pokemon> pokemon = new ArrayList<>();

        try {
            while (cursor.hasNext()) {
                pokemon.add(this.toPokemon(cursor.next()));
            }
        } finally {
            cursor.close();
        }

        return pokemon;
    }

    private Pokemon toPokemon(Document doc) {
        Pokemon poke = new Pokemon();

        Map genderRatio = doc.get("genderRatio", Map.class);
        Document experienceGrowth = doc.get("experienceGrowth", Document.class);
        Document ev = doc.get("ev", Document.class);
        Document evolution = doc.get("evolution", Document.class);
        Map baseStats = doc.get("baseStats", Map.class);

        List dbTypes = doc.get("types", List.class);
        List<String> types = new ArrayList<>();
        for(Object o : dbTypes) { types.add(o != null ? o.toString() : null); }

        List dbAbilities = doc.get("abilities", List.class);
        List<String> abilities = new ArrayList<>();
        for(Object o : dbAbilities) { abilities.add(o != null ? o.toString() : null); }

        List dbEggGroups = doc.get("eggGroups", List.class);
        List<String> eggGroups = new ArrayList<>();
        for(Object o : dbEggGroups) { eggGroups.add(o != null ? o.toString() : null); }

        List dbLocations = doc.get("locations", List.class);
        List<Map<String, String>> locations = new ArrayList<>();
        for(Object o : dbLocations) {
            if (o instanceof Document) {
                Map<String, String> m = new HashMap<>();
                m.put(((Document) o).get("game", String.class), ((Document) o).get("location", String.class));
                locations.add(m);
            }
        }

        poke.setName(doc.getString("name"));
        poke.setNumber(doc.getInteger("number"));
        poke.setGeneration(doc.getInteger("generation"));
        poke.setGenderRatio(genderRatio);
        poke.setTypes(types);
        poke.setClassification(doc.getString("classification"));
        poke.setHeight(doc.getString("height"));
        poke.setWeight(doc.getString("weight"));
        poke.setCaptureRate(doc.getInteger("captureRate"));
        poke.setBaseEggSteps(doc.getInteger("baseEggSteps"));
        poke.setAbilities(abilities);
        poke.setExperienceGrowth(
                experienceGrowth.get("points", Integer.class),
                experienceGrowth.get("rate", String.class)
        );
        poke.setBaseHappiness(doc.getInteger("baseHappiness"));
        poke.setEv(ev.get("type", String.class), ev.get("value", Integer.class));
        poke.setSkyBattleEligible(doc.getBoolean("skyBattleEligible"));
        poke.setWildHoldItem(doc.getString("wildHoldItem"));
        poke.setEggGroups(eggGroups);
        poke.setEvolution(
                evolution.get("name", String.class),
                evolution.get("number", Integer.class),
                evolution.get("level", Integer.class)
        );
        poke.setLocations(locations);
        poke.setBaseStats(baseStats);

        return poke;
    }

}
