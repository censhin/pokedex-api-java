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

    public static List<Pokemon> get() {
        MongoCursor<Document> cursor = db.getCollection("pokemon").find().iterator();
        List<Pokemon> data = new ArrayList<>();

        try {
            while (cursor.hasNext()) {
                data.add(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        return data;
    }

}
