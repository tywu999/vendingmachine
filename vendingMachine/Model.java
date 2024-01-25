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


import java.lang.Math;


public class Model {

   //Define constructor
   
   //Refer to the view (used to call update after each button press)
	 public void addView(View v)
	 {view = v;}

   //Define required methods: mutators and accessors
   
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

   //Define helper methods

   //Define fields (all instance variables)
	     
	 private View view;         // Model must tell View when to update itself
	 
	 private int    cokeLeft;
	 private int    pepsiLeft;
	 
	 private int    quartersLeft, dimesLeft, nickelsLeft;
	 
	 //I defined about 10 more fields
}