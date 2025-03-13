public class RideshareTester {
    public static void main(String[] args) {
        //start of rideshare!!!
        System.out.println("Completed Rideshare Project!");
        System.out.println();
        Road r = new Road(20, 50); //change to 40 if you want to see 40 passengers and 20 cars!
        System.out.println(r);

        while(r.getCars().size()>0){
            r.move(); //move along the road
        }

        System.out.println(r);
    }
}
//done with tester
