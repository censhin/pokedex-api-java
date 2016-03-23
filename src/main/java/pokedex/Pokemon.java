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

    public void setName(String name) { this.name = name; }

    public int getNumber() { return this.number; }

    public void setNumber(int number) { this.number = number; }

    public int getGeneration() { return this.generation; }

    public void setGeneration(int generation) { this.generation = generation; }

    public GenderRatio getGenderRatio() { return this.genderRatio; }

    public void setGenderRatio(GenderRatio genderRatio) { this.genderRatio = genderRatio; }

    public List<String> getTypes() { return this.types; }

    public void setTypes(List<String> types) { this.types = types; }

    public String getClassification() { return this.classification; }

    public void setClassification(String classification) { this.classification = classification; }

    public String getHeight() { return this.height; }

    public void setHeight(String height) { this.height = height; }

    public String getWeight() { return this.weight; }

    public void setWeight(String weight) { this.weight = weight; }

    public int getCaptureRate() { return this.captureRate; }

    public void setCaptureRate(int captureRate) { this.captureRate = captureRate; }

    public int getBaseEggSteps() { return this.baseEggSteps; }

    public void setBaseEggSteps(int baseEggSteps) { this.baseEggSteps = baseEggSteps; }

    public List<String> getAbilities() { return this.abilities; }

    public void setAbilities(List<String> abilities) { this.abilities = abilities; }

    public ExperienceGrowth getExperienceGrowth() { return this.experienceGrowth; }

    public void setExperienceGrowth(ExperienceGrowth experienceGrowth) { this.experienceGrowth = experienceGrowth; }

    public int getBaseHappiness() { return this.baseHappiness; }

    public void setBaseHappiness(int baseHappiness) { this.baseHappiness = baseHappiness; }

    public EffortValues getEv() { return this.ev; }

    public void setEv(EffortValues ev) { this.ev = ev; }

    public boolean isSkyBattleEligible() { return this.skyBattleEligible; }

    public void setSkyBattleEligible(boolean skyBattleEligible) { this.skyBattleEligible = skyBattleEligible; }

    public String getWildHoldItem() { return this.wildHoldItem; }

    public void setWildHoldItem(String wildHoldItem) { this.wildHoldItem = wildHoldItem; }

    public List<String> getEggGroups() { return this.eggGroups; }

    public void setEggGroups(List<String> eggGroups) { this.eggGroups = eggGroups; }

    public Evolution getEvolution() { return this.evolution; }

    public void setEvolution(Evolution evolution) { this.evolution = evolution; }

    public List<Locations> getLocations() { return this.locations; }

    public void setLocations(List<Locations> locations) { this.locations = locations; }

    public BaseStats getBaseStats() { return this.baseStats; }

    public void setBaseStats(BaseStats baseStats) { this.baseStats = baseStats; }

    private class GenderRatio {
        private float male;
        private float female;
    }

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
        private int level;
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
