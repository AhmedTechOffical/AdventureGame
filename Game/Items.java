
public class Items {
    
    private String rarity; //Legendary,UltraRare etc
    private boolean upgradable;
    private String itemName;
   
    public Items(String itemName,String rarity,boolean upgradebale){
        this.itemName = itemName;
        this.rarity = rarity;
        this.upgradable = upgradable;
   }
    
    public String getRarity(){
        return rarity;
   }
    public boolean getUpgradeable(){
        return upgradable;
   }
    public String getItemName(){
        return itemName;
   }


   public void informationAboutItem(Items item){
        System.out.println(itemName);
        System.out.println("This item is " + rarity);
    }
    
    public void useItem(Player p){
        
        if(this.rarity.equals("Legendary")){
            System.out.println("\nYou use a legendary Item, The item glows, Everyone around you is looking in shock!");
            
        }
        else if(this.rarity.equals("Common")){
            System.out.println("Its only a common item");
        }
    }
    
    
}
