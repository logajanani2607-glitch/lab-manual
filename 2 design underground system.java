import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Stores current check-in information
    private Map<Integer, CheckIn> checkInMap;

    // Stores route statistics
    private Map<String, Route> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        CheckIn check = checkInMap.get(id);

        String key = check.station + "->" + stationName;

        int travelTime = t - check.time;

        Route route = routeMap.getOrDefault(key, new Route());

        route.totalTime += travelTime;
        route.tripCount++;

        routeMap.put(key, route);

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String key = startStation + "->" + endStation;

        Route route = routeMap.get(key);

        return (double) route.totalTime / route.tripCount;
    }

    // Helper class for check-in data
    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Helper class for route statistics
    class Route {
        int totalTime = 0;
        int tripCount = 0;
    }
}
