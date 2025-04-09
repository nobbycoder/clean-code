package org.example.basic;

import java.time.LocalDate;
import java.util.List;

public class Flights {
    public static final String DELAYED = "Delayed";

    public String getFlightStatus(List<LocalDate> flightArrivalTimes) {
        StringBuilder flightStatus = new StringBuilder();
        for (LocalDate arrivalTime : flightArrivalTimes) {
            if (arrivalTime.isAfter(LocalDate.now())) {
                flightStatus.append(arrivalTime).append("\n");
                continue;
            }
            flightStatus.append(DELAYED + "\n");
        }
        return flightStatus.toString();
    }
}
