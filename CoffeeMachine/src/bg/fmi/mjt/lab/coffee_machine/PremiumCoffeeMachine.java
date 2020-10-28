package bg.fmi.mjt.lab.coffee_machine;

import bg.fmi.mjt.lab.coffee_machine.container.Container;
import bg.fmi.mjt.lab.coffee_machine.container.PremiumContainer;
import bg.fmi.mjt.lab.coffee_machine.supplies.Beverage;
import bg.fmi.mjt.lab.coffee_machine.supplies.Cappuccino;
import bg.fmi.mjt.lab.coffee_machine.supplies.Espresso;
import bg.fmi.mjt.lab.coffee_machine.supplies.Mochaccino;

public class PremiumCoffeeMachine implements CoffeeMachine {
	private static final double MAX_COFFEE = 1000; 
    private static final double MAX_WATER = 1000; 
    private static final double MAX_MILK = 1000; 
    private static final double MAX_CACAO = 300; 
	private PremiumContainer container;
	private Lucks lucks;
	private boolean autoRefill;
	public PremiumCoffeeMachine() {
		container=new PremiumContainer(MAX_COFFEE,MAX_WATER,MAX_MILK,MAX_CACAO);
		lucks = new Lucks();
	}
	public PremiumCoffeeMachine(boolean autoRefill) {
		container=new PremiumContainer(MAX_COFFEE,MAX_WATER,MAX_MILK,MAX_CACAO);
		lucks = new Lucks();
		this.autoRefill=autoRefill;
	}
	
    public Product brew(Beverage beverage){
		return brew(beverage,1);
	}
    public Product brew(Beverage beverage, int quantity) {
    	if (!(beverage instanceof Espresso) && !(beverage instanceof Cappuccino) && !(beverage instanceof Mochaccino)) {
            return null;
        }
    	if(quantity<=0 || quantity>3) {
    		return null;
    	}
    	if (!enoughSupplies(beverage)) {
             if (!autoRefill) {
                 return null;
             }

             container.refill();
         }

         container.useSupplies(beverage);

         return new Product(beverage.getClass().getSimpleName(), quantity, lucks.generateLuck());
    }
    public boolean enoughSupplies(Beverage beverage) {
		return beverage.getWater() <= container.getCurrentWater() && beverage.getCoffee() <= container.getCurrentCoffee() 
				&& beverage.getMilk() <= container.getCurrentMilk() && beverage.getCacao() <= container.getCurrentCacao();
	}
	public Container getSupplies(){
		return new PremiumContainer(container.getCurrentCoffee(),container.getCurrentWater(),container.getCurrentMilk(),container.getCurrentCacao());
	}
	
	public void refill() {
		container.refill();
	}

}
