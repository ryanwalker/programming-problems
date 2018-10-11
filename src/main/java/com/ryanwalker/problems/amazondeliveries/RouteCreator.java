package com.ryanwalker.problems.amazondeliveries;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class RouteCreator {

  public static void main(String[] args) {
    RouteCreator sol = new RouteCreator();
    final List<List<Integer>> allLocations = Arrays.asList(
        Arrays.asList(1, 2),
        Arrays.asList(3, 4),
        Arrays.asList(-10, 5),
        Arrays.asList(2, 3)
    );
    List<List<Integer>> destinations = sol.ClosestXdestinations(4, allLocations, 3);

    System.out.println("hi");
  }

    /*
     So here's muy understanding. I am given a list of destinations which are
     (x,y) coordinates. I am also given how many deliveries to make. It says the most
     optimized plan is the closes destiations from the start, NOT the closest destinations
     together. Technically there could be a grouping of 3 all right next to eachother
     but 3 that are closer to the origin. So I am assuming i will just need to find
     the X desinations that are closest to the origin.

     Basically, I need to comput the distnaces of each destination and find the x closests.
    */

  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  List<List<Integer>> ClosestXdestinations(int numDestinations,
                                           List<List<Integer>> allLocations,
                                           int numDeliveries) {
    // WRITE YOUR CODE HERE
    //pseudo code
    //Loop over allLocations, calculating distane of each.
    //Put them in some collection, probably that is sorted so i don't have to sort after.
    //return the first X of them
    //here we go

    //Loop over allLocations, calculating distane of each.
    List<Location> locations = new ArrayList<>();
    if (allLocations != null) {
      for (List<Integer> point : allLocations) {
        int x = point.get(0);
        int y = point.get(1); //i'm assuming this input is valid for now
        BigDecimal distance = new BigDecimal(Math.sqrt(x * x + y * y)); //geeze, it's just in Math of course
        //double's going to give some rounding error. Using big decimal probalby
        Location location = new Location();
        location.x = x;
        location.y = y;
        location.distance = distance;
        locations.add(location);
      }
    } else {
      //TODO - Handle case later
    }
    //looked up lambda comparator syntax
    Collections.sort(locations, Comparator.comparing((Location loc) -> loc.distance));
    //now just return the first X of them
    List<List<Integer>> retVal = new ArrayList<>(); //not efficient but time;
    for (int i = 0; i < numDeliveries; i++) {
      Location l = locations.get(i);
      retVal.add(Arrays.asList(l.x, l.y));
    }
    return retVal;
  }
  // METHOD SIGNATURE ENDS

  public class Location {
    public BigDecimal distance;
    public int x;
    public int y;
    //saving time on getters and setters, constructors for now.

    //not sure how to debug this. I think it's something simpel.
    //You get the idea, moving on to next, will come back.
    //Might need to dump this in IntelliJ to debug it.
  }
}