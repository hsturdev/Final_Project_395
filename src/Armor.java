package src;

public class Armor extends Item
{
    private String name;
    private int room;
    private int serial;

    public Armor(){
        // name = _name;
    }

    public Armor(String _name){
        name = _name;
    }
    public void setName(String _name) {
        name = _name;
    }
    public void setID(int _room, int _serial) {
        room = _room;
        serial = _serial;
    }
}