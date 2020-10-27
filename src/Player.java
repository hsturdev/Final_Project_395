package src;
public class Player extends Creature{ 
    private Item sword;
    private Item armor;
    private String DeathAction;
    private String HitAction;
    public void setSword(Item _sword) {
        sword = _sword;
    }
    public void setArmor(Item _armor) {
        armor = _armor;
    }
}