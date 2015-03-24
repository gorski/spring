package com.trainings.guava;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class GuavaStrings {
    private static final Logger LOG = Logger.getLogger(GuavaStrings.class);

    public static void main(String[] args) {
        GuavaStrings test = new GuavaStrings();
        test.joiner();
        test.splitter();
        test.charMatcher();
        test.caseFormat();
    }

    public void joiner() {

        // skip nulls
        Joiner joiner = Joiner.on("; ").skipNulls();
        String join = joiner.join("Harry", null, "Ron", "Hermione");
        LOG.info(join); // Harry; Ron; Hermione

        // using with ints
        String join2 = Joiner.on(",").join(Arrays.asList(1, 5, 7)); // returns
        // "1,5,7"
        LOG.info(join2); // Harry; Ron; Hermione

    }

    /**
     * Java String.split may return some not expected results. EG
     * ",a,,b,".split(",") returns ["", "a", "", "b"]
     */
    public void splitter() {

        // ambiguous result of standard String.split method
        String[] split = ",a,,b,".split(",");
        LOG.info(Arrays.toString(split));

        // Guava Splitter allows complete control over all splitting behaviours
        // using
        // a reassuringly straightforward fluent pattern.
        Iterable<String> split2 = Splitter.on(',').trimResults().omitEmptyStrings().split("foo,bar,,   qux");
        LOG.info(Iterables.toString(split2)); // returns an Iterable<String>
        // containing "foo", "bar",
        // "qux"

        // keep empty strings
        Iterable<String> split3 = Splitter.on(',').trimResults().split("foo,bar,,   qux");
        LOG.info(Iterables.toString(split3)); // returns an Iterable<String>
        // containing "foo", "bar", " ",
        // "qux"

        // fixed length
        Iterable<String> split4 = Splitter.fixedLength(3).split("12345678910");
        LOG.info(Iterables.toString(split4)); // returns [123, 456, 789, 10]

        // using char matcher
        Iterable<String> split5 = Splitter.on(CharMatcher.WHITESPACE).split("bill joe tom kate");
        LOG.info(Iterables.toString(split5)); // returns [bill, joe, tom, kate]

    }

    public void charMatcher() {
        String string = "test3 akp$ 45 vision 99.0";
        // Char matcher can be used not only in Splitter but also individually
        String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom(string, "*");
        LOG.info(noDigits); // returns test* akp$ ** vision **.*

        // leave out only digits
        String theDigits = CharMatcher.DIGIT.retainFrom(string);
        LOG.info(theDigits); // returns 345990

    }

    public void caseFormat() {
        //CaseFormat is a handy little class for converting between ASCII case conventions --
        //like, for example, naming conventions for programming languages.
        String string = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME"); // returns "constantName"
        LOG.info(string); //

    }
}
