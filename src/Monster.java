package src;
public class Monster extends Creature{
    public Monster(){
        System.out.println("Monster");
    }

    public void setName(String string){
        System.out.println("setName");
    }

    public void setID(int room, int serial){
        System.out.println("setID");
    }
}
