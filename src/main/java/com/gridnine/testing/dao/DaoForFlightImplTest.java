package com.gridnine.testing.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.gridnine.testing.models.Flight;
import com.gridnine.testing.storage.StorageOfFlight;
import java.util.ArrayList;
import java.util.List;
/**
 * 20.12.2020
 * DaoForFlightImplTest
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
class DaoForFlightImplTest {

    DaoForFlight daoForFlight=new DaoForFlightImpl();

    //List for test
    List<Flight> test=StorageOfFlight.createFlights();

    @Test
    void findAllWithMoreThenOneFlight() {
        //The expected list is what the method returns
        List<Flight> expected = daoForFlight.findAllWithMoreThenOneFlight(test);
        //List actual what we expect the method should return
        List<Flight> actual=new ArrayList<>();
        actual.add(test.get(1));
        actual.add(test.get(4));
        actual.add(test.get(5));
        //Compare expected and actual
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findAllWithOneFlight() {
        List<Flight> expected = daoForFlight.findAllWithOneFlight(test);
        List<Flight> actual=new ArrayList<>();
        actual.add(test.get(0));
        actual.add(test.get(2));
        actual.add(test.get(3));
        Assertions.assertEquals(expected, actual);
    }
}