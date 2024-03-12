package org.example;

public class Main {
    public static void main(String[] args) {
        Trip trip1 = new Trip("3 days","Paris");
        Church church1 = new Church("church1","description of curch1", "image of church 1");
        trip1.addAttraction(church1);
        Statue statue1 = new Statue("statue1","description of statue1", "image of statue1",
                "Tuesday","10-14");
        Concert concert1 = new Concert("concert1", "description of concert1","image of concert1",
               "Monday","20-22",50 );
        trip1.addAttraction(statue1);
        trip1.addAttraction(church1);
        trip1.addAttraction(concert1);

        System.out.println(trip1.toString());


    }
}