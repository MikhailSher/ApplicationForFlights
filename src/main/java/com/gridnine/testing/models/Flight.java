package com.gridnine.testing.models;

import java.util.List;
import java.util.stream.Collectors;
/**
 * 20.12.2020
 * Flight
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
public class Flight {
    private final List<Segment> segments;

    public Flight(final List<Segment> segs) {
        segments = segs;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}