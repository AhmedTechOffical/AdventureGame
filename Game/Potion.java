

public class Potion extends Items{
    
    private String typeOfPotion;
    private int effectivness;
    
    public Potion(String potionName,String rarity,String typeOfPotion,int effectivness){
        super(potionName,rarity,false);
        this.typeOfPotion = typeOfPotion;
        this.effectivness = effectivness;
    }
    
    public String getTypeOfPotion(){
        return typeOfPotion;
    }
    public int getEffectivness(){
        return effectivness;
    }
    
    public void useItem(Player p){ //this is what happens when you use a potion
        if(getItemName().equalsIgnoreCase("Healing Potion")){ //chceks what type of potion it is
            if(getRarity().equals("Legendary")){
                p.increaseHP(20);
            }
            else if(getRarity().equals("Rare")){
                p.increaseHP(10);
                System.out.println("You have increased your HP by 10!");
            }
            else{
                p.increaseHP(5);
                System.out.println("You have increased your HP by 5!");
            }
        }
        
        if(getItemName().equals("Poison")){
            if(getRarity().equals("Rare")){
                p.ReduceHP(2);
                System.out.println("You have reduced your HP by 2");
            }
            else{
                p.ReduceHP(1);
                System.out.println("You have reduced your HP by 1");
            }
        }
        
        if(getItemName().equals("Strength")){
            p.increaseHP(50);
            System.out.println("Amazing!, You have increased your HP by 50!!!");
            p.levelUp(1);
            
        }
        
        
        
    }

}
