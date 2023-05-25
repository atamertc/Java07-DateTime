package com.atamertc.aksam;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateAksamRunner {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println("1- "+date);
        LocalDate date2 = LocalDate.now();
        System.out.println("2- "+date2);
        LocalDateTime date3 = LocalDateTime.now();
        System.out.println("3- "+date3);
        LocalDate date4 = LocalDate.of(2005, 8, 06);
        LocalDate date5 = LocalDate.of(2004, Month.AUGUST, 06);
        System.out.println("4- "+date4);
        System.out.println("5- "+date5);
        System.out.println("6- "+date4.getDayOfMonth());
        System.out.println("7- "+date4.getYear());
        System.out.println("8- "+date4.getMonthValue());
        System.out.println("9- "+date4.getDayOfYear());
        System.out.println("10- "+date4.getMonth());
        System.out.println("11- "+date4.isAfter(date2));
        System.out.println("12- "+date4.isBefore(date2));
        System.out.println("13- "+date4.isEqual(date5));
        System.out.println("14- "+date4.getDayOfWeek());
        System.out.println("15- "+date4.getDayOfWeek().getValue());
        System.out.println("16- "+date4.isLeapYear());
        System.out.println("17- "+date5.isLeapYear());
        System.out.println("18- "+date5.plusYears(1));
        System.out.println("19- "+date5.plusMonths(1));
        System.out.println("20- "+date5.plusDays(10));
        System.out.println("21- "+date5.plusWeeks(3));
        System.out.println("22- "+date5.minusWeeks(3));
        LocalDate date6 = LocalDate.parse("2022-12-11");
        System.out.println(date6);
        System.out.println("--------------------------------------------------");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date7 = LocalDate.now().format(formatter);
        System.out.println(date7);
        System.out.println("--------------------------------------------------");
        String str1 = "10/04/2020";
        LocalDate date8 = LocalDate.parse(str1, formatter);
        System.out.println(date8);
        LocalDate date10 = LocalDate.now();
        LocalDate date11 = LocalDate.of(2023, 03, 03);

        //2 Tarih arasindaki farklar
        //1. yontem until()
        long ay = date11.until(date10, ChronoUnit.MONTHS);
        long gun = date11.until(date10, ChronoUnit.DAYS);
        System.out.println(ay);
        System.out.println(gun);
        //2. yontem between()
        long hafta = ChronoUnit.WEEKS.between(date11, date10);
        System.out.println(hafta);
        //3. yontem Period classi - duzgun sonuclar vermiyor 1 ay 23 gun olarak veriyor
        Period period = Period.between(date11, date10);
        System.out.println(period.getDays());
        //4. yontem Duration classi
        //Duration saatte bekliyor bizden o yuzden LocalDateTime sinifindan nesne olmasi gerek
        Duration duration = Duration.between(date11, date10);
        System.out.println(duration.getSeconds());
















    }
}
