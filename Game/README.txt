Student name:Ahmed Karim
Student number: 200175605

Now complete the statements below for each level you wish to be marked. Replace all text in square brackets.

LEVEL ONE

My code demonstrates inheritance in the following way...

I have a superclass called [Character]

This superclass is extended into at least two subclasses called [NPC and Player]

For each of the named subclasses complete the following...

Subclass 1.

Subclass [Player] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [inventory,HP,currentNation]

These/this new properties/property are used by the subclass in the following way: [Inventory is an array of items used to keep a record of all the items that the player holds. Other than the getters there are many other usecases. I used createInventory(int sizeOfInv) on line 39, where an invenotry of any size specified is created. Also there is a method spaceAvailableInv(Player p) on line 58 to check how much space is left in inventory. Also I have properties addItem(Player p, Item item) on line 71 which is used to add an item to the Player's inventory, it incooperates the method spaceAvaiableInv(Player p). If the inventory is full than it wont add the item. I also used dropItem(Items item) on line 88 to drop an item from the inventory. Also the player can fight a character which is a fighter on line 114, and the outcome will depend on whether the player has a weapon inside his inventory. A trade method is also used to trade items with any trader on line 143. It works by checking if an item is available and then addItem or dropItem depending on what the trade did. I also added a travelNation(Nation n) method on line 173 where I can travel to other Nations which is a class on its own. levelUp is also a method that can be attributed to the player.]

Subclass 2.

Subclass [NPC] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [Level and fightable]

These/this new properties/property are used by the subclass in the following way: [I added properties level and fightable which are integer and boolean, this is beacause the subclasses of NPC are either able to fight or not and also all have a level associated with them. This class is very basic and more of an abstarct class than an actual object. The subclasses that follow it are more complicated.]



SuperClass 2:

I have a superclass called [Items]
This superclass contains 2 subclasses called [Weapon and Potion]

Subclass 1
Subclass [Weapon] extends the superclass by adding at least one property and its getters and setters. The names of the added properties are[durability and damage]
These new properties are used in subclass in the following way[I added these properties as they are specific to weapons, not all items will have a durability and damage, only the weapons of those items will have such a thing. There is a method reduceDurability(int durability ) which is used in useItem(Player p) on lines 23 and 27. This is done because everytime a weapon is used then its durability is decreased by 1, so that when the durability reaches 0, the method checkIfItemDamaged() on line 37 is used to reduce the damage output of that weapon to 0.   The method useItem(Player p), overrides the method useItem(Player p) in the superclass so the program will only know what to do with this at run time. ]

These overridden methods are used in the working code in the following places: [Game line 339 we use the overriden method useItem(Player p) ]

Subclass 2:

Subclass [Potion] extends the superclass by adding at least one property and its getters and setters. The names of the added properties are [typeOfPotion and effectiveness].

These new properties are used in subclass in the following way[I added these properties as each potion will have a specific type that is assigned to, and also the effectiveness of the potion too. the effectives will determine how much HP you will lose or gain, Also in the constructor, all the potions are not upgradable which the upgradable property came from the superclass. Also in the Potion class on line 21, useItem(Player p) overrides the method useItem in the superclass which is on line 30. ]

These overridden methods are used in the working code in the following places: [Game line 386 we use the overriden method useItem(Player p) ]



LEVEL TWO

Polymorphism consists of the use of the Substitution principle and Late Dynamic binding.

In my code, polymorphism is implemented in at least two places…

Example 1.

The substitution principle can be seen in use in [The class is used in Game, and it was used on line 43.]. The name of the superclass used this example is [Items] and the subclasses used are [Weapon and Poition].

Late dynamic binding can be seen in [Game and used on line 339, where there Items, Weapon and Potion class all have the method useItem(Player p), but it is only at run time where it sees which useItem() to use, since both superclass and the subclass have the same method name and arguements.].

[This was necassary as the Common Items are meeant to be randomly dropped for the Player to pickup. Since Items can be various things, it is much more effienet if I put everything into one array called item and then the player can add any item that comes under the class Items into his inventory, otherwise if I only put weapon for instance, than the player could only pick up weapons but I want the player to pick up any common item he wishes to pick up.]

Example 2.

The substitution principle can be seen in use in [Game and used on line 56]. The name of the superclass used this example is [Items] and the subclasses used are [Weapon and Potion].

Late dynamic binding can be seen in [Game line 501].

[This is extremely important as I want the user to be able to interact with any legendary item he sees, whether it is a potion or a weapon, with polymorphosim I am able to store it all into one array and also the Player is able to pick up or drop any item from that array. All the items in the LegenedaryItems[] can be used with the Player class when using things like addItem.]


P.S -> The game is very large and many options, I would reccommend your choices should be 1YN3Y421, but you can choose whatever you want, it just means the game will be shorter.
