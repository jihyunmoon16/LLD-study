package parkinglot;

import java.util.List;

public class ParkingLot {
    List<ParkingSpot> spots;

    public ParkingLot() {
    }

    public ParkingLot(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    public Ticket parkVehicle(Vehicle v) {
        synchronized (this) {
            for (ParkingSpot spot : spots) {
                if (!spot.isOccupied() && spot.getSpotType().equals(v.getVehicleType())) {
                    return spot.parkVehicle(v);
                }
            }
        }
        System.out.println("ParkingLot is full");
        return null;
    }

    public void unparkVehicle(Ticket ticket) {
        ParkingSpot spot = spots.get(ticket.getParkingSpotId());
        spot.unparkVehicle();
    }

    public int getTotalCapacity() {
        return spots.size();
    }

    public int getAvailableSpots() {
        return (int) spots.stream().filter(spot -> !spot.isOccupied()).count();
    }
}
