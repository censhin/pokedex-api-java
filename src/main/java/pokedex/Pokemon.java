package pokedex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pokemon {

    private String name;
    private Integer number;
    private Integer generation;
    private GenderRatio genderRatio;
    private List<String> types;
    private String classification;
    private String height;
    private String weight;
    private Integer captureRate;
    private Integer baseEggSteps;
    private List<String> abilities;
    private ExperienceGrowth experienceGrowth;
    private Integer baseHappiness;
    private EffortValues ev;
    private Boolean skyBattleEligible;
//    private Damage damage; add when Damage class is defined
    private String wildHoldItem;
    private List<String> eggGroups;
    private Evolution evolution;
    private List<Map<String, String>> locations;
    private Map<String, Integer> baseStats;

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

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() { return this.number; }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getGeneration() { return this.generation; }

    public void setGeneration(Integer generation) {
        this.generation = generation;
    }

    public GenderRatio getGenderRatio() { return this.genderRatio; }

    public void setGenderRatio(Double male, Double female) {
        GenderRatio genderRatio = new GenderRatio();

        genderRatio.setMale(male);
        genderRatio.setFemale(female);

        this.genderRatio = genderRatio;
    }

    public List<String> getTypes() { return this.types; }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getClassification() { return this.classification; }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getHeight() { return this.height; }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() { return this.weight; }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getCaptureRate() { return this.captureRate; }

    public void setCaptureRate(int captureRate) {
        this.captureRate = captureRate;
    }

    public Integer getBaseEggSteps() { return this.baseEggSteps; }

    public void setBaseEggSteps(int baseEggSteps) {
        this.baseEggSteps = baseEggSteps;
    }

    public List<String> getAbilities() { return this.abilities; }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    public ExperienceGrowth getExperienceGrowth() { return this.experienceGrowth; }

    public void setExperienceGrowth(int points, String rate) {
        ExperienceGrowth experienceGrowth = new ExperienceGrowth();

        experienceGrowth.setPoints(points);
        experienceGrowth.setRate(rate);

        this.experienceGrowth = experienceGrowth;
    }

    public Integer getBaseHappiness() { return this.baseHappiness; }

    public void setBaseHappiness(int baseHappiness) {
        this.baseHappiness = baseHappiness;
    }

    public EffortValues getEv() { return this.ev; }

    public void setEv(String type, int value) {
        EffortValues ev = new EffortValues();

        ev.setType(type);
        ev.setValue(value);

        this.ev = ev;
    }

    public Boolean isSkyBattleEligible() { return this.skyBattleEligible; }

    public void setSkyBattleEligible(boolean skyBattleEligible) {
        this.skyBattleEligible = skyBattleEligible;
    }

    public String getWildHoldItem() { return this.wildHoldItem; }

    public void setWildHoldItem(String wildHoldItem) {
        this.wildHoldItem = wildHoldItem;
    }

    public List<String> getEggGroups() { return this.eggGroups; }

    public void setEggGroups(List<String> eggGroups) {
        this.eggGroups = eggGroups;
    }

    public Evolution getEvolution() { return this.evolution; }

    public void setEvolution(String name, int number, int level) {
        Evolution evolution = new Evolution();


        evolution.setName(name);
        evolution.setNumber(number);
        evolution.setLevel(level);

        this.evolution = evolution;
    }

    public List<Map<String, String>> getLocations() { return this.locations; }

    public void setLocations(List<Map<String, String>> locations) {
        this.locations = locations;
    }

    public Map<String, Integer> getBaseStats() { return this.baseStats; }

    public void setBaseStats(Map stats) {
        Map<String, Integer> baseStats = new HashMap<>();

        baseStats.put("hp", ((Integer)stats.get("hp")));
        baseStats.put("attack", ((Integer)stats.get("attack")));
        baseStats.put("defense", ((Integer)stats.get("defense")));
        baseStats.put("spAttack", ((Integer)stats.get("spAttack")));
        baseStats.put("spDefense", ((Integer)stats.get("spDefense")));
        baseStats.put("speed", ((Integer)stats.get("speed")));

        this.baseStats = baseStats;
    }

    public class GenderRatio {
        private Double male;
        private Double female;

        public GenderRatio() {
            this.male = -1.0;
            this.female = -1.0;
        }

        public Double getMale() { return this.male; }

        public void setMale(Double ratio) {
            this.male = ratio;
        }

        public Double getFemale() { return this.female; }

        public void setFemale(Double ratio) {
            this.female = ratio;
        }
    }

    public class ExperienceGrowth {
        private int points;
        private String rate;

        public ExperienceGrowth() {
            this.points = -1;
            this.rate = null;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }
    }

    public class EffortValues {
        private String type;
        private int value;

        public EffortValues() {
            this.type = null;
            this.value = -1;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public class Evolution {
        private String name;
        private int number;
        private int level;

        public Evolution() {
            this.name = null;
            this.number = -1;
            this.level = -1;
        }

        public String getName() {
            return name;
        }

        public int getNumber() {
            return number;
        }

        public int getLevel() {
            return level;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }
}
