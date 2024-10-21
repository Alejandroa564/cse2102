package com.example;
public class GlutenFreePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing Gluten free Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Gluten free Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Gluten free Pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing Gluten free Pizza");
    }
}
