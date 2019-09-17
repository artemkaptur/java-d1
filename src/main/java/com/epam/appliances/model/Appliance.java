package com.epam.appliances.model;

import java.util.Objects;

public abstract class Appliance {

    protected String title;
    protected AppliancePurpose appliancePurpose;
    protected int power;
    protected int weight;
    protected Color color;
    protected boolean isPlugged = false;

    public Appliance(String title, AppliancePurpose appliancePurpose, int power, int weight, Color color) {
        this.title = title;
        this.appliancePurpose = appliancePurpose;
        this.power = power;
        this.weight = weight;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AppliancePurpose getAppliancePurpose() {
        return appliancePurpose;
    }

    public void setAppliancePurpose(AppliancePurpose appliancePurpose) {
        this.appliancePurpose = appliancePurpose;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isPlugged() {
        return isPlugged;
    }

    public void setPlugged(boolean plugged) {
        isPlugged = plugged;
    }

    public void plug() {
        this.isPlugged = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appliance appliance = (Appliance) o;
        return getPower() == appliance.getPower() &&
                getWeight() == appliance.getWeight() &&
                isPlugged() == appliance.isPlugged() &&
                getTitle().equals(appliance.getTitle()) &&
                getAppliancePurpose() == appliance.getAppliancePurpose() &&
                getColor() == appliance.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAppliancePurpose(), getPower(), getWeight(), getColor(), isPlugged());
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "title='" + title + '\'' +
                ", appliancePurpose=" + appliancePurpose +
                ", power=" + power +
                ", weight=" + weight +
                ", color=" + color +
                ", isPlugged=" + isPlugged +
                '}';
    }

}
