package com.trainings.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GuavaCollections {
    private static final Logger LOG = Logger.getLogger(GuavaCollections.class);

    public static void main(String[] args) {

        int[] a = new int[3];
        a[0] = 0;
        // ....

        int[] b = new int[]{2, 3, 4, 5};

        // collections:
        List<String> strings = Lists.newArrayList("asdad", "asadss", "asfdfdsa");

        // multiset "bag"
        HashMultiset<Integer> multiset = HashMultiset.create();
        multiset.add(1);
        multiset.add(1);
        LOG.info("Size: " + multiset.size());

        //

        List<Integer> countUp = Ints.asList(1, 2, 3, 4, 5);
        List<Integer> countDown = Lists.reverse(countUp);
        LOG.info("countDown " + Iterables.toString(countDown));
        LOG.info("countUp " + Iterables.toString(countDown));

        List<List<Integer>> partition = Lists.partition(countUp, 2);
        LOG.info(Iterables.toString(partition));


        // < 1.4
//        Iterator<Integer> iterator = countUp.iterator();
//        while(iterator.hasNext()){
//            boolean bla = iterator.hasNext();
//        }

        // multimap    Map < K , List<V> >
        ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.putAll("a", Ints.asList(2, 3, 4));
        multimap.putAll("b", Ints.asList(5, 6, 7));

        LOG.info(Iterables.toString(multimap.get("a")));

        // arraylistmultimap
        final ArrayListMultimap<String, Integer> multimap2 = ArrayListMultimap.create();
        String KEY_1 = "key1";
        String KEY_2 = "key2";
        multimap2.put(KEY_1, 33);
        multimap2.put(KEY_1, 35);
        multimap2.put(KEY_1, 31);
        multimap2.put(KEY_2, 2);

        LOG.info("under key1: " + Iterables.toString(multimap2.get(KEY_1)));
        LOG.info("under key2: " + Iterables.toString(multimap2.get(KEY_2)));


    }

}
