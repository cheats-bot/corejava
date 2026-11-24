/*
 * Assignment 8: Collection Framework and Thread Programming
 * 
 * SET B - Question 1:
 * Create a Java program using TreeMap to store country names as keys and their 
 * populations as values, and display them sorted by country names and then by population 
 * using a custom Comparator.
 */

import java.util.*;

public class TreeMapCountryPopulation {
    public static void main(String[] args) {
        // 1. Natural sorting by country name (default TreeMap behavior)
        TreeMap<String, Long> countryByName = new TreeMap<>();
        countryByName.put("India", 1428627663L);
        countryByName.put("China", 1425671352L);
        countryByName.put("United States", 339996563L);
        countryByName.put("Indonesia", 277534122L);
        countryByName.put("Brazil", 216422446L);

        System.out.println("=== 1. Countries Sorted Alphabetically by Name (TreeMap Natural Order) ===");
        for (Map.Entry<String, Long> entry : countryByName.entrySet()) {
            System.out.printf("%-18s : %,d\n", entry.getKey(), entry.getValue());
        }

        // 2. Sorting by population using a Custom Comparator
        List<Map.Entry<String, Long>> list = new ArrayList<>(countryByName.entrySet());

        // Custom Comparator to sort by population in descending order
        Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                return o2.getValue().compareTo(o1.getValue()); // Descending population
            }
        });

        System.out.println("\n=== 2. Countries Sorted by Population (Descending Order via Comparator) ===");
        for (Map.Entry<String, Long> entry : list) {
            System.out.printf("%-18s : %,d\n", entry.getKey(), entry.getValue());
        }
    }
}

