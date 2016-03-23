package pokedex;

import java.util.List;

public class PokemonService {

    public static String get() {
        List<Pokemon> pokemon = PokemonDao.get();
        return "{\"pokemon\": " + pokemon + "}";
    }

}
