package pokedex;

import java.util.List;
import java.util.Map;

public class PokemonAdapter {

    public static Pokemon toPokemon(String name, Integer number, Integer generation, Map genderRatio, List types,
                                    String classification, String height, String weight, Integer captureRate,
                                    Integer baseEggSteps, List abilities, Map experienceGrowth, Integer baseHappiness,
                                    Map ev, Boolean skyBattleEligible, String wildHoldItem, List eggGroups,
                                    Map evolution, List locations, Map baseStats) {

        Pokemon pokemon = new Pokemon();

        pokemon.setName(name);
        pokemon.setNumber(number);
        pokemon.setGeneration(generation);
        pokemon.setGenderRatio(genderRatio);
        pokemon.setTypes(types);
        pokemon.setClassification(classification);
        pokemon.setHeight(height);
        pokemon.setWeight(weight);
        pokemon.setCaptureRate(captureRate);
        pokemon.setBaseEggSteps(baseEggSteps);
        pokemon.setAbilities(abilities);
        pokemon.setExperienceGrowth(experienceGrowth);
        pokemon.setBaseHappiness(baseHappiness);
        pokemon.setEv(ev);
        pokemon.setSkyBattleEligible(skyBattleEligible);
        pokemon.setWildHoldItem(wildHoldItem);
        pokemon.setEggGroups(eggGroups);
        pokemon.setEvolution(evolution);
        pokemon.setLocations(locations);
        pokemon.setBaseStats(baseStats);

        return pokemon;
    }

}