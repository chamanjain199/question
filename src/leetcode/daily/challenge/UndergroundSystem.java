package leetcode.daily.challenge;

import java.util.HashMap;

class Travel {
    int time;
    String startStation;

    public Travel(int time, String startStation) {
        this.time = time;
        this.startStation = startStation;
    }
}

class State {
    double time;
    int count;

    public State(double time, int count) {
        this.time = time;
        this.count = count;
    }
}

public class UndergroundSystem {
    HashMap<Integer, Travel> startStationWithTime = new HashMap<>();
    HashMap<String, State> endStationWithTime = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        startStationWithTime.put(id, new Travel(t, stationName));
    }

    public void checkOut(int id, String stationName, int t) {
        Travel travel = startStationWithTime.get(id);
        State i = endStationWithTime.get(travel.startStation + "-" + stationName);
        if (i != null) {
            i.time = i.time + (t - travel.time);
            i.count = i.count + 1;
        } else {
            endStationWithTime.put(travel.startStation + "-" + stationName, new State(t - travel.time, 1));
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        State st = endStationWithTime.get(startStation + "-" + endStation);
        return (double)(st.time / st.count);
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(10, "Leyton", 3);
        undergroundSystem.checkOut(10, "Paradise", 8);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise"));
        undergroundSystem.checkIn(5, "Leyton", 10);
        undergroundSystem.checkOut(5, "Paradise", 16);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise"));
        undergroundSystem.checkIn(2, "Leyton", 21);
        undergroundSystem.checkOut(2, "Paradise", 30);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise"));


    }
}
