public class Passenger{
    /* fields */
    private int dest;
    private int ID;
    private static int idgen;

    /* constructors */
    public Passenger(int mydest){
        dest = mydest;
        ID = idgen;
        idgen++;
    }

    /* methods */
    public int getDes(){
        return dest;
    }

    public int getID(){
        return ID;
    }

    public String toString(){
        return "Passenger " + ID + " | Destination: " + dest;
    }
}
