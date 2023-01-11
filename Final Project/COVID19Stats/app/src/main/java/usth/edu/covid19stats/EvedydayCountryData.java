package usth.edu.covid19stats;

public class EvedydayCountryData {
    String day;
    int cases;
    int deaths;
    int recovered;

    public EvedydayCountryData(String day, int cases, int deaths, int recovered) {
        this.day = day;
        this.cases = cases;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    @Override
    public String toString() {
        return day +
                "\nCases: " + cases +
                "\nDeaths: " + deaths +
                "\nRecovered: " + recovered;
    }



    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }
}
