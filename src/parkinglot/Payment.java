package parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;

public class Payment {
    public void processPayment(ParkingTicket ticket) {
        LocalDateTime now = LocalDateTime.now();

        // 두 시간 차이를 Duration으로 계산
        Duration duration = Duration.between(ticket.getEnteredAt(), now);

        // 총 분 단위 (초는 버림)
        long minutes = duration.toMinutes();

        System.out.println("주차 시간(분): " + minutes);

        // 예시: 차량 타입별 분당 요금 (임의 설정)
        int ratePerMinute = 0;
        switch(ticket.getParkedAt().getVehicleType()) {
            case CAR:
                ratePerMinute = 100;  // 100원/분
                break;
            case BIKE:
                ratePerMinute = 50;   // 50원/분
                break;
            case TRUCK:
                ratePerMinute = 150;  // 150원/분
                break;
        }

        long payment = minutes * ratePerMinute;

        System.out.println("결제 금액: " + payment + "원");

    }
}
