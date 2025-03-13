public class Passenger{
    //fields
    private int dest;
    private int ID;
    private static int idgen;

    //constructors
    public Passenger(int mydest){
        dest = mydest; 
        ID = idgen; //assigning id to passenger
        idgen++; //keep going up
    }

    //methods
    public int getDes(){
        return dest; //return the destination station of the pasenger
    }

    public int getID(){
        return ID; //return the id of the passenger
    }

    public String toString(){
        return "Passenger " + ID + " | Destination: " + dest;
    } //return a string of the passenger and their info
    //AGAIN THANK YOU EVAN CHEN FOR THE FORMATTING
}
