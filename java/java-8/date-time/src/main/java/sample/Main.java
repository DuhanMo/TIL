package sample;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // 기계용이지만 출력하면 이쁘게 나옴
        Instant now = Instant.now();
        System.out.println(now); // 기준시 UTC == GMT
        System.out.println(now.atZone(ZoneId.of("GMT+09:00")));

        // local 이기 때문에 서버의 위치에 따라 시각이 달라질 수 있음
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);
        LocalDateTime localDateTimeOf = LocalDateTime.of(1995, Month.JUNE, 19, 0, 0, 0);
        System.out.println("localDateTimeOf = " + localDateTimeOf);

        // 특정 존의 시각이 궁금하다면
        // 인스턴트와 zonedDateTime 이 서로 변환 가능하다.
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("zonedDateTime = " + zonedDateTime);
        ZonedDateTime zonedDateTime1 = now.atZone(ZoneId.of("GMT+09:00"));

        // 기간이 궁금하다면 (human)
        LocalDate today = LocalDate.now();
        LocalDate nextYearBirthDay = LocalDate.of(2023, Month.JUNE, 19);

        Period between = Period.between(today, nextYearBirthDay);
        System.out.println("다음 생일까지 남은 기간 = " + between);

        // machine 용 기간 Duration
        Instant instantNow = Instant.now();
        Instant plus = now.plus(10, ChronoUnit.SECONDS);
        Duration duration = Duration.between(instantNow, plus);

        System.out.println("duration = " + duration.getSeconds());

        // 포매터로 형식을 변형하고 싶다면
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String format = localDateTimeNow.format(MMddyyyy);
        System.out.println("format = " + format);

        LocalDate parse = LocalDate.parse("07/22/2022", MMddyyyy);
        System.out.println("parse = " + parse);

        // 레거시 api 지원
        Date date = new Date();
        Instant instant = date.toInstant();
        System.out.println("date.toInstant() = " + instant);

        Date dateFrom = Date.from(Instant.now());
        System.out.println("dateFrom = " + dateFrom);
    }
}
