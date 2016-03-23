package pokedex;

import java.util.Map;
import java.util.List;

public class Pokemon {

    private String name;
    private int number;
    private int generation;
    private Map<String, Float> genderRatio;
    private List<String> types;
    private String classification;
    private String height;
    private String weight;
    private int captureRate;
    private int baseEggSteps;
    private List<String> abilities;
    private ExperienceGrowth experienceGrowth;
    private int baseHappiness;
    private EffortValues ev;
    private boolean skyBattleEligible;
//    private Damage damage;
    private String wildHoldItem;
    private List<String> eggGroups;
    private Evolution evolution;
    private List<Locations> locations;
    private BaseStats baseStats;
    
    private class ExperienceGrowth {
        private int points;
        private String rate;
    }

    private class EffortValues {
        private String type;
        private int value;
    }

    private class Evolution {
        private String name;
        private int number;
        private int level
    }

    private class Locations {
        private String game;
        private String location;
    }

    private class BaseStats {
        private int hp;
        private int attack;
        private int defense;
        private int spAttack;
        private int spDefense;
        private int speed;
    }

}
