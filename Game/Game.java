import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import static java.lang.Math.sqrt;

public class Game {
    
    public static String inputString(String message){ //Receives an input of type string

            Scanner scanner = new Scanner(System.in);
            System.out.println(message);
            String answer = scanner.nextLine();
            return answer;
}
       
    public static int inputInt(String message){  //Receives an input of type integer

            Scanner scanner = new Scanner(System.in);
            System.out.println(message);
            int answer = scanner.nextInt();
            return answer;
}


public static int startingNation(){
    System.out.println("Which Nation would you like to start of with?");
    
    int question = inputInt("1.Athens , 2.Persia , 3.Arabia , 4.Rome");     
    
    return question;
}


     
    public static void main(String[] args){
        
        System.out.println("The Trading/Fighting Game");
        System.out.println("Welcome! Hope You Enjoy!\n");
        
        boolean game_over = false;
        
            Items[] CommonItems = {
                new Weapon("Bronze Dagger","Common",5,4),
                new Potion("Healing Potion","Common","Type 1",2),  //Common items
                new Weapon("Iron Sword","Common",15,8), 
                new Weapon("Axe","Common",13,6),
                new Potion("Poison","Common","Type 1", -2)};
         
            Items[] RareItems = {  //All the Rare items
                new Weapon("Gold Sword","Rare",9,7),
                new Weapon("Mace","Rare",20,10),
                new Potion("Healing Potion","Rare","Type 2",5),
                new Potion("Poison","Rare","Type 2",-5)};
                
            Items[] LegendaryItems = {  //All the legendary items
                new Weapon("Diamond Sword","Legendary",30,20),
                new Weapon("Dragonite Bomb","Legendary",1,18),
                new Weapon("CrossBow","Legendary",1000,4),
                new Potion("Strength","Legendary","Type 3",6)}; 
               
            
            Fighter[] AthenianSoldiers = new Fighter[10];
            Trader[] AthenianMerchants = new Trader[10];
           
            Fighter[] PersianSoldiers = new Fighter[10];
            Trader[] PersianMerchants = new Trader[10];
            
            Fighter[] ArabianSoldiers = new Fighter[10];
            Trader[] ArabianMerchants = new Trader[10];
            
            Fighter[] RomanSoldiers = new Fighter[10];
            Trader[] RomanMerchants = new Trader[10];
            
            Nation Athens = new Nation("Athens",5,AthenianSoldiers,AthenianMerchants); //Athens
            Nation Persia = new Nation("Persia",12,PersianSoldiers,PersianMerchants); //Persia
            Nation Arabia = new Nation("Arabia",7,ArabianSoldiers,ArabianMerchants);
            Nation Rome = new Nation("Rome",10,RomanSoldiers,RomanMerchants);
            
            Nation Start = new Nation("0",0,null,null); //Starting Default Position
            
            boolean chosen = false;
            Random random = new Random(); 
            boolean SoldierLeaves = false; //for example if the soldier allows you to travel than you should not be able to talk to him anymore
            
            Player Ahmed = new Player("Ahmed Karim",Start);
            Ahmed.createInventory(10);
            //Ahmed.addItem(Ahmed,LegendaryItems[0]);
            
            //create random Merchant attributes in the arrays and also give them all an inventory
            for(int i = 0; i<AthenianMerchants.length; i++){ 
                
                AthenianMerchants[i] = new Trader(random.nextInt(15) + 1,Athens);
                PersianMerchants[i] = new Trader(random.nextInt(20) + 3,Persia);
                ArabianMerchants[i] = new Trader(random.nextInt(25) + 2,Arabia);
                RomanMerchants[i] = new Trader(random.nextInt(20) + 1, Rome);  
               
            }
            
            for(int i = 0; i < 10; i++){
                AthenianMerchants[i].createInventory(10);
                PersianMerchants[i].createInventory(10);
                ArabianMerchants[i].createInventory(10);
                RomanMerchants[i].createInventory(10);
            }
            
            //creates random Power Levels within the soldiers of certain nations
            for(int i = 0; i < AthenianSoldiers.length; i++){
                AthenianSoldiers[i] = new Fighter(random.nextInt(10) + 4);
                PersianSoldiers[i] = new Fighter(random.nextInt(10) + 10);
                ArabianSoldiers[i] = new Fighter(random.nextInt(10) + 4);
                RomanSoldiers[i] = new Fighter(random.nextInt(10) + 8);
            }
            
            
            //assign random Items to the bags of the Merchants
            for(int i = 0; i < 10; i++){ //assigning athenians merchants items
                for(int j = 0; j < 10; j++){
                double numberGen = Math.random();
                
                if(numberGen < 0.7){
                     AthenianMerchants[j].addItem(CommonItems[random.nextInt(5)]);                     
                }
                else if(numberGen >= 0.7 && numberGen < 0.95){
                    AthenianMerchants[j].addItem(RareItems[random.nextInt(4)]);
                }
                else if(numberGen >= 0.95){
                    AthenianMerchants[j].addItem(LegendaryItems[random.nextInt(4)]);
                }
            }
        }
            
        
           for(int i = 0; i < 10; i++){ //assigning persian merchants items
                for(int j = 0; j < 10; j++){
                double numberGen = Math.random();
                
                if(numberGen < 0.5){
                     PersianMerchants[j].addItem(CommonItems[random.nextInt(5)]);
                }
                else if(numberGen >= 0.5 && numberGen < 0.9){
                    PersianMerchants[j].addItem(RareItems[random.nextInt(4)]);
                }
                else if(numberGen >= 0.9){
                    PersianMerchants[j].addItem(LegendaryItems[random.nextInt(4)]);
                }
            }
        }
        
        for(int i = 0; i < 10; i++){ //assigning arabian merchants items
                for(int j = 0; j < 10; j++){
                double numberGen = Math.random();
                
                if(numberGen < 0.5){
                     ArabianMerchants[j].addItem(CommonItems[random.nextInt(5)]);
                }
                else if(numberGen >= 0.5 && numberGen < 0.8){
                    ArabianMerchants[j].addItem(RareItems[random.nextInt(4)]);
                }
                else if(numberGen >= 0.8){
                    ArabianMerchants[j].addItem(LegendaryItems[random.nextInt(4)]);
                }
            }
        }
        
        for(int i = 0; i < 10; i++){ //assigning arabian merchants items
                for(int j = 0; j < 10; j++){
                double numberGen = Math.random();
                
                if(numberGen < 0.6){
                     RomanMerchants[j].addItem(CommonItems[random.nextInt(5)]);
                }
                else if(numberGen >= 0.6 && numberGen < 0.92){
                    RomanMerchants[j].addItem(RareItems[random.nextInt(4)]);
                }
                else if(numberGen >= 0.92){
                    RomanMerchants[j].addItem(LegendaryItems[random.nextInt(4)]);
                }
            }
        }
            
            
            int choice = startingNation(); //The questions
           
            if(choice == 1){
               Ahmed.setNation(Athens);
               System.out.println("Welcome to Athens fellow Traveller!\n");
            }
            else if(choice == 2){
               Ahmed.setNation(Persia);
               System.out.println("Welcome to Persia fellow Traveller!\n");
            }
            else if(choice == 3){
               Ahmed.setNation(Arabia);
               System.out.println("Welcome to Arabia fellow Traveller!\n");
            }
            else if(choice == 4){
               Ahmed.setNation(Rome);
               System.out.println("Welcome to Rome fellow Traveller!\n");
            }
            else{
                System.out.println("You didnt choose from the choices, Play Again");
            }
           
            
            
        
       while(game_over != true){ //Main game loop
           
           System.out.println("Now that you are in " + Ahmed.getCurrentNation().getNationName() 
           + " You see the richness of this Nation.\n");
           
           int randomItem = random.nextInt(5);
           Items randItem = CommonItems[randomItem];
           
           String pickUp = inputString("You see a "+ randItem.getItemName() + " on the ground, You should pick it up, Type Y or N");
           
           if(pickUp.equalsIgnoreCase("Y")){
               Ahmed.addItem(Ahmed,randItem); //puts item into inventroy slot
            }
           
           System.out.println("A Merchant from " + Ahmed.getCurrentNation().getNationName() 
           + " approaches you, He wants to trade, Would you like to accept?\n");
          
           String ansTrader = inputString("Press Y if you want to accept, or N if you want to leave");
           
           
           if(ansTrader.equalsIgnoreCase("Y")){
               
               if(Ahmed.getCurrentNation().getNationName().equals("Athens")){
                   System.out.println("This is the Merhcant's inventory");
                   AthenianMerchants[0].printInventory();
                   System.out.println("");
                   String whichItem = inputString("Which item would you like to trade from the Trader's item");
                   
                   for(int i = 0; i < AthenianMerchants[0].getInvLength();i++){
                       if(whichItem.equalsIgnoreCase(AthenianMerchants[0].getInv()[i].getItemName())){ //this checks if name of item matches input
                          
                          Ahmed.printInventory();
                          String yourItem = inputString("Which item will you give up for this item?");
                          
                          Ahmed.trade(Ahmed,AthenianMerchants[0],AthenianMerchants[0].getInv()[i],Ahmed.getInv()[i]);
                          
                          break;
                        }
                        
                    }
               }
               
               else if(Ahmed.getCurrentNation().getNationName().equals("Persia")){
                   System.out.println("This is the Merhcant's inventory");
                   PersianMerchants[0].printInventory();
                   System.out.println("");
                   String whichItem = inputString("Which item would you like to trade from the Trader's item");
                   
                   for(int i = 0; i < PersianMerchants[0].getInvLength();i++){
                       if(whichItem.equalsIgnoreCase(PersianMerchants[0].getInv()[i].getItemName())){ //this checks if name of item matches input
                          
                          Ahmed.printInventory();
                          String yourItem = inputString("Which item will you give up for this item?");
                          
                          Ahmed.trade(Ahmed,PersianMerchants[0],PersianMerchants[0].getInv()[i],Ahmed.getInv()[i]);
                          
                          break;
                        }
                        
                    }
               }
               
               else if(Ahmed.getCurrentNation().getNationName().equals("Arabia")){
                   System.out.println("This is the Merhcant's inventory");
                   ArabianMerchants[0].printInventory();
                   System.out.println("");
                   String whichItem = inputString("Which item would you like to trade from the Trader's item");
                   
                   for(int i = 0; i < ArabianMerchants[0].getInvLength();i++){
                       if(whichItem.equalsIgnoreCase(ArabianMerchants[0].getInv()[i].getItemName())){ //this checks if name of item matches input
                          
                          Ahmed.printInventory();
                          String yourItem = inputString("Which item will you give up for this item?");
                          
                          Ahmed.trade(Ahmed,ArabianMerchants[0],ArabianMerchants[0].getInv()[i],Ahmed.getInv()[i]);
                         
                          break;
                        }
                        
                    }
               }
               
               else if(Ahmed.getCurrentNation().getNationName().equals("Rome")){
                   System.out.println("This is the Merhcant's inventory");
                   RomanMerchants[0].printInventory();
                   System.out.println("");
                   String whichItem = inputString("Which item would you like to trade from the Trader's item");
                   
                   for(int i = 0; i < RomanMerchants[0].getInvLength();i++){
                       if(whichItem.equalsIgnoreCase(RomanMerchants[0].getInv()[i].getItemName())){ //this checks if name of item matches input
                          
                          Ahmed.printInventory();
                          String yourItem = inputString("Which item will you give up for this item?");
                          
                          Ahmed.trade(Ahmed,RomanMerchants[0],RomanMerchants[0].getInv()[i],Ahmed.getInv()[i]);
                         
                          break;
                        }
                        
                    }
               }
               
               System.out.println("\nThis game is incomplete due to how large it is, try again with different choices!\n");
               System.out.println("For example pick an item on the ground, but dont trade with the trader, to see what happens");
               break;
            }
               
               else if(ansTrader.equalsIgnoreCase("N")){ //if answer is no, you meet a soldier
                   
                   if(Ahmed.getCurrentNation().getNationName().equals("Athens")){ //athenian Soldier encounter
                   
                   AthenianMerchants[0].speak("I hope to see you again Adventurer");
                   System.out.println("");
                   System.out.println("You walk for a few minutes and you see a man wearing Iron Armour.\n");
                   System.out.println("He notices you.....\n");
                   
                   AthenianSoldiers[0].getCharacterInfo();
                   
                   
                   while(AthenianSoldiers[0].getAlive() == true){ //as long as he is alive you can ask multiple things
                 
                   int ansSoldier = inputInt("\nGreetings, How may I help?\n" +
                     "\n1.I will fight you right here, right now\n 2.What is this place?\n 3.How do I leave " + Ahmed.getCurrentNation().getNationName() + "\n 4.Nothing, GoodBye");
                   
                   //checks which choice the user had chosen
                     if(ansSoldier == 1){
                        System.out.println("You attack the soldier, His armour is tough!\n");
                        AthenianSoldiers[0].fight(Ahmed);
                        System.out.println("");
                        Ahmed.fight(AthenianSoldiers[0]);
                       
                        Ahmed.getInv()[0].useItem(Ahmed);
                     
                     
                        Ahmed.levelUp(1);
                        
                        if(Ahmed.getHP() <=0){
                            System.out.println("You were killed, Game Over!");
                            game_over = true;
                            break;
                        }
                     }
                     
                     else if(ansSoldier == 2){
                         AthenianSoldiers[0].speak("This place contains high level goblins and is quite dangerous.");
                         AthenianSoldiers[0].speak("Many Young travellers have went through this, and well.....\n");
                         AthenianSoldiers[0].speak("They never came back");
                         AthenianSoldiers[0].speak("We still wait one day for a saviour, until then, this place is out of bounds");
                     }
                     
                     else if(ansSoldier == 3){
                         AthenianSoldiers[0].speak("Well, You must take a ship to travel to another Nation, I can take you to Persia.\n");
                         String travelQuestion = inputString("Would you like to go to Persia? Type Y or N" );
                         if(travelQuestion.equalsIgnoreCase("Y")){
                             Ahmed.travelNation(Persia);
                             
                             
                    if(Ahmed.getCurrentNation().getNationName().equals("Persia")){ //athenian Soldier encounter
                   
                   PersianMerchants[0].speak("I hope to see you again Adventurer");
                   System.out.println("");
                   System.out.println("You walk for a few minutes and you see a man wearing Iron Armour.\n");
                   System.out.println("He notices you.....\n");
                   
                   PersianSoldiers[0].getCharacterInfo();
                   
                   while(PersianSoldiers[0].getAlive() == true){ //as long as he is alive you can ask multiple things
                 
                   ansSoldier = inputInt("\nGreetings, How may I help?\n" +
                     "\n1.I will fight you right here, right now\n 2.What is this place?\n 3.How do I leave " + Ahmed.getCurrentNation().getNationName() + "\n 4.Nothing, GoodBye");
                   
                   //checks which choice the user had chosen
                     if(ansSoldier == 1){
                        System.out.println("You attack the soldier, His armour is tough!\n");
                        PersianSoldiers[0].fight(Ahmed);
                        System.out.println("");
                        Ahmed.fight(PersianSoldiers[0]);
                        
                        Ahmed.getInv()[0].useItem(Ahmed);
                        
                        Ahmed.levelUp(1);
                        
                        if(Ahmed.getHP() <=0){
                            System.out.println("You were killed, Game Over!");
                            game_over = true;
                            break;
                        }
                      
                     }
                     
                     else if(ansSoldier == 2){
                         PersianSoldiers[0].speak("\nThis place is an ancient location full of historical artifacts.");
                         PersianSoldiers[0].speak("Many Travellers come here especially in the summer\n");
                         PersianSoldiers[0].speak("However near that empty spot was once a very old vase. It was stolen, we have yet to find the culprit");
                         PersianSoldiers[0].speak("Once the culprit has been found, he will be put in jail and shamed in public");
                     }
                     
                     else if(ansSoldier == 3){
                         PersianSoldiers[0].speak("Well, You must take a ship to travel to another Nation, I can take you to Arabia.\n");
                         travelQuestion = inputString("Would you like to go to Arabia? Type Y or N" );
                         if(travelQuestion.equalsIgnoreCase("Y")){
                             Ahmed.travelNation(Arabia);
                             break;
                         }
                         else{
                             PersianSoldiers[0].speak("GoodLuck on Your Journey then!");
                             break;
                            }
                     }
                     else if(ansSoldier == 4){ //a trader then appears instead
                         PersianSoldiers[0].speak("You seem awfully suspicious, I will be keeping an eye on you\n");
                         
                         
                         System.out.println("A merchant carrying goods on a trolley catches your eye....");
                         ansTrader = inputString("Would you like to approach him and trade? Y or N");
                         
                         if(ansTrader.equalsIgnoreCase("Y")){
                             
                            PersianMerchants[1].speak("Hello, I see you have met my brother a while ago, I wonder what goods you may have for me?");
                            int ansTraderN = inputInt("\n1.I dont have anything for you.\n2.Yes Lets trade.\n3.Can you take me to Arabia?");
                            
                            if(ansTraderN == 1){
                                PersianMerchants[1].speak("Well Ok then, I was hoping to get something out of you, GoodLuck on Your journey, I hope to you soon!");
                                break;
                            }
                            else if(ansTraderN == 2){
                               PersianMerchants[1].printInventory();
                               String whichItem = inputString("Which item do you want to trade for in the Merchants Inventory");
                               
                               for(int i = 0; i < PersianMerchants[1].getInvLength(); i++){
                                 if(whichItem.equalsIgnoreCase(PersianMerchants[1].getInv()[i].getItemName()))
                                 Ahmed.printInventory();
                                 String yourItem = inputString("Which item will you give up for this item?\n");
                                 Ahmed.printInventory();
                                 Ahmed.trade(Ahmed,PersianMerchants[1],PersianMerchants[1].getInv()[i],Ahmed.getInv()[i]);
                                 break;
                                }
                            }
                            else if(ansTraderN == 3){
                                PersianMerchants[1].speak("Of course !\n");
                                Ahmed.travelNation(Arabia);
                                
                            }
                            
                         }
                         
                     }
                
               
            }
               
        } 
                             
                     break;
                         }
                         else{
                             AthenianSoldiers[0].speak("GoodLuck on Your Journey then!");
                             break;
                            }
                     }
                     else if(ansSoldier == 4){
                         AthenianSoldiers[0].speak("You seem awfully suspicious, I will be keeping an eye on you");
                         break;
                     }
                    }
                   
                }
                
                
                else if(Ahmed.getCurrentNation().getNationName().equals("Persia")){ //athenian Soldier encounter
                   
                   PersianMerchants[0].speak("I hope to see you again Adventurer");
                   System.out.println("");
                   System.out.println("You walk for a few minutes and you see a man wearing Iron Armour.\n");
                   System.out.println("He notices you.....\n");
                   
                   PersianSoldiers[0].getCharacterInfo();
                   
                   while(PersianSoldiers[0].getAlive() == true){ //as long as he is alive you can ask multiple things
                 
                   int ansSoldier = inputInt("\nGreetings, How may I help?\n" +
                     "\n1.I will fight you right here, right now\n 2.What is this place?\n 3.How do I leave " + Ahmed.getCurrentNation().getNationName() + "\n 4.Nothing, GoodBye");
                   
                   //checks which choice the user had chosen
                     if(ansSoldier == 1){
                        System.out.println("You attack the soldier, His armour is tough!\n");
                        PersianSoldiers[0].fight(Ahmed);
                        System.out.println("");
                        Ahmed.fight(PersianSoldiers[0]);
                        
                       Ahmed.getInv()[0].useItem(Ahmed);
                        
                        Ahmed.levelUp(1);
                        
                        if(Ahmed.getHP() <=0){
                            System.out.println("You were killed, Game Over!");
                            game_over = true;
                            break;
                        }
                      
                     }
                     
                     else if(ansSoldier == 2){
                         PersianSoldiers[0].speak("\nThis place is an ancient location full of historical artifacts.");
                         PersianSoldiers[0].speak("Many Travellers come here especially in the summer\n");
                         PersianSoldiers[0].speak("However near that empty spot was once a very old vase. It was stolen, we have yet to find the culprit");
                         PersianSoldiers[0].speak("Once the culprit has been found, he will be put in jail and shamed in public");
                     }
                     
                     else if(ansSoldier == 3){
                         PersianSoldiers[0].speak("Well, You must take a ship to travel to another Nation, I can take you to Arabia.\n");
                         String travelQuestion = inputString("Would you like to go to Arabia? Type Y or N" );
                         if(travelQuestion.equalsIgnoreCase("Y")){
                             Ahmed.travelNation(Arabia);
                             break;
                         }
                         else{
                             PersianSoldiers[0].speak("GoodLuck on Your Journey then!");
                             break;
                            }
                     }
                     else if(ansSoldier == 4){ //a trader then appears instead
                         PersianSoldiers[0].speak("You seem awfully suspicious, I will be keeping an eye on you\n");
                         
                         
                         System.out.println("A merchant carrying goods on a trolley catches your eye....");
                         ansTrader = inputString("Would you like to approach him and trade? Y or N");
                         
                         if(ansTrader.equalsIgnoreCase("Y")){
                             
                            PersianMerchants[1].speak("Hello, I see you have met my brother a while ago, I wonder what goods you may have for me?");
                            int ansTraderN = inputInt("\n1.I dont have anything for you.\n2.Yes Lets trade.\n3.Can you take me to Arabia?");
                            
                            if(ansTraderN == 1){
                                PersianMerchants[1].speak("Well Ok then, I was hoping to get something out of you, GoodLuck on Your journey, I hope to you soon!");
                                break;
                            }
                            else if(ansTraderN == 2){
                               PersianMerchants[1].printInventory();
                               String whichItem = inputString("Which item do you want to trade for in the Merchants Inventory");
                               
                               for(int i = 0; i < PersianMerchants[1].getInvLength(); i++){
                                 if(whichItem.equalsIgnoreCase(PersianMerchants[1].getInv()[i].getItemName()))
                                 Ahmed.printInventory();
                                 String yourItem = inputString("Which item will you give up for this item?\n");
                                 Ahmed.printInventory();
                                 Ahmed.trade(Ahmed,PersianMerchants[1],PersianMerchants[1].getInv()[i],Ahmed.getInv()[i]);
                                 break;
                                }
                            }
                            else if(ansTraderN == 3){
                                PersianMerchants[1].speak("Of course !\n");
                                Ahmed.travelNation(Arabia);
                 
                                
                                if(Ahmed.getCurrentNation().getNationName().equals("Arabia")){ //athenian Soldier encounter
                   
                   ArabianMerchants[0].speak("I hope to see you again Adventurer");
                   System.out.println("");
                   System.out.println("You walk for a few minutes and you see a man wearing Iron Armour.\n");
                   System.out.println("He notices you.....\n");
                   
                   ArabianSoldiers[0].getCharacterInfo();
                   
                   while(ArabianSoldiers[0].getAlive() == true){ //as long as he is alive you can ask multiple things
                 
                   ansSoldier = inputInt("\nGreetings, How may I help?\n" +
                     "\n1.I will fight you right here, right now\n 2.What is this place?\n 3.How do I leave " + Ahmed.getCurrentNation().getNationName() + "\n 4.Nothing, GoodBye");
                   
                   //checks which choice the user had chosen
                     if(ansSoldier == 1){
                        System.out.println("You attack the soldier, His armour is tough!\n");
                        ArabianSoldiers[0].fight(Ahmed);
                        System.out.println("");
                        Ahmed.fight(ArabianSoldiers[0]);
                        if(Ahmed.getInv()[0] instanceof Weapon){
                            Ahmed.getInv()[0].useItem(Ahmed);
                        }
                        else if(Ahmed.getInv()[0] instanceof Potion){
                            Ahmed.getInv()[0].useItem(Ahmed);
                        }
                        Ahmed.levelUp(1);
                        
                        if(Ahmed.getHP() <=0){
                            System.out.println("You were killed, Game Over!");
                            game_over = true;
                            break;
                        }
                      
                     }
                     
                     else if(ansSoldier == 2){
                         ArabianSoldiers[0].speak("\nThis Desert was once a vast green lush forest");
                         ArabianSoldiers[0].speak("Many Travellers used to come here \n");
                         ArabianSoldiers[0].speak("However after many years this place started to dry up as you can see, and now its full of wild animals that you dont want to mess with");
                         ArabianSoldiers[0].speak("For now we have locked up the area in order to keep the public safe, Your not allowed to go through!");
                     }
                     
                     else if(ansSoldier == 3){
                         ArabianSoldiers[0].speak("Well, You must take a ship to travel to another Nation, I can take you to Rome.\n");
                         String travelQuestion = inputString("Would you like to go to Rome? Type Y or N" );
                         if(travelQuestion.equalsIgnoreCase("Y")){
                             Ahmed.travelNation(Rome);
                             break;
                         }
                         else{
                             ArabianSoldiers[0].speak("GoodLuck on Your Journey then!");
                             break;
                            }
                     }
                     else if(ansSoldier == 4){ //a trader then appears instead
                         ArabianSoldiers[0].speak("You seem awfully suspicious, I will be keeping an eye on you\n");
                         
                         System.out.println("A merchant carrying goods on a trolley catches your eye....");
                         ansTrader = inputString("Would you like to approach him and trade? Y or N");
                         
                         if(ansTrader.equalsIgnoreCase("Y")){
                             
                            ArabianMerchants[1].speak("Hello, I see you have met my brother a while ago, I wonder what goods you may have for me?");
                            ansTraderN = inputInt("\n1.I dont have anything for you.\n2.Yes Lets trade.\n3.Can you take me to Rome?");
                            
                            if(ansTraderN == 1){
                                ArabianMerchants[1].speak("Well Ok then, I was hoping to get something out of you, GoodLuck on Your journey, I hope to you soon!");
                                break;
                            }
                            else if(ansTraderN == 2){
                               ArabianMerchants[1].printInventory();
                               String whichItem = inputString("Which item do you want to trade for in the Merchants Inventory");
                               
                               for(int i = 0; i < ArabianMerchants[1].getInvLength(); i++){
                                 if(whichItem.equalsIgnoreCase(ArabianMerchants[1].getInv()[i].getItemName()))
                                 Ahmed.printInventory();
                                 String yourItem = inputString("Which item will you give up for this item?\n");
                                 Ahmed.printInventory();
                                 Ahmed.trade(Ahmed,ArabianMerchants[1],ArabianMerchants[1].getInv()[i],Ahmed.getInv()[i]);
                                 break;
                                }
                            }
                            else if(ansTraderN == 3){
                                ArabianMerchants[1].speak("Of course !\n");
                                Ahmed.travelNation(Rome);
                            }
                            
                         }
                         
                         
                         
                         
                     }
                
               
            }
               
        }
                                
                            }
                            
                         }
                         
                         
                         
                         
                     }
                
               
            }
               
        }   
        
        
        
        else if(Ahmed.getCurrentNation().getNationName().equals("Arabia")){ //athenian Soldier encounter
                   
                   ArabianMerchants[0].speak("I hope to see you again Adventurer");
                   System.out.println("");
                   System.out.println("You walk for a few minutes and you see a man wearing Iron Armour.\n");
                   System.out.println("He notices you.....\n");
                   
                   PersianSoldiers[0].getCharacterInfo();
                   
                   while(ArabianSoldiers[0].getAlive() == true){ //as long as he is alive you can ask multiple things
                 
                   int ansSoldier = inputInt("\nGreetings, How may I help?\n" +
                     "\n1.I will fight you right here, right now\n 2.What is this place?\n 3.How do I leave " + Ahmed.getCurrentNation().getNationName() + "\n 4.Nothing, GoodBye");
                   
                   //checks which choice the user had chosen
                     if(ansSoldier == 1){
                        System.out.println("You attack the soldier, His armour is tough!\n");
                        ArabianSoldiers[0].fight(Ahmed);
                        System.out.println("");
                        Ahmed.fight(ArabianSoldiers[0]);
                        if(Ahmed.getInv()[0] instanceof Weapon){
                            Ahmed.getInv()[0].useItem(Ahmed);
                        }
                        else if(Ahmed.getInv()[0] instanceof Potion){
                            Ahmed.getInv()[0].useItem(Ahmed);
                        }
                        Ahmed.levelUp(1);
                        
                        if(Ahmed.getHP() <=0){
                            System.out.println("You were killed, Game Over!");
                            game_over = true;
                            break;
                        }
                      
                     }
                     
                     else if(ansSoldier == 2){
                         ArabianSoldiers[0].speak("\nThis Desert was once a vast green lush forest");
                         ArabianSoldiers[0].speak("Many Travellers used to come here \n");
                         ArabianSoldiers[0].speak("However after many years this place started to dry up as you can see, and now its full of wild animals that you dont want to mess with");
                         ArabianSoldiers[0].speak("For now we have locked up the area in order to keep the public safe, Your not allowed to go through!");
                     }
                     
                     else if(ansSoldier == 3){
                         ArabianSoldiers[0].speak("Well, You must take a ship to travel to another Nation, I can take you to Rome.\n");
                         String travelQuestion = inputString("Would you like to go to Rome? Type Y or N" );
                         if(travelQuestion.equalsIgnoreCase("Y")){
                             Ahmed.travelNation(Rome);
                             break;
                         }
                         else{
                             ArabianSoldiers[0].speak("GoodLuck on Your Journey then!");
                             break;
                            }
                     }
                     else if(ansSoldier == 4){ //a trader then appears instead
                         ArabianSoldiers[0].speak("You seem awfully suspicious, I will be keeping an eye on you\n");
                         
                         System.out.println("A merchant carrying goods on a trolley catches your eye....");
                         ansTrader = inputString("Would you like to approach him and trade? Y or N");
                         
                         if(ansTrader.equalsIgnoreCase("Y")){
                             
                            ArabianMerchants[1].speak("Hello, I see you have met my brother a while ago, I wonder what goods you may have for me?");
                            int ansTraderN = inputInt("\n1.I dont have anything for you.\n2.Yes Lets trade.\n3.Can you take me to Rome?");
                            
                            if(ansTraderN == 1){
                                ArabianMerchants[1].speak("Well Ok then, I was hoping to get something out of you, GoodLuck on Your journey, I hope to you soon!");
                                break;
                            }
                            else if(ansTraderN == 2){
                               ArabianMerchants[1].printInventory();
                               String whichItem = inputString("Which item do you want to trade for in the Merchants Inventory");
                               
                               for(int i = 0; i < ArabianMerchants[1].getInvLength(); i++){
                                 if(whichItem.equalsIgnoreCase(ArabianMerchants[1].getInv()[i].getItemName()))
                                 Ahmed.printInventory();
                                 String yourItem = inputString("Which item will you give up for this item?\n");
                                 Ahmed.printInventory();
                                 Ahmed.trade(Ahmed,ArabianMerchants[1],ArabianMerchants[1].getInv()[i],Ahmed.getInv()[i]);
                                 break;
                                }
                            }
                            else if(ansTraderN == 3){
                                ArabianMerchants[1].speak("Of course !\n");
                                Ahmed.travelNation(Rome);
                                
                                if(Ahmed.getCurrentNation().getNationName().equals("Rome")){ //athenian Soldier encounter
                   
                   RomanMerchants[0].speak("I hope to see you again Adventurer");
                   System.out.println("");
                   System.out.println("You walk for a few minutes and you see a man wearing Iron Armour.\n");
                   System.out.println("He notices you.....\n");
                   
                   RomanSoldiers[0].getCharacterInfo();
                   
                   while(RomanSoldiers[0].getAlive() == true){ //as long as he is alive you can ask multiple things
                 
                   ansSoldier = inputInt("\nGreetings, How may I help?\n" +
                     "\n1.I will fight you right here, right now\n 2.What is this place?\n 3.How do I leave " + Ahmed.getCurrentNation().getNationName() + "\n 4.Nothing, GoodBye");
                   
                   //checks which choice the user had chosen
                     if(ansSoldier == 1){
                        System.out.println("You attack the soldier, His armour is tough!\n");
                        RomanSoldiers[0].fight(Ahmed);
                        System.out.println("");
                        Ahmed.fight(RomanSoldiers[0]);
                        if(Ahmed.getInv()[0] instanceof Weapon){
                            Ahmed.getInv()[0].useItem(Ahmed);
                        }
                        else if(Ahmed.getInv()[0] instanceof Potion){
                            Ahmed.getInv()[0].useItem(Ahmed);
                        }
                        Ahmed.levelUp(1);
                        
                        if(Ahmed.getHP() <=0){
                            System.out.println("You were killed, Game Over!");
                            game_over = true;
                            break;
                        }
                      
                     }
                     
                     else if(ansSoldier == 2){
                         RomanSoldiers[0].speak("\nThis is the city Centre of the great Rome");
                         RomanSoldiers[0].speak("It is land for the rich and powerful \n");
                         RomanSoldiers[0].speak("Rules here are very strict, Make sure you dont commit any crimes\n");
                         RomanSoldiers[0].speak("Im warning you!");
                     }
                     
                     else if(ansSoldier == 3){
                         RomanSoldiers[0].speak("Well, You must take a ship to travel to another Nation, I can take you to Athens.\n");
                         String travelQuestion = inputString("Would you like to go to Athens? Type Y or N" );
                         if(travelQuestion.equalsIgnoreCase("Y")){
                             Ahmed.travelNation(Athens);
                             break;
                         }
                         else{
                             RomanSoldiers[0].speak("GoodLuck on Your Journey then!");
                             break;
                            }
                     }
                     else if(ansSoldier == 4){ //a trader then appears instead
                         RomanSoldiers[0].speak("You seem awfully suspicious, I will be keeping an eye on you\n");
                         
                         System.out.println("A merchant carrying goods on a trolley catches your eye....");
                         ansTrader = inputString("Would you like to approach him and trade? Y or N");
                         
                         if(ansTrader.equalsIgnoreCase("Y")){
                             
                            RomanMerchants[1].speak("Hello, I see you have met my brother a while ago, I wonder what goods you may have for me?");
                            ansTraderN = inputInt("\n1.I dont have anything for you.\n2.Yes Lets trade.\n3.Can you take me to Athens?");
                            
                            if(ansTraderN == 1){
                                RomanMerchants[1].speak("Well Ok then, I was hoping to get something out of you, GoodLuck on Your journey, I hope to you soon!");
                                break;
                            }
                            else if(ansTraderN == 2){
                               RomanMerchants[1].printInventory();
                               String whichItem = inputString("Which item do you want to trade for in the Merchants Inventory");
                               
                               for(int i = 0; i < RomanMerchants[1].getInvLength(); i++){
                                 if(whichItem.equalsIgnoreCase(RomanMerchants[1].getInv()[i].getItemName()))
                                 Ahmed.printInventory();
                                 String yourItem = inputString("Which item will you give up for this item?\n");
                                 Ahmed.printInventory();
                                 Ahmed.trade(Ahmed,RomanMerchants[1],RomanMerchants[1].getInv()[i],Ahmed.getInv()[i]);
                                 break;
                                }
                            }
                            else if(ansTraderN == 3){
                                RomanMerchants[1].speak("Of course !\n");
                                Ahmed.travelNation(Athens);
                                
                            }
                            
                         }
                         
                         
                         
                         
                     }
                
               
            }
               
        } 
                            }
                            
                         }
                         
                         
                         
                         
                     }
                
               
            }
               
        }
        
        else if(Ahmed.getCurrentNation().getNationName().equals("Rome")){ //athenian Soldier encounter
                   
                   RomanMerchants[0].speak("I hope to see you again Adventurer");
                   System.out.println("");
                   System.out.println("You walk for a few minutes and you see a man wearing Iron Armour.\n");
                   System.out.println("He notices you.....\n");
                   
                   RomanSoldiers[0].getCharacterInfo();
                   
                   while(RomanSoldiers[0].getAlive() == true){ //as long as he is alive you can ask multiple things
                 
                   int ansSoldier = inputInt("\nGreetings, How may I help?\n" +
                     "\n1.I will fight you right here, right now\n 2.What is this place?\n 3.How do I leave " + Ahmed.getCurrentNation().getNationName() + "\n 4.Nothing, GoodBye");
                   
                   //checks which choice the user had chosen
                     if(ansSoldier == 1){
                        System.out.println("You attack the soldier, His armour is tough!\n");
                        RomanSoldiers[0].fight(Ahmed);
                        System.out.println("");
                        Ahmed.fight(RomanSoldiers[0]);
                        if(Ahmed.getInv()[0] instanceof Weapon){
                            Ahmed.getInv()[0].useItem(Ahmed);
                        }
                        else if(Ahmed.getInv()[0] instanceof Potion){
                            Ahmed.getInv()[0].useItem(Ahmed);
                        }
                        Ahmed.levelUp(1);
                        
                        if(Ahmed.getHP() <=0){
                            System.out.println("You were killed, Game Over!");
                            game_over = true;
                            break;
                        }
                      
                     }
                     
                     else if(ansSoldier == 2){
                         RomanSoldiers[0].speak("\nThis is the city Centre of the great Rome");
                         RomanSoldiers[0].speak("It is land for the rich and powerful \n");
                         RomanSoldiers[0].speak("Rules here are very strict, Make sure you dont commit any crimes\n");
                         RomanSoldiers[0].speak("Im warning you!");
                     }
                     
                     else if(ansSoldier == 3){
                         RomanSoldiers[0].speak("Well, You must take a ship to travel to another Nation, I can take you to Athens.\n");
                         String travelQuestion = inputString("Would you like to go to Athens? Type Y or N" );
                         if(travelQuestion.equalsIgnoreCase("Y")){
                             Ahmed.travelNation(Athens);
                             break;
                         }
                         else{
                             RomanSoldiers[0].speak("GoodLuck on Your Journey then!");
                             break;
                            }
                     }
                     else if(ansSoldier == 4){ //a trader then appears instead
                         RomanSoldiers[0].speak("You seem awfully suspicious, I will be keeping an eye on you\n");
                         
                         System.out.println("A merchant carrying goods on a trolley catches your eye....");
                         ansTrader = inputString("Would you like to approach him and trade? Y or N");
                         
                         if(ansTrader.equalsIgnoreCase("Y")){
                             
                            RomanMerchants[1].speak("Hello, I see you have met my brother a while ago, I wonder what goods you may have for me?");
                            int ansTraderN = inputInt("\n1.I dont have anything for you.\n2.Yes Lets trade.\n3.Can you take me to Athens?");
                            
                            if(ansTraderN == 1){
                                RomanMerchants[1].speak("Well Ok then, I was hoping to get something out of you, GoodLuck on Your journey, I hope to you soon!");
                                break;
                            }
                            else if(ansTraderN == 2){
                               RomanMerchants[1].printInventory();
                               String whichItem = inputString("Which item do you want to trade for in the Merchants Inventory");
                               
                               for(int i = 0; i < RomanMerchants[1].getInvLength(); i++){
                                 if(whichItem.equalsIgnoreCase(RomanMerchants[1].getInv()[i].getItemName()))
                                 Ahmed.printInventory();
                                 String yourItem = inputString("Which item will you give up for this item?\n");
                                 Ahmed.printInventory();
                                 Ahmed.trade(Ahmed,RomanMerchants[1],RomanMerchants[1].getInv()[i],Ahmed.getInv()[i]);
                                 break;
                                }
                            }
                            else if(ansTraderN == 3){
                                RomanMerchants[1].speak("Of course !\n");
                                Ahmed.travelNation(Athens);
                                
                            }
                            
                         }
                         
                         
                         
                         
                     }
                
               
            }
               
        } 
          
            game_over = true;
        }
        
        
        
        
        
        
        
        
        
        
        
}
    










}
}
