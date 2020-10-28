package bg.fmi.mjt.lab.coffee_machine.container;

import bg.fmi.mjt.lab.coffee_machine.supplies.Beverage;

public class BasicContainer extends Container{
	private final double coffee;
	private final double water;
	
	private double currentCoffee;
	private double currentWater;
	public BasicContainer(double coffee, double water) {
        this.coffee = coffee;
        this.currentCoffee = coffee;

        this.water = water;
        this.currentWater = water;
    }
	public void refill() {
        currentCoffee = coffee;
        currentWater = water;
    }
	
	public double getCurrentWater() {
		return currentWater;
	}

	
	public double getCurrentMilk() {
		return 0;
	}

	
	public double getCurrentCoffee() {
		return currentCoffee;
	}

	
	public double getCurrentCacao() {
		return 0;
	}
	
	public void useSupplies(Beverage beverage) {
        currentCoffee -= beverage.getCoffee();
        currentWater -= beverage.getWater();
    }


}
