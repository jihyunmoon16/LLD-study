package parkinglot;

import java.time.LocalDateTime;

public class ParkingSpot {
    private int id;
    private boolean isOccupied;
    private VehicleType vehicleType;
    private Ticket ticket;

    public ParkingSpot() {
    }

    ;

    public ParkingSpot(int id, VehicleType vehicleType) {
        this.id = id;
        this.isOccupied = false;
        this.vehicleType = vehicleType;
    }

    public int getId() {
        return id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public VehicleType getSpotType() {
        return vehicleType;
    }

    public Ticket parkVehicle(Vehicle v) {
        this.isOccupied = true;
        // spot id를 리턴하는 걸로 수정
        this.ticket = new Ticket(this.id, LocalDateTime.now(), v.getLicensePlateNumber());
        return ticket;
    }

    ;

    public void unparkVehicle() {
        this.isOccupied = false;
        this.ticket = null;
        System.out.println("successfully unparked vehicle");
    }

    ;
}
