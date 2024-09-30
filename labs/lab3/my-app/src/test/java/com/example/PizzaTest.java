package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PizzaTest {

    private PizzaFactory pizzaFactory;
    private PizzaStore pizzaStore;

    // Set up the factory and store before running tests
    @Before
    public void setUp() {
        pizzaFactory = new PizzaFactory();
        pizzaStore = new PizzaStore(pizzaFactory);
    }

    // Test creating a Cheese Pizza
    @Test
    public void testCheesePizzaCreation() {
        Pizza pizza = pizzaFactory.createPizza("cheese");
        assertNotNull("Pizza should not be null", pizza);
        assertTrue("Pizza should be instance of CheesePizza", pizza instanceof CheesePizza);
    }

    // Test creating a Greek Pizza
    @Test
    public void testGreekPizzaCreation() {
        Pizza pizza = pizzaFactory.createPizza("greek");
        assertNotNull("Pizza should not be null", pizza);
        assertTrue("Pizza should be instance of GreekPizza", pizza instanceof GreekPizza);
    }

    // Test creating a Pepperoni Pizza
    @Test
    public void testPepperoniPizzaCreation() {
        Pizza pizza = pizzaFactory.createPizza("pepperoni");
        assertNotNull("Pizza should not be null", pizza);
        assertTrue("Pizza should be instance of PepperoniPizza", pizza instanceof PepperoniPizza);
    }

    // Test creating a GlutenFree Pizza
    @Test
    public void testGlutenFreePizzaCreation() {
        Pizza pizza = pizzaFactory.createPizza("glutenfree");
        assertNotNull("Pizza should not be null", pizza);
        assertTrue("Pizza should be instance of GlutenFreePizza", pizza instanceof GlutenFreePizza);
    }

    // Test ordering Cheese Pizza via PizzaStore
    @Test
    public void testOrderCheesePizza() {
        Pizza pizza = pizzaStore.orderPizza("cheese");
        assertNotNull("Pizza should not be null", pizza);
        assertTrue("Pizza should be instance of CheesePizza", pizza instanceof CheesePizza);
    }

    // Test ordering Greek Pizza via PizzaStore
    @Test
    public void testOrderGreekPizza() {
        Pizza pizza = pizzaStore.orderPizza("greek");
        assertNotNull("Pizza should not be null", pizza);
        assertTrue("Pizza should be instance of GreekPizza", pizza instanceof GreekPizza);
    }

    // Test ordering Pepperoni Pizza via PizzaStore
    @Test
    public void testOrderPepperoniPizza() {
        Pizza pizza = pizzaStore.orderPizza("pepperoni");
        assertNotNull("Pizza should not be null", pizza);
        assertTrue("Pizza should be instance of PepperoniPizza", pizza instanceof PepperoniPizza);
    }

    // Test ordering GlutenFree Pizza via PizzaStore
    @Test
    public void testOrderGlutenFreePizza() {
        Pizza pizza = pizzaStore.orderPizza("glutenfree");
        assertNotNull("Pizza should not be null", pizza);
        assertTrue("Pizza should be instance of GlutenFreePizza", pizza instanceof GlutenFreePizza);
    }

    // Test for invalid pizza type
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPizzaType() {
        pizzaFactory.createPizza("invalidPizzaType");
    }

    // Test the pizza preparation process for Cheese Pizza
    @Test
    public void testPizzaProcess() {
        Pizza pizza = pizzaStore.orderPizza("cheese");
        assertNotNull("Pizza should not be null", pizza);
        assertTrue("Pizza should be instance of CheesePizza", pizza instanceof CheesePizza);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }
}