
public class Weapon extends Items{

    private int durability;
    private int damage;
    
    
    public Weapon(String nameOfWeapon,String rarity,int durability, int damage){
        super(nameOfWeapon,rarity,true);
  
        this.damage = damage;
        this.durability = durability;
    }
    
    public int getDurability(){
        return durability;
    }
    public int getDamage(){
        return damage;
    }
    
    
    public void reduceDurability(int durability){ //changes durability of the weapon
        this.durability -= durability;
    }
    
    public void useItem(Player p){
        
        reduceDurability(1);
        System.out.println("Current Durability is " + getDurability());
        p.levelUp(1);
        
        
        
    }
    
    public void checkIfItemDamaged(){
        if(this.durability == 0){
            System.out.println("This weapon is no longer usable, if you use it, it will give 0 damage !");
            this.damage = 0;
            
        }
    }
    
}
