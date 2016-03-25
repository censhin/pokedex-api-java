package pokedex;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

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

        Document genderRatio = doc.get("genderRatio", Document.class);

        List dbTypes = doc.get("types", List.class);
        List<String> types = new ArrayList<>();
        for(Object o : dbTypes) { types.add(o != null ? o.toString() : null); }

        List dbAbilities = doc.get("abilities", List.class);
        List<String> abilities = new ArrayList<>();
        for(Object o : dbAbilities) { abilities.add(o != null ? o.toString() : null); }

        poke.setName(doc.getString("name"))
            .setNumber(doc.getInteger("number"))
            .setGeneration(doc.getInteger("generation"))
            .setGenderRatio(genderRatio.get("male", Float.class), genderRatio.get("female", Float.class))
            .setTypes(types)
            .setClassification(doc.getString("classification"))
            .setHeight(doc.getString("height"))
            .setWeight(doc.getString("weight"))
            .setCaptureRate(doc.getInteger("captureRate"))
            .setBaseEggSteps(doc.getInteger("baseEggSteps"))
            .setAbilities(abilities)
//            .setExperienceGrowth(doc.get("experienceGrowth", Pokemon<ExperienceGrowth>))
            .setBaseHappiness(doc.getInteger("baseHappiness"))
//            .setEv(doc.get("ev", Class<Pokemon.EffortValues> poke))
            .setSkyBattleEligible(doc.getBoolean("skyBattleEligible"))
            .setWildHoldItem(doc.getString("wildHoldItem"))
//            .setEggGroups(doc.get("eggGroups"))
//            .setEvolution(doc.get("evolution"))
//            .setLocations(doc.get("Locations"))
            /* .setBaseStats(doc.get("baseStats")) */;

        return poke;
    }

}
