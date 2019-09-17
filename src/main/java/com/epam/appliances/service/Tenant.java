package com.epam.appliances.service;

import com.epam.appliances.exception.NotEnoughMoneyException;

import java.util.Objects;
import java.util.Set;

import static java.util.Comparator.comparingInt;

public class Tenant extends Person {

    private int maxPaymentForFlat;
    private Landlord landlord;

    public Tenant(String name, String surname, int maxPaymentForFlat) {
        super(name, surname);
        this.maxPaymentForFlat = maxPaymentForFlat;
    }

    public int getMaxPaymentForFlat() {
        return maxPaymentForFlat;
    }

    public void setMaxPaymentForFlat(int maxPaymentForFlat) {
        this.maxPaymentForFlat = maxPaymentForFlat;
    }

    public Landlord rentACheapestFlat(Set<Landlord> landlords) {
        if (landlord == null) {
            landlord = landlords
                    .stream()
                    .min(comparingInt(Landlord::getMinCostForFlat))
                    .orElseThrow();
            int delta = landlord.getMinCostForFlat() - maxPaymentForFlat;
            if (delta > 0)
                throw new NotEnoughMoneyException("You need extra " + delta + "$ to rent a flat");
        }
        return landlord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tenant tenant = (Tenant) o;
        return getMaxPaymentForFlat() == tenant.getMaxPaymentForFlat() &&
                landlord.equals(tenant.landlord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMaxPaymentForFlat(), landlord);
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "maxPaymentForFlat=" + maxPaymentForFlat +
                ", landlord=" + landlord +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

}
