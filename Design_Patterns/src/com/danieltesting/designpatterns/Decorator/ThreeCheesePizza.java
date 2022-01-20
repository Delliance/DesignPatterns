package com.danieltesting.designpatterns.Decorator;

// this is the old way to create pizzas
// this method requires that for each possible combination
//if pizza, you will need to create a new class
//in other words, each of the toppings(decorations)
//combinations create a new class

/*

public class ThreeCheesePizza extends Pizza{

    /////////////////////////7
    //This is the old way to create a pizza, if I want
    // to create any other type of pizza, I'll need to
    // create a new class, and so on, for an infinite number
    // of different pizzas

    @Override
    public void setDescription(String newDescription) {

    }

    @Override
    public String getDescription() {
        return "Mozzarella, Fontina, Parmesan, Cheese Pizza";
    }


    //Same problem with the cost, for example it may not be by
    //type of pizza but for the prize of the ingredients,
    //for example, prize of pizza increases if cheese price increse
    @Override
    public double getCost() {
        return 10.00;
    }

}

 */
