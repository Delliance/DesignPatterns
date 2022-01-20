package com.danieltesting.designpatterns.Decorator;

abstract class ToppingDecorator implements Pizza{

    protected Pizza tempPizza;

    //Here wht we are doing is creating a new pizza
    //from there we start placing decorations
    public ToppingDecorator(Pizza newPizza){

    tempPizza = newPizza;

    }

    public String getDescription(){

        return tempPizza.getDescription();

    }

    public double getCost(){

        return tempPizza.getCost();

    }

}
