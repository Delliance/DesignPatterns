package com.danieltesting.designpatterns.Decorator;

public class TomatoSauce extends ToppingDecorator{

    public TomatoSauce(Pizza newPizza) {
        super(newPizza);

        System.out.println("Adding Sauce ");

    }

    public String getDescription(){
        //with this topping we add mozzarella so we also add it to the message
        return tempPizza.getDescription()+", Tomato Sauce";

    }

    public double getCost(){
        //Mozzarella has a cost of .50, so we add it to the cost of the pizza
        return tempPizza.getCost()+.35;

    }

}