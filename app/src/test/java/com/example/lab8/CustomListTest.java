package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    private City mockCity(){
        return new City("Edmonton", "Alberta");
    }
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }


    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.add(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testAddException() {
        list = MockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        list.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            list.add(city);
        });
    }

    @Test
    void testGetCities() {
        list = MockCityList();
        list.add(mockCity());
        assertEquals(0, mockCity().compareTo(list.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        list.add(city);
        assertEquals(0, city.compareTo(list.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(list.getCities().get(1)));
    }

    @Test
    void testHasCity(){
        CustomList cityList = MockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        assertFalse(cityList.hasCity(city));
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testDeleteCity(){
        CustomList cityList = MockCityList();
        City city1 = new City("YN", "NT");
        City city2 = new City("Yellowknife", "Northwest Territories");
        cityList.add(city2);
        //cityList.delete(city1);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);
        });
        assertEquals(1, cityList.getCities().size());
        cityList.delete(city2);
        assertEquals(0, cityList.getCities().size());
    }

    @Test
    void tesCountCity(){
        CustomList cityList = MockCityList();
        assertEquals(0, cityList.countCities());
        City city2 = new City("Yellowknife", "Northwest Territories");
        cityList.add(city2);
        assertEquals(1, cityList.countCities());
    }
}
