
public class Character {
       
    private int XP_Level;
    private String name;
    private Nation currentNation;
    
    public Character(String name,int XP_Level){
        this.name = name;
        this.XP_Level = XP_Level;
    }
    
    public int getXP(){
        return XP_Level;
    }
    public String getName(){
    
        return name;
    }
   
    public void fight(Character c){
        
       System.out.println("This is currenly a fight between a character and another character");
       XP_Level +=1;
        
    }
    
    public void setNation(Nation newNation){
        this.currentNation = newNation;
    }
    
    public Nation getCurrentNation(){
        return currentNation;
        
    }
    
    public void levelUp(int changeInLevel){ //increases level of a character <- this must be overriden
        this.XP_Level += changeInLevel;
        
    }
    public void speak(String message){
        System.out.println(message);
    }
    
    public void getCharacterInfo(){
        System.out.println("Current Level: " + XP_Level);
        System.out.println("Current Nation: " + currentNation.getNationName());
        
    }
    
}
