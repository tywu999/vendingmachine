Vending Machine
===============
In this assignment, you will see how a GUI (graphical user interface) is implemented using a Model-View-Controller pattern of software design. Although the **Model** class is the only class you need to modify and complete, feel free to look at the other files to see how the different classes work together.

***Note: class variables (which we introduced as properties) are also known as fields***

Write a class named **Model** for the vendingMachine package. This class implements the actions of a vending machine which allows coins to be deposited and products to be bought (or transactions to be cancelled). It consists of some fields (you will have to infer most of these; plan on adding/removing fields as you implement/debug this class), methods, and a constructor with no parameters. It must implement the following **public** methods (see their headers below), which are called by the **Controller** and **View** classes to simulate a vending machine. The program will not compile without these methods; you can write other **private** helper methods for this class as well, to avoid duplicating code.

**void cancel()** is called when the _cancel_ button is pressed. It should terminate any pending sale and return whatever coins the user has deposited. When the view is updated, it should explain this action in the message window at the bottom.

**void deposit(int amount)** is called when any of the money buttons are pressed (its parameter indicates how much money was deposited: it is always 5, 10, or 25 cents). When the view is updated, it should explain this action in the message window at the bottom.

**void buy (String product)** is called when any of the buy buttons are pressed (its parameter indicates which product is bought: it is either "Pepsi" or "Coke"). When the view is updated, it should explain this action in the message window at the bottom, including how much change is returned. Note that when an item runs out, the button to buy that item become un-pressable.

There are six accessors ("getters"), each of which the view calls when it needs to display information about the state of the vending machine (for example, to determine whether or not a buy button is pressable).

**String getDeposited()** returns the total amount of money deposited since the transaction started.

**String getMessage()** returns the message to display (at the bottom, in blue).

**int getCokeLeft()** returns the number of coke bottles in the machine.

**int getPepsiLeft()** returns the number of pepsi bottles in the machine.

**String getCokePrice()** returns the price of a coke.

**String getPepsiPrice()** returns the price of a pepsi.

Run the executable for further information (in the Project window of IntelliJ, right-click on Application.jar and select 'Run Application.jar').

Deposit coins, make purchases (or cancel the purchases; try to make purchases with too little money) and observe the information that the view displays; it should work according to your expectations of how a vending machine should work. Pay particularly close attention to...

...what happens when you cancel a purchase; you get back exactly the coins you deposited (e.g., if you put in 3 dimes, you get three dimes back, not a quarter and a nickel). Note that the result must read correctly: e.g., 1 dime but 2 dimes.
  
...what happens when there is not enough (or not the right kind of) change left to make a purchase (the purchase should be disallowed).
  
...what happens when there is enough change to make a purchase. It should return the fewest number of coins possible. Be careful, though: the change might be 25 cents, but it could be returned as 1 dime and 3 nickels because there are no quarters and only one dime.

For debugging purposes, each pressed button prints some information in the console window. Notice that the information returned from the **toString** method in the **Model** class is displayed in the console window too, for debugging purposes.

Finally, remember to call **view.update()** whenever the state of the **model** has changed; this tells the **view** to recollect all the information that it needs to redisplay itself: in this case it will call all the tiny accessors to determine what to display.

The constructor for the **Model class** should prompt the user to enter the starting number of quarters, dimes, nickels, coke bottles, pepsi bottles, coke cost, and pepsi cost (if you declare any other instance variables, initialize them appropriately without prompting). You do not need to alter code in the other classes in this package, but feel free to enhance the vending machine if you wish to.
