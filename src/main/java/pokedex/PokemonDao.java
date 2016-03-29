package pokedex;

import java.util.ArrayList;
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

    public void create(Pokemon pokemon) {
        Document d = this.fromPokemon(pokemon);
        db.getCollection("pokemon").insertOne(d);
    }

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

    private Document fromPokemon(Pokemon pokemon) {
        Document doc = new Document();

        Pokemon.ExperienceGrowth experienceGrowth = pokemon.getExperienceGrowth();
        Pokemon.EffortValues ev = pokemon.getEv();
        Pokemon.Evolution evolution = pokemon.getEvolution();

        doc.append("name", pokemon.getName())
           .append("number", pokemon.getNumber())
           .append("generation", pokemon.getGeneration())
           .append("genderRatio", pokemon.getGenderRatio())
           .append("types", pokemon.getTypes())
           .append("classification", pokemon.getClassification())
           .append("height", pokemon.getHeight())
           .append("weight", pokemon.getWeight())
           .append("captureRate", pokemon.getCaptureRate())
           .append("baseEggSteps", pokemon.getBaseEggSteps())
           .append("abilities", pokemon.getAbilities())
           .append("experienceGrowth", new Document().append("points", experienceGrowth.getPoints())
                                                     .append("rate", experienceGrowth.getRate()))
           .append("baseHappiness", pokemon.getBaseHappiness())
           .append("ev", new Document().append("type", ev.getType())
                                       .append("value", ev.getValue()))
           .append("skyBattleEligible", pokemon.isSkyBattleEligible())
           .append("wildHoldItem", pokemon.getWildHoldItem())
           .append("eggGroups", pokemon.getEggGroups())
           .append("evolution", new Document().append("name", evolution.getName())
                                              .append("number", evolution.getNumber())
                                              .append("level", evolution.getLevel()))
           .append("locations", pokemon.getLocations())
           .append("baseStats", pokemon.getBaseStats());

        return doc;
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
