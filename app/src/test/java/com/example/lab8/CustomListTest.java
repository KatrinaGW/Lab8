package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


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

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Saskatoon", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void hasCityTrueTest(){
        list = MockCityList();
        City mockCity = new City("Calgary", "AB");
        list.addCity(mockCity);

        assertTrue(list.hasCity(mockCity));
    }

    @Test
    public void hasCityFalseTest(){
        list = MockCityList();
        City mockCity = new City("Calgary", "AB");

        assertFalse(list.hasCity(mockCity));
    }

    @Test
    public void deleteCitySuccessTest(){
        list = MockCityList();
        City mockCity = new City("Calgary", "AB");
        list.add(mockCity);

        list.deleteCity(mockCity);
        assertFalse(list.hasCity(mockCity));
    }

    @Test
    public void deleteCityThrowsTest(){
        list = MockCityList();
        City mockCity = new City("Calgary", "AB");

        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(mockCity);
        });
    }


}
