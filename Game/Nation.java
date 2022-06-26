

public class Nation {
    
    private String nationName;
    private int nationLevel; //this can show you how high fighter levels are on average or the wealth of the nation
    private Fighter[] soldiers;//Can store many number of soldiers/fighters
    private Trader[] merchants;
    
    
    public Nation(String nationName,int nationLevel,Fighter[] soldiers,Trader[] merchants){
        this.nationName = nationName;
        this.nationLevel = nationLevel;
        this.soldiers = soldiers;
        this.merchants = merchants;
    }
    
    public String getNationName(){
        return nationName;
    }
    public int getNationLevel(){
        return nationLevel;
    }
    public Fighter[] getSoldiers(){
        return soldiers;
    }
    public Trader[] getMerchants(){
        return merchants;
    }
 
    
    
    public void increaseNationLevel(Nation n,int level){ //increases nation level by set amount
        int nationLevel = getNationLevel();
        nationLevel= nationLevel + level;
    }
    
    public void createWealth(Nation n){ //this can increase soldiers,merchants
        
    }
    
    public void viewTreasure(Nation n){
        
    }
    
    
    public void printNationDetails(){
        System.out.println("Current Nation: " + getNationName());
        System.out.println("Nation Level: " + getNationLevel());
        
        
        
    }

}
