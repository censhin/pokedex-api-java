package pokedex;

import java.util.ArrayList;

public class Pokemon {

    public static String get() {
        ArrayList<String> pokemon = PokemonDao.get();
        return "{\"pokemon\": " + pokemon + "}";
    }

}
