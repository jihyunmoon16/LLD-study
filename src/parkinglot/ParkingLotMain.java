package parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLotMain {
    public static void main(String[] args) throws InterruptedException {
        ParkingSpot psCar = new ParkingSpot(0, VehicleType.CAR);
        ParkingSpot psBike = new ParkingSpot(1, VehicleType.BIKE);
        ParkingSpot psTruck = new ParkingSpot(2, VehicleType.TRUCK);

        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(psCar);
        parkingSpots.add(psBike);
        parkingSpots.add(psTruck);

        // Initialize parking lot
        ParkingLot parkingLot = new ParkingLot(parkingSpots);

        // Get vehicle info from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter License Plate Number: ");
        String licensePlateNumber = sc.nextLine();

        System.out.print("Enter Vehicle Type (CAR / BIKE / TRUCK): ");
        String vehicleType = sc.nextLine().trim().toUpperCase();

        Vehicle v1 = new Vehicle(licensePlateNumber, VehicleType.valueOf(vehicleType));

        // Park vehicle
        ParkingTicket ticket = parkingLot.parkVehicle(v1.getVehicleType());
        System.out.println("Vehicle parked. Ticket ID: " + ticket.getId());

        Thread.sleep(100000);

        // Payment
        Payment payment = new Payment();
        payment.processPayment(ticket);

        // Unpark vehicle
        parkingLot.unparkVehicle(ticket);
        System.out.println("Vehicle unparked successfully.");
    }
}
