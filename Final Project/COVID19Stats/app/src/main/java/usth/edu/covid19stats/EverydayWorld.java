package usth.edu.covid19stats;

public class EverydayWorld {
    String day;
    int cases;

    public EverydayWorld(String day, int cases) {
        this.day = day;
        this.cases = cases;
    }

    @Override
    public String toString() {
        return "{" +
                "day='" + day + '\'' +
                ", cases=" + cases +
                '}';
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
}
