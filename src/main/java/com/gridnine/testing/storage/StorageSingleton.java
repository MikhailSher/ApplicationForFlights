package com.gridnine.testing.storage;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 20.12.2020
 * StorageSingleton
 *
 * A class that implements the Singleton pattern
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
public class StorageSingleton {
    //A variable that stores a reference to a single instance of an object of the StorageSingleton class
    private static final StorageSingleton storage;
    LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
    //A statically initializer that creates an object of the StorageSingleton class. Called once when the class is loaded in the JVM
    static {
        storage = new StorageSingleton();
    }
    // A list field that stores a list of system users
    private List<Flight> flights;
    // A private constructor that initializes the list
    private StorageSingleton() {
        this.flights =
        Arrays.asList(
                //A normal flight with two hour duration
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                //A normal multi segment flight
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),
                //A flight departing in the past
                createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
                //A flight that departs before it arrives
                createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
                //A flight with more than two hours ground time
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
                //Another flight with more than two hours ground time
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
                        threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));
    }
    // A method that provides access to a class object
    public static StorageSingleton storage() {
        return storage;
    }
    // Method that returns a list of flights
    public List<Flight> flights() {
        return flights;
    }
    private static Flight createFlight(final LocalDateTime... dates) {
        if ((dates.length % 2) != 0) {
            throw new IllegalArgumentException(
                    "you must pass an even number of dates");
        }
        List<Segment> segments = new ArrayList<>(dates.length / 2);
        for (int i = 0; i < (dates.length - 1); i += 2) {
            segments.add(new Segment(dates[i],dates[i+1]));
            LocalDateTime a=dates[i];
        }
        return new Flight(segments);
    }
}
