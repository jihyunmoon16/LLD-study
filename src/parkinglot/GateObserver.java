package parkinglot;

public interface GateObserver {
    void onVehicleEntered(Vehicle vehicle, EntranceGate gate);

    void onVehicleExited(Vehicle vehicle, EntranceGate gate);
}
