
public class Fighter extends NPC{

    private int powerLevel;
    private boolean alive;
    
    public Fighter(int powerLevel){
        super(10,true); //This is the level of a fighter
        this.powerLevel = powerLevel;
        alive = true;
 }
    
    public int getPowerLevel(){
        return powerLevel;
 }
    
    public boolean getAlive(){
        return alive;
   }
    
    public void setAlive(boolean alive){
        this.alive = alive;
   }
    
    
    public void fight(Player p){ //These are aggressive fighters/soldiers
       
        if(alive == false){
            System.out.println("The fighter is already dead <- you should not see this");
        }
        else{
            p.ReduceHP(10 + powerLevel);
            System.out.println("You are now at " + p.getHP() + " HP");
        }
   }
   
   public void getCharacterInfo(){
       System.out.println("Current Level: " + getXP());
       System.out.println("Current PowerLevel: " + getPowerLevel() + "\n");
    }
}
