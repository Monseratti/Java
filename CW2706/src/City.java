public class City {
    String name;
    String region;
    String country;
    int numberOfPopulation;
    int index;
    String phoneCode;
    public City(String name, String region, String country, int numberOfPopulation, int index, String phoneCode) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.numberOfPopulation = numberOfPopulation;
        this.index = index;
        this.phoneCode = phoneCode;
    }
    @Override
    public String toString() {
        return "City name is" + name +
                ", region " + region +
                ", country " + country +
                ", populations " + numberOfPopulation +
                ", post index " + index +
                ", phone code " + phoneCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumberOfPopulation() {
        return numberOfPopulation;
    }

    public void setNumberOfPopulation(int numberOfPopulation) {
        this.numberOfPopulation = numberOfPopulation;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }
}
