package usth.edu.covid19stats;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CovidDataService {

    Context context;        //Initialize the object


    public CovidDataService(Context context) {
        this.context = context;
    }

    public interface GetCountryResponseListener {
        void onError(String message);

        void onResponse(List<EvedydayCountryData> everydayReport);
    }
    public void getCountry(String countryAndDateInput, GetCountryResponseListener getCountryResponseListener) {
        // Instantiate the RequestQueue.
        String[] countryAndDate = countryAndDateInput.split(",");
        if (countryAndDate.length == 1)
        {
            Toast.makeText(context, "Please type the number of day", Toast.LENGTH_SHORT).show();
        } else {
            String url = "https://disease.sh/v3/covid-19/historical/" + countryAndDate[0] + "?lastdays=" + countryAndDate[1];

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    JSONObject condition;
                    //                ArrayList<String> TimelineArray = new ArrayList<>();
                    //                ArrayList<Integer> TimelineCasesValuesArray = new ArrayList<>();
                    //                ArrayList<Integer> TimelineDeathsValuesArray = new ArrayList<>();
                    //                ArrayList<Integer> TimelineRecoveredValuesArray = new ArrayList<>();

                    List<EvedydayCountryData> everydayReport = new ArrayList<>();

                    String day;
                    try {
                        condition = response.getJSONObject("timeline");
                        JSONObject cases = condition.getJSONObject("cases");
                        JSONObject deaths = condition.getJSONObject("deaths");
                        JSONObject recovered = condition.getJSONObject("recovered");
                        Iterator<String> days = cases.keys();
                        while (days.hasNext()) {
                            day = (String) days.next();
                            EvedydayCountryData eachDay = new EvedydayCountryData(day,
                                    cases.getInt(day),
                                    deaths.getInt(day),
                                    recovered.getInt(day));
                            everydayReport.add(eachDay);
                            //                        TimelineArray.add(day);
                            //                        TimelineCasesValuesArray.add(cases.getInt(day));
                            //                        TimelineDeathsValuesArray.add(deaths.getInt(day));
                            //                        TimelineRecoveredValuesArray.add(recovered.getInt(day));
                        }
                        getCountryResponseListener.onResponse(everydayReport);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(context, "SHUH", Toast.LENGTH_SHORT).show();
                    getCountryResponseListener.onError("Something wrong");
                }
            });
            MySingleton.getInstance(context).addToRequestQueue(request);
        }
    }

    public interface GetCovidDataByCountryResponseListener {
        void onError(String message);

        void onResponse(List<CountryDataReportModel> countriesDataReports);
    }
    public void getCovidDataByCountry(String countries, GetCovidDataByCountryResponseListener getCovidDataByCountryResponseListener) {
        List<CountryDataReportModel> countriesDataReports = new ArrayList<>();

        String[] countriesArray = countries.split(",");
        String url = "https://disease.sh/v3/covid-19/countries/" + countries;
        if (countriesArray.length > 1) {
            // Instantiate the RequestQueue.
            JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                @Override
                public void onResponse(JSONArray response) {

                    try {
                        for (int i = 0; i < response.length(); i++) {
                            CountryDataReportModel eachCountryReport = new CountryDataReportModel();
                            JSONObject countryFromAPI = response.getJSONObject(i);

                            eachCountryReport.setCountry(countryFromAPI.getString("country"));
                            eachCountryReport.setCases(countryFromAPI.getInt("cases"));
                            eachCountryReport.setTodayCases(countryFromAPI.getInt("todayCases"));
                            eachCountryReport.setDeaths(countryFromAPI.getInt("deaths"));
                            eachCountryReport.setTodayDeaths(countryFromAPI.getInt("todayDeaths"));
                            eachCountryReport.setRecovered(countryFromAPI.getInt("recovered"));
                            eachCountryReport.setTodayRecovered(countryFromAPI.getInt("todayRecovered"));
                            eachCountryReport.setActive(countryFromAPI.getInt("active"));
                            eachCountryReport.setCritical(countryFromAPI.getInt("critical"));
                            eachCountryReport.setCasesPerOneMillion(countryFromAPI.getInt("casesPerOneMillion"));
                            eachCountryReport.setDeathsPerOneMillion(countryFromAPI.getInt("deathsPerOneMillion"));
                            eachCountryReport.setTests(countryFromAPI.getInt("tests"));
                            eachCountryReport.setTestsPerOneMillion(countryFromAPI.getInt("testsPerOneMillion"));
                            eachCountryReport.setPopulation(countryFromAPI.getInt("population"));
                            eachCountryReport.setContinent(countryFromAPI.getString("continent"));
                            eachCountryReport.setOneCasePerPeople(countryFromAPI.getInt("oneCasePerPeople"));
                            eachCountryReport.setOneDeathPerPeople(countryFromAPI.getInt("oneDeathPerPeople"));
                            eachCountryReport.setOneTestPerPeople(countryFromAPI.getInt("oneTestPerPeople"));
                            eachCountryReport.setActivePerOneMillion(countryFromAPI.getInt("activePerOneMillion"));
                            eachCountryReport.setRecoveredPerOneMillion(countryFromAPI.getInt("recoveredPerOneMillion"));
                            eachCountryReport.setCriticalPerOneMillion(countryFromAPI.getInt("criticalPerOneMillion"));
                            countriesDataReports.add(eachCountryReport);
                        }

                        getCovidDataByCountryResponseListener.onResponse(countriesDataReports);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(context, "Error" + url, Toast.LENGTH_LONG).show();
                }
            });
            MySingleton.getInstance(context).addToRequestQueue(request);
        } else {
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    try {
                        CountryDataReportModel eachCountryReport = new CountryDataReportModel();
                        JSONObject countryFromAPI = response;
                        eachCountryReport.setCountry(countryFromAPI.getString("country"));
                        eachCountryReport.setCases(countryFromAPI.getInt("cases"));
                        eachCountryReport.setTodayCases(countryFromAPI.getInt("todayCases"));
                        eachCountryReport.setDeaths(countryFromAPI.getInt("deaths"));
                        eachCountryReport.setTodayDeaths(countryFromAPI.getInt("todayDeaths"));
                        eachCountryReport.setRecovered(countryFromAPI.getInt("recovered"));
                        eachCountryReport.setTodayRecovered(countryFromAPI.getInt("todayRecovered"));
                        eachCountryReport.setActive(countryFromAPI.getInt("active"));
                        eachCountryReport.setCritical(countryFromAPI.getInt("critical"));
                        eachCountryReport.setCasesPerOneMillion(countryFromAPI.getInt("casesPerOneMillion"));
                        eachCountryReport.setDeathsPerOneMillion(countryFromAPI.getInt("deathsPerOneMillion"));
                        eachCountryReport.setTests(countryFromAPI.getInt("tests"));
                        eachCountryReport.setTestsPerOneMillion(countryFromAPI.getInt("testsPerOneMillion"));
                        eachCountryReport.setPopulation(countryFromAPI.getInt("population"));
                        eachCountryReport.setContinent(countryFromAPI.getString("continent"));
                        eachCountryReport.setOneCasePerPeople(countryFromAPI.getInt("oneCasePerPeople"));
                        eachCountryReport.setOneDeathPerPeople(countryFromAPI.getInt("oneDeathPerPeople"));
                        eachCountryReport.setOneTestPerPeople(countryFromAPI.getInt("oneTestPerPeople"));
                        eachCountryReport.setActivePerOneMillion(countryFromAPI.getInt("activePerOneMillion"));
                        eachCountryReport.setRecoveredPerOneMillion(countryFromAPI.getInt("recoveredPerOneMillion"));
                        eachCountryReport.setCriticalPerOneMillion(countryFromAPI.getInt("criticalPerOneMillion"));
                        countriesDataReports.add(eachCountryReport);

                        getCovidDataByCountryResponseListener.onResponse(countriesDataReports);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(context, "Error" + url, Toast.LENGTH_LONG).show();
                }
            });
            MySingleton.getInstance(context).addToRequestQueue(request);
        }
    }

    public interface GetOverallHistoricalResponseListener {
        void onError(String message);

        void onResponse(List<EvedydayCountryData> everydayReport);
    }
    public void getOverallHistorical(GetOverallHistoricalResponseListener getOverallHistoricalResponseListener) {
        // Instantiate the RequestQueue.
        String url = "https://disease.sh/v3/covid-19/historical/all?lastdays=7";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                ArrayList<String> TimelineArray = new ArrayList<>();
//                ArrayList<Integer> TimelineCasesValuesArray = new ArrayList<>();
//                ArrayList<Integer> TimelineDeathsValuesArray = new ArrayList<>();
//                ArrayList<Integer> TimelineRecoveredValuesArray = new ArrayList<>();
                List<EvedydayCountryData> everydayReport = new ArrayList<>();

                String day;
                try {
                    JSONObject cases = response.getJSONObject("cases");
                    JSONObject deaths = response.getJSONObject("deaths");
                    JSONObject recovered = response.getJSONObject("recovered");
                    Iterator<String> days = cases.keys();
                    while (days.hasNext()) {
                        day = (String) days.next();
                        EvedydayCountryData eachDay = new EvedydayCountryData(day,
                                                                            cases.getInt(day),
                                                                            deaths.getInt(day),
                                                                            recovered.getInt(day));
                        everydayReport.add(eachDay);
//                        TimelineArray.add(day);
//                        TimelineCasesValuesArray.add(cases.getInt(day));
//                        TimelineDeathsValuesArray.add(deaths.getInt(day));
//                        TimelineRecoveredValuesArray.add(recovered.getInt(day));
                    }
                    getOverallHistoricalResponseListener.onResponse(everydayReport);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "SHUH", Toast.LENGTH_SHORT).show();
                getOverallHistoricalResponseListener.onError("Something wrong");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }

    public interface GetGlobalTotalTodayResponseListener {
        void onError(String message);

        void onResponse(CountryDataReportModel worldReport);
    }
    public void getGlobalTotalToday(GetGlobalTotalTodayResponseListener getGlobalTotalTodayResponseListener) {
        String url = "https://disease.sh/v3/covid-19/all";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    CountryDataReportModel worldReport = new CountryDataReportModel();
                    JSONObject worldFromAPI = response;
                    worldReport.setCases(worldFromAPI.getInt("cases"));
                    worldReport.setTodayCases(worldFromAPI.getInt("todayCases"));
                    worldReport.setDeaths(worldFromAPI.getInt("deaths"));
                    worldReport.setTodayDeaths(worldFromAPI.getInt("todayDeaths"));
                    worldReport.setRecovered(worldFromAPI.getInt("recovered"));
                    worldReport.setTodayRecovered(worldFromAPI.getInt("todayRecovered"));
                    worldReport.setActive(worldFromAPI.getInt("active"));
                    worldReport.setCritical(worldFromAPI.getInt("critical"));
                    worldReport.setCasesPerOneMillion(worldFromAPI.getInt("casesPerOneMillion"));
                    worldReport.setDeathsPerOneMillion(worldFromAPI.getInt("deathsPerOneMillion"));
                    worldReport.setTests(worldFromAPI.getInt("tests"));
                    worldReport.setTestsPerOneMillion(worldFromAPI.getInt("testsPerOneMillion"));
                    worldReport.setPopulation(worldFromAPI.getInt("population"));
                    worldReport.setOneCasePerPeople(worldFromAPI.getInt("oneCasePerPeople"));
                    worldReport.setOneDeathPerPeople(worldFromAPI.getInt("oneDeathPerPeople"));
                    worldReport.setOneTestPerPeople(worldFromAPI.getInt("oneTestPerPeople"));
                    worldReport.setActivePerOneMillion(worldFromAPI.getInt("activePerOneMillion"));
                    worldReport.setRecoveredPerOneMillion(worldFromAPI.getInt("recoveredPerOneMillion"));
                    worldReport.setCriticalPerOneMillion(worldFromAPI.getInt("criticalPerOneMillion"));

                    getGlobalTotalTodayResponseListener.onResponse(worldReport);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error" + url, Toast.LENGTH_LONG).show();
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }

    public interface GetVaccineDataResponseListener {
        void onError(String message);

        void onResponse(List<Integer> everydayVaccinedose);
    }
    public void getVaccineData(GetVaccineDataResponseListener getVaccineDataResponseListener) {
        // Instantiate the RequestQueue.

        String url = "https://disease.sh/v3/covid-19/vaccine/coverage?lastdays=7&fullData=false";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                List<Integer> everydayVaccinedose = new ArrayList<>();

                String day;
                try {
                    Iterator<String> days = response.keys();
                    while (days.hasNext()) {
                        day = (String) days.next();
                        everydayVaccinedose.add(response.getInt(day));
                    }
                    getVaccineDataResponseListener.onResponse(everydayVaccinedose);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "SHUH", Toast.LENGTH_SHORT).show();
                getVaccineDataResponseListener.onError("Something wrong");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }

}
