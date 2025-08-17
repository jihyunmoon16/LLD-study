package parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLotMain {
    public static void main(String[] args) throws InterruptedException {
        // initialize parking spots
        ParkingSpot psCar = new ParkingSpot(0, VehicleType.CAR);
        ParkingSpot psBike = new ParkingSpot(1, VehicleType.BIKE);
        ParkingSpot psTruck = new ParkingSpot(2, VehicleType.TRUCK);

        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(psCar);
        parkingSpots.add(psBike);
        parkingSpots.add(psTruck);


        // initialize parking lot
        ParkingLot parkingLot = new ParkingLot(parkingSpots);

        // initialize gates
        EntranceGate entranceGate1 = new EntranceGate(1, "North Gate", parkingLot);
        EntranceGate entranceGate2 = new EntranceGate(2, "South Gate", parkingLot);

        ExitGate exitGate1 = new ExitGate(1, "North Exit", parkingLot);
        ExitGate exitGate2 = new ExitGate(2, "South Exit", parkingLot);

        // register observer
        Dashboard dashboard = new Dashboard(parkingLot);
        entranceGate1.registerObserver(dashboard);
        entranceGate2.registerObserver(dashboard);

        // Get vehicle info from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter License Plate Number: ");
        String licensePlateNumber = sc.nextLine();

        VehicleType type = null;

        while (type == null) {
            System.out.print("Enter Vehicle Type (CAR / BIKE / TRUCK): ");
            String vehicleType = sc.nextLine().trim().toUpperCase();

            try {
                type = VehicleType.valueOf(vehicleType); // 유효한 enum인지 확인
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Invalid vehicle type. Please enter CAR, BIKE, or TRUCK.");
            }
        }

        Vehicle v1 = new Vehicle(licensePlateNumber, type);

        // Park Vehicle
        Ticket ticket = entranceGate1.allowEntry(v1);

        Thread.sleep(100000);

        // Payment
        exitGate1.takePayment(new CashStrategy(), ticket);
    }
}
