import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Trader extends NPC{

    private int tradingLevel;
    private Items[] inventory;
    private Nation currentNation;
    
    public Trader(int tradingLevel,Nation currentNation){
    
        super(1,false);
        this.tradingLevel = tradingLevel;
        this.currentNation = currentNation;
        
   }
    
    public int getTradingLevel(){
        return tradingLevel;
   }
    
    
    public Items[] getInv(){
        return this.inventory;
   }
   
   public int getInvLength(){
       return this.inventory.length;
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
    
    public void createInventory(int no_of_items){
        this.inventory= new Items[no_of_items];        
   }
    
    public int spaceAvailableInv(Trader p){ //checks how much space available inside inventory
        
        int space = 0;
        
        for(int i = 0; i < p.getInv().length; i++){
            if(p.getInv()[i] == null){
                space += 1;
            }
            
        }
        return space;
   } 
   
    
    public void addItem(Items item){ //adds an item to Trader's bag
       
        for(int i = 0; i<getInv().length; i++){
            
            if(getInv()[i] == null){ //checks for empty space
                getInv()[i] = item;
                break;
            }
            
        }
        
  }
  
  
    
    public void dropItem(Items item){
        
        for(int i = 0; i < getInv().length; i++){
            if(getInv()[i].equals(item.getItemName())){
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
   public void setNation(Nation newNation){
        this.currentNation = newNation;
    }
    
    public Nation getCurrentNation(){
        return currentNation;    
    }
    
    
}
