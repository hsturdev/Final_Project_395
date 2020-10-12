public class Item
{
    private Creature owner;
    private Scroll[ ] scrolls;
    private Sword[ ] swords;
    private Armor[] armors;

    /*public Creature(String _name, int _numPlayers, int _numMonsters) {
        name = _name;
        numActivities = _numActivities;
        activities = new Activity[numActivities];
    }*/

    public void setOwner(Creature _owner) {
        owner = _owner;
    }

    public void setHpMoves(String _HpMoves) {
        HpMoves = _HpMoves;
    }

    public void setDeathAction(String _DeathAction) {
        DeathAction = _DeathAction;
    }

    public void setHitAction(String _HitAction) {
        HitAction = _HitAction;
    }
}