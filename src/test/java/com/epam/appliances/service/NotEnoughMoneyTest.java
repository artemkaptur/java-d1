package com.epam.appliances.service;

import com.epam.appliances.exception.NotEnoughMoneyException;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class NotEnoughMoneyTest {

    @Test(expectedExceptions = NotEnoughMoneyException.class)
    public void notEnoughMoneyTest() {
        Tenant tenant = new Tenant("John", "Smith", 200);
        Landlord landlord = new Landlord("Bill", "Erickson", 400);
        Landlord landlord2 = new Landlord("Kyle", "Erickson", 300);
        Set<Landlord> landlords = new HashSet<>();
        landlords.add(landlord);
        landlords.add(landlord2);
        assertEquals(tenant.chooseLandlordWithACheapestFlat(landlords).getMinCostForFlat(), 300);
    }

}
