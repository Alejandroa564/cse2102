package com.example;
public class GlutenFreePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing gluten free Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking gluten free Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting gluten free Pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing gluten free Pizza");
    }
}
