package usth.edu.covid19stats;

public class CountryDataReportModel {

    private String country;
    private int cases;
    private int todayCases;
    private int deaths;
    private int todayDeaths;
    private int recovered;
    private int todayRecovered;
    private int active;
    private int critical;
    private int casesPerOneMillion;
    private int deathsPerOneMillion;
    private int tests;
    private int testsPerOneMillion;
    private int population;
    private String continent;
    private int oneCasePerPeople;
    private int oneDeathPerPeople;
    private int oneTestPerPeople;
    private int activePerOneMillion;
    private int recoveredPerOneMillion;
    private int criticalPerOneMillion;

    public CountryDataReportModel(String country,
                                  int cases,
                                  int todayCases,
                                  int deaths,
                                  int todayDeaths,
                                  int recovered,
                                  int todayRecovered,
                                  int active,
                                  int critical,
                                  int casesPerOneMillion,
                                  int deathsPerOneMillion,
                                  int tests,
                                  int testsPerOneMillion,
                                  int population,
                                  String continent,
                                  int oneCasePerPeople,
                                  int oneDeathPerPeople,
                                  int oneTestPerPeople,
                                  int activePerOneMillion,
                                  int recoveredPerOneMillion,
                                  int criticalPerOneMillion) {
        this.country = country;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
        this.active = active;
        this.critical = critical;
        this.casesPerOneMillion = casesPerOneMillion;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.tests = tests;
        this.testsPerOneMillion = testsPerOneMillion;
        this.population = population;
        this.continent = continent;
        this.oneCasePerPeople = oneCasePerPeople;
        this.oneDeathPerPeople = oneDeathPerPeople;
        this.oneTestPerPeople = oneTestPerPeople;
        this.activePerOneMillion = activePerOneMillion;
        this.recoveredPerOneMillion = recoveredPerOneMillion;
        this.criticalPerOneMillion = criticalPerOneMillion;
    }

    public CountryDataReportModel() {
    }

    @Override
    public String toString() {
        return "country='" + country + ':' +
                "\n cases=" + cases +
                "\n todayCases=" + todayCases +
                "\n deaths=" + deaths +
                "\n todayDeaths=" + todayDeaths +
                "\n recovered=" + recovered +
                "\n todayRecovered=" + todayRecovered +
                "\n active=" + active +
                "\n critical=" + critical +
                "\n casesPerOneMillion=" + casesPerOneMillion +
                "\n deathsPerOneMillion=" + deathsPerOneMillion +
                "\n tests=" + tests +
                "\n testsPerOneMillion=" + testsPerOneMillion +
                "\n population=" + population +
                "\n continent='" + continent + '\'' +
                "\n oneCasePerPeople=" + oneCasePerPeople +
                "\n oneDeathPerPeople='" + oneDeathPerPeople + '\'' +
                "\n oneTestPerPeople=" + oneTestPerPeople +
                "\n activePerOneMillion=" + activePerOneMillion +
                "\n recoveredPerOneMillion=" + recoveredPerOneMillion +
                "\n criticalPerOneMillion=" + criticalPerOneMillion;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(int todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public int getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(int casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public int getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(int deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public int getTests() {
        return tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }

    public int getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(int testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getOneCasePerPeople() {
        return oneCasePerPeople;
    }

    public void setOneCasePerPeople(int oneCasePerPeople) {
        this.oneCasePerPeople = oneCasePerPeople;
    }

    public int getOneDeathPerPeople() {
        return oneDeathPerPeople;
    }

    public void setOneDeathPerPeople(int oneDeathPerPeople) {
        this.oneDeathPerPeople = oneDeathPerPeople;
    }

    public int getOneTestPerPeople() {
        return oneTestPerPeople;
    }

    public void setOneTestPerPeople(int oneTestPerPeople) {
        this.oneTestPerPeople = oneTestPerPeople;
    }

    public int getActivePerOneMillion() {
        return activePerOneMillion;
    }

    public void setActivePerOneMillion(int activePerOneMillion) {
        this.activePerOneMillion = activePerOneMillion;
    }

    public int getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    public void setRecoveredPerOneMillion(int recoveredPerOneMillion) {
        this.recoveredPerOneMillion = recoveredPerOneMillion;
    }

    public int getCriticalPerOneMillion() {
        return criticalPerOneMillion;
    }

    public void setCriticalPerOneMillion(int criticalPerOneMillion) {
        this.criticalPerOneMillion = criticalPerOneMillion;
    }
}
