package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        list = MockCityList();
        list.addCity(new City("Edmonton", "Alberta"));
        City city = new City("Edmonton", "Alberta");
        City nonExistentCity = new City("Toronto", "Ontario");
        assertTrue(list.hasCity(city));
        assertFalse(list.hasCity(nonExistentCity));
    }

    @Test
    void testDelete() {
        list = MockCityList();
        list.addCity(new City("Edmonton", "Alberta"));
        City city = new City("Edmonton", "Alberta");
        City nonExistentCity = new City("Toronto", "Ontario");
        list.delete(city);
        assertFalse(list.hasCity(city));
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(nonExistentCity);
        });
    }

    @Test
    void testCountCities() {
        list = MockCityList();
        City city = new City("Edmonton", "Alberta");
        list.addCity(city);
        assertEquals(1, list.countCities());
        list.addCity(new City("Regina", "Saskatchewan"));
        assertEquals(2, list.countCities());
        list.delete(city);
        assertEquals(1, list.countCities());
    }

}
