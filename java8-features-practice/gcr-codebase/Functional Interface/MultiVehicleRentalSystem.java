import javax.smartcardio.Card;

public class MultiVehicleRentalSystem {
    public static void main(String[] args) {
    Car car=new Car();
    Track track=new Track();
    car.rent();
    car.returnVehicle();

    track.rent();
    track.returnVehicle();

    }
}
class  Car implements Services{

    @Override
    public void rent() {
        System.out.println("now car is on rent");
    }

    @Override
    public void returnVehicle() {
        System.out.println("now the car is returned");
    }
}
class  Track implements Services{

    @Override
    public void rent() {
        System.out.println("now truck is on rent");
    }

    @Override
    public void returnVehicle() {
        System.out.println("now the vehical is returned");
    }
}

interface Services{
    void rent() ;
    void returnVehicle();
}
