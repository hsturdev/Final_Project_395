public class Action{
    private char c;
    private String msg;
    private int v;
    private CreatureAction[ ] creatureactions;
    private ItemAction[ ] itemactions;

    /*public Creature(String _name, int _numPlayers, int _numMonsters) {
        name = _name;
        numActivities = _numActivities;
        activities = new Activity[numActivities];
    }*/

    public void setMessage(String _msg) {
        msg = _msg;
    }

    public void setIntValue(int _v) {
        v = _v;
    }

    public void setCharValue(char _c) {
        c = _c;
    }
}