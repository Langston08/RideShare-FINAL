import java.util.ArrayList;

public class Road {
    //fields

    private ArrayList<Car> cars; //list of cars on the road
    private ArrayList<Station> stations; //list of stations
    private int carAmt; //number of cars on the road



    //constructors

    public Road(int myCarAmt, int passAmt){

        carAmt = myCarAmt; //set the number of cars

        stations = new ArrayList<Station>(); //initalize the list of stations

        for(int i = 0; i <= 31; i++){

            stations.add(new Station());
        }

        cars = new ArrayList<Car>(); //initalize list of cars
        for(int i = 0; i < carAmt; i++){
            cars.add(new Car());
        }

        for(int i = 0; i < passAmt; i++){
            Passenger p = new Passenger((int) (Math.random()*32));
            //random starting point
            int randS = (int) (Math.random()*32);
            //makes sure passenger destination isnt going to be the same as the starting station
            while(p.getDes()==randS){
                randS = (int) (Math.random()*32);
            }
            //add the passenger to the randomly chosen station
            stations.get(randS).add(p);
            
        }
//put passengers in the cars
        putPassengersInCars();
    }


    //methods

//puts passengers from stations into the cars
    public void putPassengersInCars(){

        for(int s = 0; s < stations.size(); s++){

            ArrayList<Passenger> pass = stations.get(s).getPass();
            //separating passengers into 2 directions
            ArrayList<Passenger> passUp = new ArrayList<Passenger>();
            ArrayList<Passenger> passDown = new ArrayList<Passenger>();
            //distribute passengers btwn those going up and going down
            for(int i = 0; i < pass.size(); i++){
                if(pass.get(i).getDes() > s){
                    passUp.add(pass.get(i)); //going up
                } else {
                    passDown.add(pass.get(i)); //going down
                }
            }
            //checking if car is at the station and if its going up
            for(int c = 0; c < cars.size(); c++){
                if((cars.get(c).getLoc() == s) && cars.get(c).getDir()==true){
                    ArrayList<Passenger> carPass = cars.get(c).getPass();
                    for(int i = 0; i < passUp.size(); i++){
                        
                        if(carPass.size() < 4){
                            cars.get(c).pickup(passUp.get(0));
                            stations.get(s).delete(passUp.get(0));
                            passUp.remove(i);
                            i--;
                        }
                            
                        
                    }
                    //just does the same thing but handles cars going down
                } else if((cars.get(c).getLoc() == s) && cars.get(c).getDir()==false){

                    ArrayList<Passenger> carPass = cars.get(c).getPass();
                    for(int i = 0; i < passDown.size(); i++){

                        if(carPass.size() < 4){
                            cars.get(c).pickup(passDown.get(0));
                            stations.get(s).delete(passDown.get(0));
                            passDown.remove(i);
                            i--;
                        }
                    }
                }
            }


        }

    }
    //checks if car has rearched its destination

    public boolean carIsAtDestination(Car c){

        if(c.getDes()==c.getLoc()){
            return true; //car reached its destination
        }

        return false; //car hasnt reached its destination

    }

    public void deleteCar(Car c){
        int station = c.getLoc();
        ArrayList<Passenger> pass = c.getPass();

        for(int i = 0; i < pass.size(); i++){
            stations.get(station).add(pass.get(i));
        }

       
        cars.remove(c);
        

    }


    public void dropoff(int c){
        ArrayList<Passenger> pass = cars.get(c).getPass();
        for(int p = 0; p < pass.size(); p++){
            if(cars.get(c).getLoc()==pass.get(p).getDes()){
                stations.get(cars.get(c).getLoc()).add(pass.get(p));
                cars.get(c).remove(p);
            }
        }
    }


    public void move(){

        for(int c = 0; c < cars.size(); c++){
            cars.get(c).move();

            if(carIsAtDestination(cars.get(c))){
                deleteCar(cars.get(c));
            
            } else {
                dropoff(c);
            }
            
            

            
        }
        putPassengersInCars();

    }

    public ArrayList<Car> getCars(){
        return cars;
    }

    
    public String toString(){
        String finished = "";

        for(int i = 0; i < stations.size(); i++){
            finished += stations.get(i).listPass();
            finished += "\n\n";
        }

        finished += "\n";

        for(int i = 0; i < cars.size(); i++){
            finished += cars.get(i).listPass();
            finished += "\n\n";
        }

        finished += "\n";

       
        return finished;
    }
}