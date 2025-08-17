package parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {
    private int parkingSpotId;
    private LocalDateTime entryTime;
    private String licensePlate;

    public Ticket() {
    }

    ;

    public Ticket(int parkingSpotId, LocalDateTime entryTime, String licensePlate) {
        this.parkingSpotId = parkingSpotId;
        this.entryTime = entryTime;
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public int calculateFee(LocalDateTime exitTime) {
        Duration duration = Duration.between(entryTime, exitTime);

        long minutes = duration.toMinutes();

        System.out.println("Miniutes parked : " + minutes);

        int ratePerMinute = 100;

        return Math.toIntExact((int) ratePerMinute * minutes);
    }

    public int getParkingSpotId() {
        return parkingSpotId;
    }
}
