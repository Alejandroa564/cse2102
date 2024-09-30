package com.example;
public class PepperoniPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing peperoni  Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking peperoni  Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting peperoni  Pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing peperoni  Pizza");
    }
}
