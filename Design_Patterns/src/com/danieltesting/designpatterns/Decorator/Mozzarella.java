package com.danieltesting.designpatterns.Decorator;

public class Mozzarella extends ToppingDecorator{

    public Mozzarella(Pizza newPizza) {
        super(newPizza);

        //This is was plain pizza does
        System.out.println("Adding Dough");

        System.out.println("Adding Mozzarella ");

    }

    public String getDescription(){
        //with this topping we add mozzarella so we also add it to the message
        return tempPizza.getDescription()+", Mozzarella";

    }

    public double getCost(){
        //Mozzarella has a cost of .50, so we add it to the cost of the pizza
        return tempPizza.getCost()+.50;

    }

}
