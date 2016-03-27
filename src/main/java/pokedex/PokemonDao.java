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

    public void create(Pokemon pokemon) {}

    public List<Pokemon> read() {
        MongoCursor<Document> cursor = db.getCollection("pokemon").find().iterator();
        return this.pokemonIterator(cursor);
    }

    public List<Pokemon> read(String name) {
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
        return PokemonAdapter.toPokemon(
                doc.getString("name"),
                doc.getInteger("number"),
                doc.getInteger("generation"),
                doc.get("genderRatio", Map.class),
                doc.get("types", List.class),
                doc.getString("classification"),
                doc.getString("height"),
                doc.getString("weight"),
                doc.getInteger("captureRate"),
                doc.getInteger("baseEggSteps"),
                doc.get("abilities", List.class),
                doc.get("experienceGrowth", Map.class),
                doc.getInteger("baseHappiness"),
                doc.get("ev", Map.class),
                doc.getBoolean("skyBattleEligible"),
                doc.getString("wildHoldItem"),
                doc.get("eggGroups", List.class),
                doc.get("evolution", Map.class),
                doc.get("locations", List.class),
                doc.get("baseStats", Map.class)
        );
    }

}
