package src;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;

public class DisplayableXMLHandler extends DefaultHandler {
    // the two lines that follow declare a DEBUG flag to control
    // debug print statements and to allow the class to be easily
    // printed out.  These are not necessary for the parser.
    private static final int DEBUG = 1;
    private static final String CLASSID = "DungeonXMLHandler";

    // data can be called anything, but it is the variables that
    // contains information found while parsing the xml file
    private StringBuilder data = null;

    // When the parser parses the file it will add references to
    // Student objects to this array so that it has a list of
    // all specified students.  Had we covered containers at the
    // time I put this file on the web page I would have made this
    // an ArrayList of Students (ArrayList<Student>) and not needed
    // to keep tract of the length and maxStudents.  You should use
    // an ArrayList in your project.
    private ArrayList <Displayble> dis_object;
    // ArrayList<Displayable> dis_object = new ArrayList<Displayable>();

    // The XML file contains a list of Students, and within each
    // Student a list of activities (clubs and classes) that the
    // student participates in.  When the XML file initially
    // defines a student, many of the fields of the object have
    // not been filled in.  Additional lines in the XML file
    // give the values of the fields.  Having access to the
    // current Student and Activity allows setters on those
    // objects to be called to initialize those fields.
    private Displayable ObjectsBeingParsed = null;

    // The bX fields here indicate that at corresponding field is
    // having a value defined in the XML file.  In particular, a
    // line in the xml file might be:
    // <instructor>Brook Parke</instructor>
    // The startElement method (below) is called when <instructor>
    // is seen, and there we would set bInstructor.  The endElement
    // method (below) is called when </instructor> is found, and
    // in that code we check if bInstructor is set.  If it is,
    // we can extract a string representing the instructor name
    // from the data variable above.
    private boolean bRoom = false;
    private boolean bPassage = false;
    private boolean bCreature = false;
    private boolean bItem = false;
    private boolean bPosX = false;
    private boolean bPosY = false;
    private boolean bheight = false;
    private boolean bwidth = false;
    private boolean bmonster = false;
    private boolean bplayer = false;
    Displayable roomBeingParsed;
    Displayable passageBeingParsed;
    Displayable itemBeingParsed;
    Displayable creatureBeingParsed;
    Displayable dis_objectBeingParsed;


    


    // Used by code outside the class to get the list of Student objects
    // that have been constructed.
    public Displayable[] getDis_objects() {
        return dis_object;
    }

    // A constructor for this class.  It makes an implicit call to the
    // DefaultHandler zero arg constructor, which does the real work
    // DefaultHandler is defined in org.xml.sax.helpers.DefaultHandler;
    // imported above, and we don't need to write it.  We get its
    // functionality by deriving from it!
    public DisplayableXMLHandler() {
    }

    // startElement is called when a <some element> is called as part of
    // <some element> ... </some element> start and end tags.
    // Rather than explain everything, look at the xml file in one screen
    // and the code below in another, and see how the different xml elements
    // are handled.
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (DEBUG > 1) {
            System.out.println(CLASSID + ".startElement qName: " + qName);
        }

        if (qName.equalsIgnoreCase("Room"))
        {

            int posX = Integer.parseInt(attributes.getValue("PosX"));
            int posY = Integer.parseInt(attributes.getValue("PosY"));
            int visible = Integer.parseInt(attributes.getValue("Visible"));
            int width = Integer.parseInt(attributes.getValue("Width"));
            int height = Integer.parseInt(attributes.getValue("Height"));
            if(bCreature == true)
            {
                int hp = Integer.parseInt(attributes.getValue("Hp"));
                int HpMoves = Integer.parseInt(attributes.getValue("HpMoves"));
                int DeathAction = Integer.parseInt(attributes.getValue("DeathAction"));
                int HitAction = Integer.parseInt(attributes.getValue("HitAction"));
                int maxhit = Integer.parseInt(attributes.getValue("maxhit"));

            }
            else if(bItem == true)
            {
                posX = Integer.parseInt(attributes.getValue("PosX"));
                posY = Integer.parseInt(attributes.getValue("PosY"));
                visible = Integer.parseInt(attributes.getValue("Visible"));
                ItemAction IA = Integer.parseInt(attributes.getValue("ItemAction"));
            }
            dis_object.add(dis_object);
            roomBeingParsed = dis_object;
        }
        else if (qName.equalsIgnoreCase("Passage"))
        {
            int posX = Integer.parseInt(attributes.getValue("PositionX"));
            int posY = Integer.parseInt(attributes.getValue("PositionY"));
            int visible = Integer.parseInt(attributes.getValue("Visible"));
            int width = Integer.parseInt(attributes.getValue("Width"));
            int height = Integer.parseInt(attributes.getValue("Height"));
            addDisplayable(dis_object);
            passageBeingParsed = dis_object;
        }
        else if (qName.equalsIgnoreCase("Item"))
        {
            String type = attributes.getValue("type");
            int posX = Integer.parseInt(attributes.getValue("PositionX"));
            int posY = Integer.parseInt(attributes.getValue("PositionY"));
            int visible = Integer.parseInt(attributes.getValue("Visible"));
            int width = Integer.parseInt(attributes.getValue("Width"));
            int height = Integer.parseInt(attributes.getValue("Height"));
            Item item = null;
            switch (type) {
                case "armor":
                    item = new Armor();
                    break;
                case "sword":
                    item = new Sword();
                    break;
                case "scroll":
                    item = new Scroll();
                    break;
                default:
                    System.out.println("Unknown activity: " + type);
                    break;

            }
            itemBeingParsed = dis_object;
            dis_objectBeingParsed.additem(dis_object);
        }
        else if (qName.equalsIgnoreCase("Creature"))
        {
            String type = attributes.getValue("type");
            int posX = Integer.parseInt(attributes.getValue("PositionX"));
            int posY = Integer.parseInt(attributes.getValue("PositionY"));
            int visible = Integer.parseInt(attributes.getValue("Visible"));
            int width = Integer.parseInt(attributes.getValue("Width"));
            int height = Integer.parseInt(attributes.getValue("Height"));
            Creature creature = null;
            switch (type)
            {
                case "player":
                    creature = new Player();
                    break;
                case "monster":
                    creature = new Monster();
                    break;
                default:
                    System.out.println("Unknown activity: " + type);
                    break;
            }
            creatureBeingParsed = dis_object;
            dis_objectBeingParsed.additem(dis_object);
        }
        else {
            System.out.println("Unknown qname: " + qName);
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        Displayable display;
        
        if (bRoom) {
            display = (Displayable) roomBeingParsed;
            display.setRoom(data.toString());
            bRoom = false;
        } else if (bPassage) {
            display = (Displayable) passageBeingParsed;
            passageBeingParsed.setName(data.toString());
            bPassage = false;
        } else if (bCreature) {
            display = (Displayable) creatureBeingParsed;
            creatureBeingParsed.setName(data.toString());
            bCreature = false;
        } else if (bItem) {
            display = (Displayable) itemBeingParsed;
            itemBeingParsed.setName(data.toString());
            bItem = false;
        }
    }

    private void addDisplayable(Displayable _dis_object) {
        dis_object.add(_dis_object);
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
        if (DEBUG > 1) {
            System.out.println(CLASSID + ".characters: " + new String(ch, start, length));
            System.out.flush();
        }
    }

    @Override
    public String toString() {
        String str = "DungeonXMLHandler\n";
        for (Displayable dis_object : dis_object) {
            str += dis_object.toString() + "\n";
        }
        str += "   RoomBeingParsed: " + roomBeingParsed.toString() + "\n";
        str += "   PassageBeingParsed: " + passageBeingParsed.toString() + "\n";
        str += "   itemBeingParsed: " + itemBeingParsed.toString() + "\n";
        str += "   creatureBeingParsed: " + creatureBeingParsed.toString() + "\n";
        return str;
    }
}