package com.epam.appliances.service;

import com.epam.appliances.model.Appliance;
import com.epam.appliances.model.AppliancePurpose;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.epam.appliances.model.AppliancePurpose.KITCHEN;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Landlord extends Person {

    private int minCostForFlat;
    private List<Appliance> appliances = new ArrayList<>();

    public Landlord(String name, String surname, int minCostForFlat) {
        super(name, surname);
        this.minCostForFlat = minCostForFlat;
    }

    public int getMinCostForFlat() {
        return minCostForFlat;
    }

    public void setMinCostForFlat(int minCostForFlat) {
        this.minCostForFlat = minCostForFlat;
    }

    public Landlord buyAppliance(Appliance appliance) {
        appliances.add(appliance);
        return this;
    }

    public int getTotalPowerConsumption() {
        return appliances.stream().mapToInt(Appliance::getPower).sum();
    }

    public List<Appliance> getKitchenApplianceByPower(int min, int max) {
        return appliances.stream()
                .filter(a -> a.getAppliancePurpose() == KITCHEN)
                .filter(a -> (a.getPower() < max && a.getPower() > min))
                .collect(toList());
    }

    public void sortByApplianceType() {
        appliances.sort(comparing(Appliance::getAppliancePurpose));
    }

    public void showAllAppliances() {
        appliances.forEach(System.out::println);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Landlord landlord = (Landlord) o;
        return getMinCostForFlat() == landlord.getMinCostForFlat() &&
                appliances.equals(landlord.appliances);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMinCostForFlat(), appliances);
    }

    @Override
    public String toString() {
        return "Landlord{" +
                "minCostForFlat=" + minCostForFlat +
                ", appliances=" + appliances +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

}
