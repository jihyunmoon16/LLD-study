package parkinglot;

import java.time.LocalDateTime;

public class ParkingTicket {
    private int id;
    private LocalDateTime enteredAt;
    private ParkingSpot parkedAt;

    public ParkingTicket() {};

    public ParkingTicket(int id, LocalDateTime enteredAt, ParkingSpot parkedAt) {
        this.id = id;
        this.enteredAt = enteredAt;
        this.parkedAt = parkedAt;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getEnteredAt() {
        return enteredAt;
    }

    public ParkingSpot getParkedAt() {
        return parkedAt;
    }
}
