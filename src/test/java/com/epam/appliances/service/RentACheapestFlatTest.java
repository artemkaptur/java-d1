package com.epam.appliances.service;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RentACheapestFlatTest {

    @Test
    public void rentACheapestFlatTest() {
        Tenant tenant = new Tenant("John", "Smith", 500);
        Landlord landlord = new Landlord("Bill", "Erickson", 400);
        Landlord landlord2 = new Landlord("Kyle", "Erickson", 300);
        Set<Landlord> landlords = new HashSet<>();
        landlords.add(landlord);
        landlords.add(landlord2);
        assertEquals(tenant.rentACheapestFlat(landlords).getMinCostForFlat(), 300);
    }

}
