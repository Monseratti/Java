import java.util.Arrays;

public class Country {
    String name;
    String continent;
    int numberOfPopulation;
    String phoneCode;
    String capitalName;
    String[] citiesName;

    public Country(String name, String continent, int numberOfPopulation, String phoneCode, String capitalName, String[] citiesName) {
        this.name = name;
        this.continent = continent;
        this.numberOfPopulation = numberOfPopulation;
        this.phoneCode = phoneCode;
        this.capitalName = capitalName;
        this.citiesName = citiesName;
    }

    @Override
    public String toString() {
        return "Country name is '" + name + '\'' +
                ", at continent '" + continent + '\'' +
                ", population " + numberOfPopulation +
                ", phoneCode '" + phoneCode + '\'' +
                ", capital is '" + capitalName + '\'' +
                ", cities: " + Arrays.toString(citiesName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getNumberOfPopulation() {
        return numberOfPopulation;
    }

    public void setNumberOfPopulation(int numberOfPopulation) {
        this.numberOfPopulation = numberOfPopulation;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public String[] getCitiesName() {
        return citiesName;
    }

    public void setCitiesName(String[] citiesName) {
        this.citiesName = citiesName;
    }
}
