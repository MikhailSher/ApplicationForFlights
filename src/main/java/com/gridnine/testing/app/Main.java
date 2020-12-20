package com.gridnine.testing.app;
import com.gridnine.testing.dao.DaoForFlight;
import com.gridnine.testing.dao.DaoForFlightImpl;
import com.gridnine.testing.storage.StorageOfFlight;
import com.gridnine.testing.storage.StorageSingleton;
import com.gridnine.testing.models.Flight;

import java.util.List;
/**
 * 20.12.2020
 * Main
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
public class Main {
    public static void main(String[]args){

        DaoForFlight daoForFlight=new DaoForFlightImpl();
        //List obtained using StorageOfFlight
        List<Flight>flights= StorageOfFlight.createFlights();
        //List obtained using StorageSingleton
        List<Flight>flightsSingleton= StorageSingleton.storage().flights();


        System.out.println("All flight numbers with more than two hours in the air:");
        System.out.println(daoForFlight.findAllWithFlightLongerThanTwoHours(flights));
        System.out.println("All flight numbers with more then two segments:");
        System.out.println(daoForFlight.findAllFlightNumberWithMoreThenTwoFlight(flightsSingleton));
        System.out.println("All flight numbers with two segments:");
        System.out.println(daoForFlight.findAllFlightNumberWithTwoFlight(flightsSingleton));
        System.out.println("All flight numbers with one segment:");
        System.out.println(daoForFlight.findAllFlightNumberWithOneFlight(flights));
        System.out.println("A single flight:");
        System.out.println(daoForFlight.findAllWithOneFlight(flights));
        System.out.println("All flight numbers with more than two hours ground time:");
        System.out.println(daoForFlight.findAllFlightNumberWithMoreThenTwoGroundTime(flights));
        System.out.println("A flights with more than two hours ground time:");
        System.out.println(daoForFlight.findAllWithMoreThenTwoGroundTime(flightsSingleton));
        System.out.println("A flights that departs before it arrives:");
        System.out.println(daoForFlight.findAllBeforeItArrives(flights));
        System.out.println("All flight numbers departing in the past:");
        System.out.println(daoForFlight.findAllFlightNumberDepartingInThePast(flights));
        System.out.println("A flights departing in the past:");
        System.out.println(daoForFlight.findAllDepartingInThePast(flights));
        System.out.println("A flights departing in the past:");
        System.out.println(daoForFlight.findAllDepartingInThePast(flightsSingleton));
        System.out.println("A multi segment flights:");
        System.out.println(daoForFlight.findAllWithMoreThenOneFlight(flights));
    }
}
