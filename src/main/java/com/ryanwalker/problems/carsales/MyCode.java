package com.ryanwalker.problems.carsales;

// package whatever; // don't place package name!

class MyCode {

  public static void main(String[] args) {

    CarSaleService service = null;

    service.addSalesPerson("Janice", "Kapp");
    service.addSalesPerson("Henry", "Borsch");
    service.addSalesPerson("Mikey", "Balmar");
    service.addSalesPerson("Dana", "Glindon");

  }

  public interface CarSaleService {

    /**
     * Add a sales person so we can keep track of their car sales
     * returns the sales person id
     */
    String addSalesPerson(String firstName, String lastName);

    /**
     * Add a car sale for a specific user
     */
    void addCarSale(String carMakeAndModel, int salesPersonId);

    /**
     * Print a simple string report showing the car sales by sales person.
     * The general manager would like this report ordered alphabetically by last name.
     *
     *
     * Jeff Bezos -> 800,000 cars sold
     * Bob Howard -> 3 cars sold
     * Janice Kapp -> 5 cars sold
     * Eric Marineau -> 1 car sold
     *
     */
    String printSalesReport();
  }


}
