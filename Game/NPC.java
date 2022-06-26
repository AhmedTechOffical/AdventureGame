
public class NPC extends Character{

    private int Level; //This is different to XP level
    private boolean fightable;
    
   public NPC(int Level,boolean fightable){
       super("NPC",1);
       this.Level = Level;
       this.fightable = fightable;
    }
    
    public int getLevel(){
        return Level;
    }
    
    public boolean getFightable(){
        return fightable;
    }
    
    
}
