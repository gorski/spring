package com.trainings.guava;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import org.apache.log4j.Logger;


public class GuavaBasics {

    private static final Logger LOG = Logger.getLogger(GuavaBasics.class);

    public static void main(String[] args) {

        // optional - return from method
        Optional<Integer> optional =  Optional.absent();
        Integer or = optional.or(1);
        LOG.info("Optional? " + optional.isPresent());
        LOG.info("Int: "+ or );
//        LOG.info("Optional? " + optional.get());  // IllegalStateException


        // String or null
        String[] person = { "AAA", "BBB", "CCCC", null, null};
        for (String p : person){
            String nullOrEmpty = Strings.nullToEmpty(p);
            LOG.info("{"+nullOrEmpty+"}");
        }

        // Equal on null values
        boolean a = Objects.equal(null, null);
        LOG.info("Equal? = " +a);



    }

    public boolean foo(String param){
        return "bar".equals(param);

    }

}
