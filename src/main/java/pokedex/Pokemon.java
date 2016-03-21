package pokedex;

public class Pokemon {

    public static String get() { return "{\"pokemon\": " + PokemonDao.get() + "}"; }

}
