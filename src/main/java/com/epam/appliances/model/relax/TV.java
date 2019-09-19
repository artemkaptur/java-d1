package com.epam.appliances.model.relax;

import com.epam.appliances.exception.CannotTurnOnDueToParentalControlException;
import com.epam.appliances.model.Color;
import com.epam.appliances.model.TurnOnByTime;

import java.util.Objects;

import static com.epam.appliances.model.AppliancePurpose.RELAX;

public class TV extends RelaxAppliance implements TurnOnByTime {

    private int screenSize;
    private boolean isFourK;

    public TV(String title, int power, int weight, Color color) {
        super(title, RELAX, power, weight, color);
    }

    public int getScreenSize() {
        return screenSize;
    }

    public TV setScreenSize(int screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public boolean isFourK() {
        return isFourK;
    }

    public TV setFourK(boolean fourK) {
        isFourK = fourK;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TV tv = (TV) o;
        return getScreenSize() == tv.getScreenSize() &&
                isFourK() == tv.isFourK();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getScreenSize(), isFourK());
    }

    @Override
    public String toString() {
        return "TV{" +
                "screenSize=" + screenSize +
                ", isFourK=" + isFourK +
                ", isParentalControlOn=" + isParentalControlOn +
                ", title='" + title + '\'' +
                ", appliancePurpose=" + appliancePurpose +
                ", power=" + power +
                ", weight=" + weight +
                ", color=" + color +
                ", isPlugged=" + isPlugged +
                '}';
    }

    @Override
    public void setTheTimer(int hour) throws CannotTurnOnDueToParentalControlException {
        if (isRelaxAvailable(hour))
            timer = hour;
        else
            throw new CannotTurnOnDueToParentalControlException("Cannot set up the timer on TV due to parental control");
    }

}
