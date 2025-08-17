package parkinglot;

import java.time.LocalDateTime;

public class ExitGate {
    private int entranceGateId;
    private String name;
    private GateObserver observer;
    private ParkingLot parkingLot;

    public ExitGate(int entranceGateId, String name, ParkingLot parkingLot) {
        this.entranceGateId = entranceGateId;
        this.name = name;
        this.parkingLot = parkingLot;

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

    public GateObserver getObserver() {
        return observer;
    }

    public void setObserver(GateObserver observer) {
        this.observer = observer;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void takePayment(PaymentStrategy paymentStrategy, Ticket ticket) {
        int amount = ticket.calculateFee(LocalDateTime.now());
        paymentStrategy.pay(amount);
        parkingLot.unparkVehicle(ticket);
    }
}
