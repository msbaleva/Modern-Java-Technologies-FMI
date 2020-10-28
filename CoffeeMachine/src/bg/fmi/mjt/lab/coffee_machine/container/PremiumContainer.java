package bg.fmi.mjt.lab.coffee_machine.container;

import bg.fmi.mjt.lab.coffee_machine.supplies.Beverage;

public class PremiumContainer extends BasicContainer{
	 private final double milk;
	 private final double cacao;

	 private double currentMilk; 
	 private double currentCacao; 

	 public PremiumContainer(double coffee, double water, double milk, double cacao) {
		 super(coffee,water);
		 this.milk=milk;
		 this.cacao=cacao;
		 
		 this.currentMilk=milk;
		 this.currentCacao=cacao;
		 
	 }
	 
	 @Override
	 public void refill() {
		 super.refill();
		 currentMilk = milk;
	     currentCacao = cacao;
		 
	 }
	 
	 @Override
	 public double getCurrentMilk() {
		 return currentMilk;
	 }
	 
	 @Override 
	 public double getCurrentCacao() {
		 return currentCacao;
	 }
	 
	 @Override
	 public void useSupplies(Beverage beverage) {
		 super.useSupplies(beverage);
		 currentMilk -= beverage.getMilk();
	     currentCacao -= beverage.getCacao();
	 }
}
