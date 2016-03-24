package pokedex;

import java.util.List;
import java.util.ArrayList;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCursor;

public class PokemonDao {

    private static MongoClient client = new MongoClient();
    private static MongoDatabase db = client.getDatabase("pokedex");

    public List<Pokemon> get() {
        MongoCursor<Document> cursor = db.getCollection("pokemon").find().iterator();
        List<Pokemon> pokemons = new ArrayList<>();

        try {
            while (cursor.hasNext()) { this.toPokemon(cursor.next()); }
        } finally {
            cursor.close();
        }

        return pokemons;
    }

    public Pokemon toPokemon(Document doc) {
        Pokemon poke = new Pokemon();

        poke.setName(doc.getString("name"))
            .setNumber(doc.getInteger("number"))
            .setGeneration(doc.getInteger("generation"))
//            .setGenderRatio(doc.get("genderRatio"));
//            .setTypes(doc.get("types", List<String>));
            .setClassification(doc.getString("classification"))
            .setHeight(doc.getString("height"))
            .setWeight(doc.getString("weight"))
            .setCaptureRate(doc.getInteger("captureRate"))
            .setBaseEggSteps(doc.getInteger("baseEggSteps"))
//            .setAbilities(doc.get("abilities", List<String>))
//            .setExperienceGrowth(doc.get("experienceGrowth", Pokemon<ExperienceGrowth>))
            .setBaseHappiness(doc.getInteger("baseHappiness"))
//            .setEv(doc.get("ev", Class<Pokemon.EffortValues> poke))
            .setSkyBattleEligible(doc.getBoolean("skyBattleEligible"))
            .setWildHoldItem(doc.getString("wildHoldItem"))
//            .setEggGroups(doc.get("eggGroups", doc))
//            .setEvolution(doc.get("evolution"))
//            .setLocations(doc.get("Locations"))
            /* .setBaseStats(doc.get("baseStats")) */;

        return poke;
    }

}
