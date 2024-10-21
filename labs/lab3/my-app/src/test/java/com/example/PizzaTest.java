package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PizzaTest {

    private PizzaFactory pizzaFactory;
    private PizzaStore pizzaStore;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @Before
    public void setUp() {
        // Initialize the PizzaFactory and PizzaStore before each test
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
    
    @Test
    public void testCheesePizza() {
        System.setOut(new PrintStream(outContent));
        Pizza pizza = pizzaStore.orderPizza("cheese");
        assertTrue(pizza instanceof CheesePizza);
        assertEquals("Preparing Cheese Pizza\nBaking Cheese Pizza\nCutting Cheese Pizza\nBoxing Cheese Pizza\n", outContent.toString());
        System.setOut(originalOut);
    }

    @Test
    public void testGreekPizza() {
        System.setOut(new PrintStream(outContent));
        Pizza pizza = pizzaStore.orderPizza("greek");
        assertTrue(pizza instanceof GreekPizza);
        assertEquals("Preparing Greek Pizza\nBaking Greek Pizza\nCutting Greek Pizza\nBoxing Greek Pizza\n", outContent.toString());
        System.setOut(originalOut);
    }

    @Test
    public void testPepperoniPizza() {
        System.setOut(new PrintStream(outContent));
        Pizza pizza = pizzaStore.orderPizza("pepperoni");
        assertTrue(pizza instanceof PepperoniPizza);
        assertEquals("Preparing Pepperoni Pizza\nBaking Pepperoni Pizza\nCutting Pepperoni Pizza\nBoxing Pepperoni Pizza\n", outContent.toString());
        System.setOut(originalOut);
    }

    @Test
    public void testGlutenFreePizza() {
        System.setOut(new PrintStream(outContent));
        Pizza pizza = pizzaStore.orderPizza("glutenfree");
        assertTrue(pizza instanceof GlutenFreePizza);
        assertEquals("Preparing Gluten free Pizza\nBaking Gluten free Pizza\nCutting Gluten free Pizza\nBoxing Gluten free Pizza\n", outContent.toString());
        System.setOut(originalOut);
    }
    
}


