package parkinglot;

import java.time.LocalDateTime;

public class ParkingSpot {
    private int id;
    private boolean isOccupied;
    private VehicleType vehicleType;
    private ParkingTicket ticket;

    public ParkingSpot() {};

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

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public ParkingTicket parkVehicle(){
        this.isOccupied = true;
        this.ticket = new ParkingTicket(id, LocalDateTime.now(), this);
        return ticket;
    };

    public void unparkVehicle(){
        this.isOccupied = false;
        this.ticket = null;
        System.out.println("successfully unparked vehicle");
    };
}
