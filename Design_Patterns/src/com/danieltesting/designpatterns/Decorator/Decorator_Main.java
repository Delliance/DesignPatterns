package com.danieltesting.designpatterns.Decorator;

import com.danieltesting.designpatterns.Main;

public class Decorator_Main extends Main {

    public static void decoratorMain(){

        // here we are adding all the ingredients
        Pizza basicPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));

        //here we prove that the pizza has been created
        System.out.println("Ingredients: "+basicPizza.getDescription());
        System.out.println("Price: "+basicPizza.getCost());


    }

}
