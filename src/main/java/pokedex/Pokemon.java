package pokedex;

import java.util.List;

public class Pokemon {

    private String name;
    private int number;
    private int generation;
    private GenderRatio genderRatio;
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
//    private Damage damage; add when Damage class is defined
    private String wildHoldItem;
    private List<String> eggGroups;
    private Evolution evolution;
    private List<Locations> locations;
    private BaseStats baseStats;

    public Pokemon() {
        this.name = null;
        this.number = -1;
        this.generation = -1;
        this.genderRatio = null;
        this.types = null;
        this.classification = null;
        this.height = null;
        this.weight = null;
        this.captureRate = -1;
        this.baseEggSteps = -1;
        this.abilities = null;
        this.experienceGrowth = null;
        this.baseHappiness = -1;
        this.ev = null;
        this.skyBattleEligible = false;
        this.wildHoldItem = null;
        this.eggGroups = null;
        this.evolution = null;
        this.locations = null;
        this.baseStats = null;
    }

    public String getName() { return this.name; }

    public Pokemon setName(String name) {
        this.name = name;
        return this;
    }

    public int getNumber() { return this.number; }

    public Pokemon setNumber(int number) {
        this.number = number;
        return this;
    }

    public int getGeneration() { return this.generation; }

    public Pokemon setGeneration(int generation) {
        this.generation = generation;
        return this;
    }

    public GenderRatio getGenderRatio() { return this.genderRatio; }

    public Pokemon setGenderRatio(GenderRatio genderRatio) {
        this.genderRatio = genderRatio;
        return this;
    }

    public List<String> getTypes() { return this.types; }

    public Pokemon setTypes(List<String> types) {
        this.types = types;
        return this;
    }

    public String getClassification() { return this.classification; }

    public Pokemon setClassification(String classification) {
        this.classification = classification;
        return this;
    }

    public String getHeight() { return this.height; }

    public Pokemon setHeight(String height) {
        this.height = height;
        return this;
    }

    public String getWeight() { return this.weight; }

    public Pokemon setWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public int getCaptureRate() { return this.captureRate; }

    public Pokemon setCaptureRate(int captureRate) {
        this.captureRate = captureRate;
        return this;
    }

    public int getBaseEggSteps() { return this.baseEggSteps; }

    public Pokemon setBaseEggSteps(int baseEggSteps) {
        this.baseEggSteps = baseEggSteps;
        return this;
    }

    public List<String> getAbilities() { return this.abilities; }

    public Pokemon setAbilities(List<String> abilities) {
        this.abilities = abilities;
        return this;
    }

    public ExperienceGrowth getExperienceGrowth() { return this.experienceGrowth; }

    public Pokemon setExperienceGrowth(ExperienceGrowth experienceGrowth) {
        this.experienceGrowth = experienceGrowth;
        return this;
    }

    public int getBaseHappiness() { return this.baseHappiness; }

    public Pokemon setBaseHappiness(int baseHappiness) {
        this.baseHappiness = baseHappiness;
        return this;
    }

    public EffortValues getEv() { return this.ev; }

    public Pokemon setEv(EffortValues ev) {
        this.ev = ev;
        return this;
    }

    public boolean isSkyBattleEligible() { return this.skyBattleEligible; }

    public Pokemon setSkyBattleEligible(boolean skyBattleEligible) {
        this.skyBattleEligible = skyBattleEligible;
        return this;
    }

    public String getWildHoldItem() { return this.wildHoldItem; }

    public Pokemon setWildHoldItem(String wildHoldItem) {
        this.wildHoldItem = wildHoldItem;
        return this;
    }

    public List<String> getEggGroups() { return this.eggGroups; }

    public Pokemon setEggGroups(List<String> eggGroups) {
        this.eggGroups = eggGroups;
        return this;
    }

    public Evolution getEvolution() { return this.evolution; }

    public Pokemon setEvolution(Evolution evolution) {
        this.evolution = evolution;
        return this;
    }

    public List<Locations> getLocations() { return this.locations; }

    public Pokemon setLocations(List<Locations> locations) {
        this.locations = locations;
        return this;
    }

    public BaseStats getBaseStats() { return this.baseStats; }

    public Pokemon setBaseStats(BaseStats baseStats) {
        this.baseStats = baseStats;
        return this;
    }

    public class GenderRatio {
        private float male;
        private float female;
    }

    public class ExperienceGrowth {
        private int points;
        private String rate;
    }

    public class EffortValues {
        private String type;
        private int value;
    }

    public class Evolution {
        private String name;
        private int number;
        private int level;
    }

    public class Locations {
        private String game;
        private String location;
    }

    public class BaseStats {
        private int hp;
        private int attack;
        private int defense;
        private int spAttack;
        private int spDefense;
        private int speed;
    }

}
