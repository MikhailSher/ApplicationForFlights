package com.gridnine.testing.dao;

import com.gridnine.testing.models.Flight;
import java.util.List;
/**
 * 20.12.2020
 * DaoForFlight
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
public interface DaoForFlight extends Dao<Flight> {
    List<Integer> findAllWithFlightLongerThanTwoHours( List<Flight> flightList);
    List<Flight> findAllWithMoreThenOneFlight( List<Flight> flightList);
    List<Flight> findAllWithOneFlight( List<Flight> flightList);
    List<Integer> findAllFlightNumberWithOneFlight( List<Flight> flightList);
    List<Flight> findAllWithTwoFlight(List<Flight> flightList);
    List<Integer> findAllFlightNumberWithTwoFlight( List<Flight> flightList);
    List<Flight> findAllWithMoreThenTwoFlight(List<Flight> flightList);
    List<Integer> findAllFlightNumberWithMoreThenTwoFlight( List<Flight> flightList);
    List<Flight> findAllWithMoreThenTwoGroundTime(List<Flight> flightList);
    List<Integer> findAllFlightNumberWithMoreThenTwoGroundTime(List<Flight> flightList);
    List<Flight> findAllWithLessThenTwoGroundTime(List<Flight> flightList);
    List<Flight> findAllBeforeItArrives(List<Flight> flightList);
    List<Integer> findAllFlightNumberBeforeItArrives(List<Flight> flightList);
    List<Flight> findAllDepartingInThePast(List<Flight> flightList);
    List<Integer> findAllFlightNumberDepartingInThePast(List<Flight> flightList);
}
