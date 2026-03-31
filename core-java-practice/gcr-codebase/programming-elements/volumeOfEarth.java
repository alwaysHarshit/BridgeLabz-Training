public class volumeOfEarth {
    public static void main(String[] args) {
        int radiusinkm = 64000;
        double volume = (4/3) * Math.PI * radiusinkm * radiusinkm * radiusinkm;
        double volumeInMiles=volume*0.000621371;
        System.out.println("The volume of earth is "+volumeInMiles+" cubic miles"+"and"+" "+volume+" cubic meters");

    }
}
