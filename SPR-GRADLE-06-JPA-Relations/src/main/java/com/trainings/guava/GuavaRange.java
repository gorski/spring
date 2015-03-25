package com.trainings.guava;

import com.google.common.collect.BoundType;
import com.google.common.primitives.Ints;
import org.apache.log4j.Logger;

/**
 * A range, sometimes known as an interval, is a convex (informally,
 * "contiguous" or "unbroken") portion of a particular domain. Formally,
 * convexity means that for any a <= b <= c, range.contains(a) &&
 * range.contains(c) implies that range.contains(b).
 * <p/>
 * Ranges may "extend to infinity" -- for example, the range "x > 3" contains
 * arbitrarily large values -- or may be finitely constrained, for example
 * "2 <= x < 5". notation is:
 * <p/>
 * <pre>
 *   (a..b) = {x | a < x < b}
 * [a..b] = {x | a <= x <= b}
 * [a..b) = {x | a <= x < b}
 * (a..b] = {x | a < x <= b}
 * (a..+∞) = {x | x > a}
 * [a..+∞) = {x | x >= a}
 * (-∞..b) = {x | x < b}
 * (-∞..b] = {x | x <= b}
 * (-∞..+∞) = all values
 * </pre>
 */
public class GuavaRange {
    private static final Logger LOG = Logger.getLogger(GuavaRange.class);

    public static void main(String[] args) {
        GuavaRange test = new GuavaRange();
        test.createRange();
        test.operations();
    }

    public void createRange() {
        // all strings lexographically between "left" and "right" inclusive
        com.google.common.collect.Range closed = com.google.common.collect.Range.closed("left", "right");
        LOG.info(closed);

        // double values strictly less than 4
        com.google.common.collect.Range lessThan = com.google.common.collect.Range.lessThan(4.0);
        LOG.info(lessThan);

        // another way of writing GuavaRange.closedOpen(1, 4)
        com.google.common.collect.Range range = com.google.common.collect.Range.range(1, BoundType.CLOSED, 4, BoundType.OPEN);
        LOG.info(range);
    }

    public void operations() {
        com.google.common.collect.Range closed = com.google.common.collect.Range.closed(1, 3);
        com.google.common.collect.Range lessThan = com.google.common.collect.Range.lessThan(5);

        closed.contains(2); // returns true
        closed.contains(4); // returns false
        lessThan.contains(5); // returns false
        boolean containsAll = com.google.common.collect.Range.closed(1, 4).containsAll(Ints.asList(1, 2, 3)); // returns
        // true
        LOG.info("contains {1,2,3} : " + containsAll);

        com.google.common.collect.Range.closedOpen(4, 4).isEmpty(); // returns true
        com.google.common.collect.Range.openClosed(4, 4).isEmpty(); // returns true
        com.google.common.collect.Range.closed(4, 4).isEmpty(); // returns false

        // enclosure
        /**
         * The most basic relation on ranges is encloses(GuavaRange), which is true
         * if the bounds of the inner range do not extend outside the bounds of
         * the outer range. This is solely dependent on comparisons between the
         * endpoints!
         */
        com.google.common.collect.Range range1_4 = com.google.common.collect.Range.range(1, BoundType.CLOSED, 4, BoundType.CLOSED);
        com.google.common.collect.Range range2_3 = com.google.common.collect.Range.range(2, BoundType.CLOSED, 3, BoundType.CLOSED);
        com.google.common.collect.Range range0_3 = com.google.common.collect.Range.range(0, BoundType.CLOSED, 3, BoundType.CLOSED);

        boolean encloses = range1_4.encloses(range2_3);
        LOG.info("[1,4] encloses [2,3]  : " + encloses);

        boolean encloses2 = range1_4.encloses(range0_3);
        LOG.info("[1,4] encloses [0,3] : " + encloses2);

        // connection
        /**
         * GuavaRange.isConnected(GuavaRange), which tests if these ranges are connected.
         * Specifically, isConnected tests if there is some range enclosed by
         * both of these ranges, but this is equivalent to the mathematical
         * definition that the union of the ranges must form a connected set
         * (except in the special case of empty ranges).
         */
        com.google.common.collect.Range.closed(3, 5).isConnected(com.google.common.collect.Range.open(5, 10)); // returns true
        com.google.common.collect.Range.closed(0, 9).isConnected(com.google.common.collect.Range.closed(3, 4)); // returns true
        com.google.common.collect.Range.closed(0, 5).isConnected(com.google.common.collect.Range.closed(3, 9)); // returns true
        com.google.common.collect.Range.open(3, 5).isConnected(com.google.common.collect.Range.open(5, 10)); // returns false
        com.google.common.collect.Range.closed(1, 5).isConnected(com.google.common.collect.Range.closed(6, 10)); // returns false

        // intersection
        /**
         * GuavaRange.intersection(GuavaRange) returns the maximal range enclosed by both
         * this range and other (which exists iff these ranges are connected),
         * or if no such range exists, throws an IllegalArgumentException.
         */
        com.google.common.collect.Range.closed(3, 5).intersection(com.google.common.collect.Range.open(5, 10)); // returns (5, 5]
        com.google.common.collect.Range.closed(0, 9).intersection(com.google.common.collect.Range.closed(3, 4)); // returns [3, 4]
        com.google.common.collect.Range.closed(0, 5).intersection(com.google.common.collect.Range.closed(3, 9)); // returns [3, 5]
        com.google.common.collect.Range.open(3, 5).intersection(com.google.common.collect.Range.open(5, 10)); // throws IAE

        // GuavaRange.closed(1, 5).intersection(GuavaRange.closed(6, 10)); // throws IAE

        // span
        /**
         * GuavaRange.span(GuavaRange) returns the minimal range that encloses both this
         * range and other. If the ranges are both connected, this is their
         * union.
         */
        com.google.common.collect.Range.closed(3, 5).span(com.google.common.collect.Range.open(5, 10)); // returns [3, 10)
        com.google.common.collect.Range.closed(0, 9).span(com.google.common.collect.Range.closed(3, 4)); // returns [0, 9]
        com.google.common.collect.Range.closed(0, 5).span(com.google.common.collect.Range.closed(3, 9)); // returns [0, 9]
        com.google.common.collect.Range.open(3, 5).span(com.google.common.collect.Range.open(5, 10)); // returns (3, 10)
        com.google.common.collect.Range.closed(1, 5).span(com.google.common.collect.Range.closed(6, 10)); // returns [1, 10]
    }
}
