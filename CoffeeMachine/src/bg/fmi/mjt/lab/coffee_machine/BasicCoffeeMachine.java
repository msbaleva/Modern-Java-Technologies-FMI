package bg.fmi.mjt.lab.coffee_machine;

import bg.fmi.mjt.lab.coffee_machine.container.BasicContainer;
import bg.fmi.mjt.lab.coffee_machine.container.Container;
import bg.fmi.mjt.lab.coffee_machine.supplies.Beverage;
import bg.fmi.mjt.lab.coffee_machine.supplies.Espresso;

public class BasicCoffeeMachine implements CoffeeMachine {
	private static final double MAX_COFFEE = 600; 
    private static final double MAX_WATER = 600; 
    private BasicContainer container;
    
    public BasicCoffeeMachine() {
		container=new BasicContainer(MAX_COFFEE,MAX_WATER);
	}
	
	public Product brew(Beverage beverage){
		if(!(beverage instanceof Espresso) || !enoughSupplies(beverage)) {
			return null;
		}
		container.useSupplies(beverage);
		return new Product(beverage.getName(),1,null);
	}
	
	public boolean enoughSupplies(Beverage beverage) {
		return beverage.getWater() <= container.getCurrentWater() && beverage.getCoffee() <= container.getCurrentCoffee();
	}
	public Container getSupplies(){
		return new BasicContainer(container.getCurrentCoffee(),container.getCurrentWater());
	}
	public void refill() {
		container.refill();
	}

}
