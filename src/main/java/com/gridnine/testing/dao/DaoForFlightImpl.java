package com.gridnine.testing.dao;

import com.gridnine.testing.models.Flight;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
/**
 * 20.12.2020
 * DaoForFlightImpl
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
public class DaoForFlightImpl implements DaoForFlight {

    @Override
    public List<Integer> findAllWithFlightLongerThanTwoHours(List<Flight> flightList) {
        List<Integer> allWithFlightLongerThanTwoHours = new ArrayList<>();
        for (int i = 0; i < flightList.size(); i++) {
            long flightTime=0;
            for (int t = 0; t < flightList.get(i).getSegments().size(); t++) {
                flightTime=Math.abs(ChronoUnit.HOURS.between(flightList.get(i).getSegments().get(t).getArrivalDate(),flightList.get(i).getSegments().get(t).getDepartureDate()));
                if ((flightTime)>2){
                    allWithFlightLongerThanTwoHours.add(i);
                }
            }
        }
        return allWithFlightLongerThanTwoHours;
    }

    @Override
    public List<Flight> findAllWithMoreThenOneFlight(List<Flight> flightList) {
        List<Flight> withOneFlight = new ArrayList<>();
        for (Flight flight : flightList) {
            if (flight.getSegments().size() > 1) {
                withOneFlight.add(flight);
            }
        }
        return withOneFlight;
    }
    @Override
    public List<Flight> findAllWithOneFlight(List<Flight> flightList) {
        List<Flight> withOneFlight = new ArrayList<>();
        for (Flight flight : flightList) {
            if (flight.getSegments().size() < 2) {
                withOneFlight.add(flight);
            }
        }
        return withOneFlight;
    }
    @Override
    public List<Integer> findAllFlightNumberWithOneFlight(List<Flight> flightList) {
        List<Integer> withOneFlight = new ArrayList<>();
        for (int i = 0; i < flightList.size(); i++) {
            if (flightList.get(i).getSegments().size() < 2) {
                withOneFlight.add(i+1);
            }
        }
        return withOneFlight;
    }
    @Override
    public List<Flight> findAllWithTwoFlight(List<Flight> flightList) {
        List<Flight> withOneFlight = new ArrayList<>();
        for (Flight flight : flightList) {
            if (flight.getSegments().size() == 2) {
                withOneFlight.add(flight);
            }
        }
        return withOneFlight;
    }
    @Override
    public List<Integer> findAllFlightNumberWithTwoFlight(List<Flight> flightList) {
        List<Integer> withTwoFlight = new ArrayList<>();
        for (int i = 0; i < flightList.size(); i++) {
            if (flightList.get(i).getSegments().size() == 2) {
                withTwoFlight.add(i+1);
            }
        }
        return withTwoFlight;
    }
    @Override
    public List<Flight> findAllWithMoreThenTwoFlight(List<Flight> flightList) {
        List<Flight> withOneFlight = new ArrayList<>();
        for (Flight flight : flightList) {
            if (flight.getSegments().size() > 2) {
                withOneFlight.add(flight);
            }
        }
        return withOneFlight;
    }
    @Override
    public List<Integer> findAllFlightNumberWithMoreThenTwoFlight(List<Flight> flightList) {
        List<Integer> withMoreThenTwoFlight = new ArrayList<>();
        for (int i = 0; i < flightList.size(); i++) {
            if (flightList.get(i).getSegments().size() > 2) {
                withMoreThenTwoFlight.add(i+1);
            }
        }
        return withMoreThenTwoFlight;
    }
    @Override
    public List<Flight> findAllWithMoreThenTwoGroundTime(List<Flight> flightList) {

        List<Flight>findAllWithMoreThenTwoGroundTime=new ArrayList<>();
        for (Flight flight : flightList) {
            int allGroundTime=0;
            for (int t = 0; t < flight.getSegments().size()-1; t++) {
                allGroundTime+=Math.abs(ChronoUnit.HOURS.between(flight.getSegments().get(t).getArrivalDate(),flight.getSegments().get(t+1).getDepartureDate()));
            }
            if (allGroundTime>2){
                findAllWithMoreThenTwoGroundTime.add(flight);
            }
        }
        return findAllWithMoreThenTwoGroundTime;
    }

    @Override
    public List<Integer> findAllFlightNumberWithMoreThenTwoGroundTime(List<Flight> flightList) {

        List<Integer>findAllFlightNumberWithMoreThenTwoGroundTime=new ArrayList<>();
        for (int i = 0; i < flightList.size(); i++) {
            int allGroundTime=0;
            for (int t = 0; t < flightList.get(i).getSegments().size()-1; t++) {
                allGroundTime+=Math.abs(ChronoUnit.HOURS.between(flightList.get(i).getSegments().get(t).getArrivalDate(),flightList.get(i).getSegments().get(t+1).getDepartureDate()));
            }
            if (allGroundTime>2){
                findAllFlightNumberWithMoreThenTwoGroundTime.add(i+1);
            }
        }
        return findAllFlightNumberWithMoreThenTwoGroundTime;
    }

    @Override
    public List<Flight> findAllWithLessThenTwoGroundTime(List<Flight> flightList) {
        List<Flight>withLessThenTwoGroundTime=new ArrayList<>();
        for (Flight flight : flightList) {
            int allGroundTime=0;
            for (int t = 0; t < flight.getSegments().size()-1; t++) {
                allGroundTime+=Math.abs(ChronoUnit.HOURS.between(flight.getSegments().get(t).getArrivalDate(),flight.getSegments().get(t+1).getDepartureDate()));
            }
            if (allGroundTime<=2){
                withLessThenTwoGroundTime.add(flight);
            }
        }
        return withLessThenTwoGroundTime;
    }

    @Override
    public List<Flight> findAllBeforeItArrives(List<Flight> flightList) {
        List<Flight> beforeItArrives = new ArrayList<>();
        for (Flight flight : flightList) {
            for (int t = 0; t < flight.getSegments().size(); t++) {
                if (flight.getSegments().get(t).getArrivalDate().isBefore(flight.getSegments().get(t).getDepartureDate())) {
                    beforeItArrives.add(flight);
                }
            }
        }
        return beforeItArrives;
    }

    @Override
    public List<Integer> findAllFlightNumberBeforeItArrives(List<Flight> flightList) {
        return null;
    }

    @Override
    public List<Flight> findAllDepartingInThePast(List<Flight> flightList) {
        List<Flight> departingInThePast = new ArrayList<>();
        for (Flight flight : flightList) {
            for (int t = 0; t < flight.getSegments().size(); t++) {
                if (LocalDateTime.now().isAfter(flight.getSegments().get(t).getDepartureDate())) {
                    departingInThePast.add(flight);
                }
            }
        }
        return departingInThePast;
    }

    @Override
    public List<Integer> findAllFlightNumberDepartingInThePast(List<Flight> flightList) {
        List<Integer>allFlightNumberDepartingInThePast=new ArrayList<>();
        for (int i = 0; i < flightList.size(); i++) {
            for (int t = 0; t < flightList.get(i).getSegments().size(); t++) {
                if (LocalDateTime.now().isAfter(flightList.get(i).getSegments().get(t).getDepartureDate())) {
                    allFlightNumberDepartingInThePast.add(i+1);
                }
            }
        }
        return allFlightNumberDepartingInThePast;
    }

    @Override
    public List<Flight> findAll() {
        return null;
    }
}
