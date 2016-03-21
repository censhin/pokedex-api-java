package pokedex;

import java.util.ArrayList;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCursor;

public class PokemonDao {

    private static MongoClient mongoClient = new MongoClient();
    private static MongoDatabase db = mongoClient.getDatabase("pokedex");

    public static ArrayList<String> get() {
        MongoCursor<Document> cursor = db.getCollection("pokemon").find().iterator();
        ArrayList<String> data = new ArrayList<String>();

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
