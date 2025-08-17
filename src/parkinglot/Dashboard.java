package parkinglot;

public class Dashboard implements GateObserver {
    ParkingLot parkingLot;

    public Dashboard(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void display() {
        System.out.println("Total Capacity: " + parkingLot.getTotalCapacity());
        System.out.println("Available spots: " + parkingLot.getAvailableSpots());
    }

    @Override
    public void onVehicleEntered(Vehicle vehicle, EntranceGate gate) {
        System.out.println("Dashboard: Vehicle entered. Updating available spots.");
        display();
    }

    @Override
    public void onVehicleExited(Vehicle vehicle, EntranceGate gate) {
        System.out.println("Dashboard: Vehicle exited. Updating available spots.");
        display();
    }
}
