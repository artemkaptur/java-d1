package com.epam.appliances;

import java.io.IOException;

import static com.epam.appliances.util.AnnotationHandler.runAllProdMethods;

public class ProdRunner {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        runAllProdMethods();
    }

}
