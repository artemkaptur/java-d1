package com.epam.appliances.model;

public enum Color implements Criterion {

    GREY(142, 142, 147),
    WHITE(255, 255, 255),
    BLACK(0, 0, 0),
    BROWN(165, 42, 42),
    BLUE(0, 0, 255);

    private Color(final Integer red, final Integer green, final Integer blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    private final Integer red, green, blue;

    public String getRGB() {
        return red + "," + green + "," + blue;
    }

}
