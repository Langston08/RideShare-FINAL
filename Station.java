import java.util.*;
public class Station {
    //fields
    private ArrayList<Passenger> pass; //stores passengers at the station
    private int ID; 
    private static int idgen; //makes ids for each station

    //constructors
    public Station(){
        pass = new ArrayList<Passenger>(); 
        ID = idgen; //assigns idgen to stations id
        idgen++;  //increments the idgen for the next station
    }

    //methods
    public void delete(Passenger p){
        pass.remove(p); //removes passenger from list
    }

    public void add(Passenger p){
        pass.add(p); //adds passenger to list
    }

    public ArrayList<Passenger> getPass(){
        return pass; //returns list of passengers at the station
    }

    public String listPass(){
        String finished = "Passengers that are waiting at Station " + ID + ":";
        for(int i = 0; i < pass.size(); i++){ //loops through all passengers
            finished += "\n" + pass.get(i).toString();
        }
        return finished; //returns list of passengers
    }
}






