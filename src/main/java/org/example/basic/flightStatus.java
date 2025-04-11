package org.example.basic;

import java.time.LocalDate;
import java.util.List;

public class flightStatus {

    public static final String STATUS_LINE_BREAK = "\n";
    public static final String DELAY_STATUS = "Delayed";

    public String getStatus(List<LocalDate> arrivalDates) {
        StringBuilder status = new StringBuilder();
        for (LocalDate day : arrivalDates) {
            if (day.isAfter(LocalDate.now())) {
                status.append(day).append(STATUS_LINE_BREAK);
            } else {
            status.append(DELAY_STATUS).append(STATUS_LINE_BREAK);
            }
        }
        return status.toString();
    }
}
