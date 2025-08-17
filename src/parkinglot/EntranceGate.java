package parkinglot;

public class EntranceGate {
    private int entranceGateId;
    private String name;
    private GateObserver observer;
    private ParkingLot parkingLot;

    public EntranceGate() {
    }

    public EntranceGate(int entranceGateId, String name, ParkingLot parkingLot) {
        this.entranceGateId = entranceGateId;
        this.name = name;
        this.parkingLot = parkingLot;
    }

    public void registerObserver(GateObserver observer) {
        this.observer = observer;
    }

    public int getEntranceGateId() {
        return entranceGateId;
    }

    public void setEntranceGateId(int entranceGateId) {
        this.entranceGateId = entranceGateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void notifyVehicleEntered(Vehicle vehicle) {
        if (observer != null) {
            observer.onVehicleEntered(vehicle, this);
        }
    }

    public Ticket allowEntry(Vehicle v) {
        System.out.println("Vehicle entered through gate: " + this.getName());
        Ticket ticket = parkingLot.parkVehicle(v);
        notifyVehicleEntered(v);
        return ticket;
    }

}
