package parkinglot;

import java.util.List;

public class ParkingLot {
    List<ParkingSpot> spots;

    public ParkingLot(){};


    public ParkingLot(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    public ParkingTicket parkVehicle(VehicleType v) {
        for(ParkingSpot spot : spots){
            if(!spot.isOccupied() && spot.getVehicleType().equals(v)){
                return spot.parkVehicle();
            }
        }
        return null;
    }

    public void unparkVehicle(ParkingTicket ticket) {
        ParkingSpot spot = spots.get(ticket.getParkedAt().getId());
        spot.unparkVehicle();
    }
}
