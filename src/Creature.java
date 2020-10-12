package src;
public class Creature{
    private int Hp;
    private int HpMoves;
    private CreatureAction DeathAction;
    private String HitAction;
    private Player[ ] players;
    private Monster[ ] monsters;

    /*public Creature(String _name, int _numPlayers, int _numMonsters) {
        name = _name;
        numActivities = _numActivities;
        activities = new Activity[numActivities];
    }*/

    public void setHp(int _Hp) {
        Hp = _Hp;
    }

    public void setHpMoves(int _HpMoves) {
        HpMoves = _HpMoves;
    }

    public void setDeathAction(CreatureAction _DeathAction) {
        DeathAction = _DeathAction;
    }

    public void setHitAction(CreatureAction _HitAction) {
        HitAction = _HitAction;
    }
}