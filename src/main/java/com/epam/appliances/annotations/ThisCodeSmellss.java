package com.epam.appliances.annotations;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface ThisCodeSmellss {
    ThisCodeSmells[] value();
}
