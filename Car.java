import java.util.*;
public class Car {

    //fields
    
    private boolean directionUp;
    private int ID;
    private int location;
    private static int idgen;
    private ArrayList<Passenger> pass;
    private int dest;

    //constructors
    public Car(){
        pass = new ArrayList<Passenger>();
        int randomDestination = (int) (Math.random()*32); //random destination (0-31)
        dest = randomDestination; 
        int randomStart = (int) (Math.random()*32); //setting the starting point (0-31)
        location = randomStart;
        if(dest > location){ //determining direction based on its starting location and destination
            directionUp = true;
        } else {
            directionUp = false;
        }
        ID = idgen; //assigning it a unique id
        idgen++; //incrimenting for the next car
    }

    //methods
    public void move(){
        if(dest != location){ //only moving if ur not at ur destinatoin
            if(directionUp){
                location++; //move up if direction is up
            } else {
                location--; //down
            }
        }
    }

    public int needDropoff(){
        for(int i = 0; i < pass.size(); i++){ //check if a passanger needs to be dropped off
            if (pass.get(i).getDes() == dest){
                return i; //return the passenger who needs to be dropped off
            }
        }
        return -1; //no passenger needs to be dropped off
    }

    public Passenger dropoff(int pos){
        if(pos != -1){
            Passenger temp = pass.get(pos); //get the passenger
            pass.remove(pos); //remove the passenger from list
            return temp; //return the dropped-off passenger
        }
        return null; //no passenger to drop off
    }

    public void remove(int p){
        pass.remove(p); //remove passenger at specified position
    }

    public void pickup(Passenger p){ //add a new passenger to the care if theres space
        if(pass.size() <= 3){ //MAX 3!!!!
            pass.add(p);
        }
    }

    public int getDes(){
        return dest; //return destinatoin
    }

    public int getLoc(){
        return location; //return current location
    }

    public boolean getDir(){
        return directionUp; //return direction the car is moving in
    }

    public ArrayList<Passenger> getPass(){
        return pass; //return list of passengers
    }

    public String listPass(){

        String directiontext = "";

        if(directionUp == false){

            directiontext = "Down";

        } else {

            directiontext = "Up";
        }
        //string with the cars info
        String finished = "Car " + ID + " at Station " + location + " | to Station " + dest + " | Direction: " +  directiontext + " | " + "Passengers in Car " + ID + ":";  //THANK YOU EVAN CHECK!!!! evan check helped me do this format for my code it was very hard to organize 

        for(int i = 0; i < pass.size(); i++){
            finished += "\n" + pass.get(i).toString();
        }
        return finished; //return completed string
    }
}

//DONE