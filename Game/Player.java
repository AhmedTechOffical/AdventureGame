import java.util.Arrays;

public class Player extends Character{
    
    private int HP;
    private Items[] inventory;
    private Nation currentNation;
    
    public Player(String name,Nation currentNation){
        
        super(name,10);//this should be a variable number
        HP = 100; //This should go up as XP level goes up
        this.currentNation = currentNation;
        
    }

    public int getHP(){
        return HP;
    }
    public void ReduceHP(int change){
        this.HP -= change;
    }
    
    public void increaseHP(int amount){
        
        if(this.HP < 100){
            this.HP += amount;
        }
        else{
            System.out.println("No point of increasing since your basically at max HP");
        }
        
    }
    
    public Items[] getInv(){
        return inventory;
    }
     
    public void createInventory(int sizeOfInv){ //creates a size of inventory bag of the player
        inventory = new Items[sizeOfInv];
    }
    
    public String printInventory(){ //Displays the inventory
         
        String[] itemArray = new String[inventory.length];
        
        for(int i = 0; i < inventory.length;i++){
            if(inventory[i] != null){
            itemArray[i] = inventory[i].getItemName();
        }
        }
        
        String itemArrayList = Arrays.toString(itemArray);
        System.out.println(itemArrayList);
        return itemArrayList;
    }
    
    public int spaceAvailableInv(Player p){ //checks how much space available inside inventory
        
        int space = 0;
        
        for(int i = 0; i < p.getInv().length; i++){
            if(p.getInv()[i] == null){
                space += 1;
            }
            
        }
        return space;
    } 
    
    public void addItem(Player p,Items item){ //adds an item to Players bag
        
        System.out.println("Current Space remaining in inventory: " + spaceAvailableInv(p));
        for(int i = 0; i<getInv().length; i++){
            if(spaceAvailableInv(p) == 0){ //checks if there is space available
                System.out.println("Your Inventory is full");
            }
            else if(getInv()[i] == null){ //checks for empty space
                getInv()[i] = item;
                System.out.println("You have added " + item.getItemName() + " to slot " + i);
                break;
            }
        }
        
    }
    
    
    public void dropItem(Items item){ //leaves item on the ground
        
        for(int i = 0; i < getInv().length; i++){
            if(getInv()[i].getItemName().equals(item.getItemName())){
                getInv()[i] = null;
                System.out.println("You dropped " + item.getItemName());
                break;
            }
            else{
                System.out.println("This item is not in your bag");
            }
        }
    }
    
    public void removeItem(Items item){ //removes Item of Trader's inventory
        
        for(int i = 0; i < getInv().length; i++){
            if(getInv()[i].getItemName().equals(item.getItemName())){
                getInv()[i] = null;
                break;
            }
           
        }
   }
    
    
    public void fight(Character c){
        
        Fighter f = (Fighter)c;
        
        System.out.println("Your current inventory list is: ");
        printInventory();
       
        for(int i = 0; i < inventory.length; i ++){
        
        if(getInv()[i] == null){ //checks to see if inventory is empty
            System.out.println("You Punch him, inflincting little damage!\n He notices this and inflics heavy damage on you");
            this.HP = this.HP - 10;
            System.out.println("\nYou are now at " + getHP());
            break;
        }
        
        else if(getInv()[i] instanceof Weapon){
            System.out.println("You Picked out the mighty " + getInv()[i].getItemName());
            System.out.println("You Attack your oppenent and Killed it!");
            
            f.setAlive(false);
            break;
        }
        
        
    }
        
    }
    
    public void trade(Player p,Trader t,Items item,Items item2){ //this allows player to trade weapons with the trader
        
        
        for(int i = 0; i < t.getInv().length; i++){
            
            if(item.getItemName().equals(t.getInv()[i].getItemName())){ //checks to see if weapon wanting to trade in the trader's bag
                System.out.println("Great, the trader has " + item.getItemName() + " in their inventory."); 
                addItem(p,item);
               // t.removeItem(item);
                //p.removeItem(item2);
                t.addItem(item2);
                break;
                
            }
            
        }
        
    }
    
    
    
    public void setNation(Nation newNation){
        this.currentNation = newNation;
    }
    
    public Nation getCurrentNation(){
        return currentNation;
        
    }
    
    public void travelNation(Nation n){ //This is used to travel to different nations on Ship
        setNation(n);
        System.out.println("You have travelled to a nation called " + n.getNationName());
        n.printNationDetails();
        
    }
    
    public void levelUp(int changeInLevel){
        super.levelUp(1);
        System.out.println("Congragulations, You leveled up, You are now Level " + getXP());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
}
