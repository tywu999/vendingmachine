//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//
// Class          : vendingMachine.Model
//
// Author         : Richard E. Pattis
//                  Computer Science Department
//                  Carnegie Mellon University
//                  5000 Forbes Avenue
//                  Pittsburgh, PA 15213-3891
//                  e-mail: pattis@cs.cmu.edu
//
// Maintainer     : Author
//
//
// Description:
//
//   The Model for the VendingMachine package implements the guts of the
// vending machine: it responds to presses of buttons created by the
// Conroller (deposit, cancel, buy), and tells the View when it needs
// to update its display (calling the update in view, which calls the
// accessor methods in this classes)
// 
//   Note that "no access modifier" means that the method is package
// friendly: this means the member is public to all other classes in
// the calculator package, but private elsewhere.
//
// Future Plans   : More Comments
//                  Increase price as stock goes down
//                  Decrease price if being outsold by competition
//                  Allow option to purchase even if full change cannot 
//                    be returned (purchaser pays a premium to quench thirst)
//                  Allow user to enter 2 x money and gamble: 1/2 time
//                    all money returned with product; 1/2 time no money and
//                    no product returned
//
// Program History:
//   9/20/01: R. Pattis - Operational for 15-100
//   2/10/02: R. Pattis - Fixed Bug in change-making method
//
//
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////



package vendingMachine;
import java.util.*;

import java.lang.Math;


public class Model {
	//Define fields (all instance variables)
	
	private View view;         // Model must tell View when to update itself
	
	private int    cokeLeft;
	private int    pepsiLeft;
	
	private int    quartersLeft, dimesLeft, nickelsLeft;
	private int cokePrice, pepsiPrice;
	private  int amount;
	private String message;
	private int[] cents = new int[3];

	public Model(){
		this.quartersLeft = ask("Enter quarters   to start(10): ");
		this.dimesLeft = ask("Enter dimes      to start(10): ");
		this.nickelsLeft = ask("Enter nickels    to start(10): ");
		this.pepsiLeft = ask("Enter pepsi       to start(5): ");
		this.cokeLeft = ask("Enter coke        to start(5): ");
		this.pepsiPrice = ask("Enter pepsi cost in cents(85): ");
		this.cokePrice = ask("Enter coke  cost in cents(95): ");
		toString();
	}
	public int ask(String question){
		System.out.println(question);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();

	}
	public void addView(View v)
	{view = v;}
	
	//Define required methods: mutators (setters) and accessors (getters)
	
	//Represent "interesting" state of vending machine
	public String toString()
	{
		return "Vending Machine State: \n" +
			"  Coke     Left      = " + cokeLeft     + "\n" +
			"  Pepsi    Left      = " + pepsiLeft    + "\n" +
			"  Quarters Left      = " + quartersLeft + "\n" +
			"  Dimes    Left      = " + dimesLeft    + "\n" +
			"  Nickels  Left      = " + nickelsLeft  + "\n";
		//Display any other instance variables that you declare too
	}
	public void deposit(int amount){
		if(amount == 5 && nickelsLeft>=1){
			nickelsLeft--;
			cents[0]++;
		}
		if(amount == 10&&dimesLeft>=1){
			dimesLeft--;
			cents[1]++;
		}
		if(amount == 25&&quartersLeft>=1){
			quartersLeft--;
			cents[2]++;
		}
		message = amount + "cents deposited";
		view.update();
	}

	public void cancel(){
		nickelsLeft += cents[0];
		cents[0]= 0;
		dimesLeft += cents[1];
		cents[1] = 0;
		quartersLeft += cents[2];
		cents[2] = 0;
		view.update();
	}
	public void buy(String product){
		if(product.equals("Pepsi") && (cents[0]*5+cents[1]*10+cents[2]*25) >= pepsiPrice){
			pepsiLeft--;
			int money = pepsiPrice;
			while(money > 24 && cents[2] > 0){
				money -= 25;
				cents[2]--;
			}
			while(money > 9 && cents[1] > 0){
				money -= 10;
				cents[1]--;
			}
			while(money > 4 && cents[0] > 0){
				money -= 5;
				cents[0]--;
			}
			if(money > 0) {
				while (cents[1] > 0 && money > 0) {
					money -= 10;
					cents[1]--;
				}
			}
			if(money > 0){
				while(cents[2] > 0 && money > 0){
					money -= 25;
					cents[2]--;
				}
			}
			money = (int)Math.abs(money*0.2);
			cents[0] += (money);
			cancel();
		}
		else if(product.equals("Coke") && (cents[0]*5+cents[1]*10+cents[2]*25) >= cokePrice){

			cokeLeft--;
			int money = cokePrice;
			while(money > 24 && cents[2] > 0){
				money -= 25;
				cents[2]--;
			}
			while(money > 9 && cents[1] > 0){
				money -= 10;
				cents[1]--;
			}
			while(money > 4 && cents[0] > 0){
				money -= 5;
				cents[0]--;
			}
			if(money > 0) {
				while (cents[1] > 0 && money > 0) {
					money -= 10;
					cents[1]--;
				}
			}
			if(money > 0){
				while(cents[2] > 0 && money > 0){
					money -= 25;
					cents[2]--;
				}
			}
			money = (int)Math.abs(money*0.2);
			cents[0] += (money);

			cancel();
		}


	}

	public String getDeposited(){
		return "$" + (cents[0]*0.05+cents[1]*0.10+cents[2]*0.25);
	}
	public int getCokeLeft(){
		return cokeLeft;
	}
	public int getPepsiLeft(){
		return pepsiLeft;
	}
	public String getCokePrice(){
		double a = cokePrice*0.01;
		return "$"+(a);
	}
	public String getPepsiPrice(){
		double a = pepsiPrice*0.01;
		return "$"+(a);
	}
	public String getMessage(){
		if(amount == 5){
			return "5 cents deposited";
		}
		if(amount == 10){
			return "10 cents deposited";
		}
		if(amount == 25){
			return "25 cents deposited";
		}
		return "";
	}
	
	//Define helper methods

}
