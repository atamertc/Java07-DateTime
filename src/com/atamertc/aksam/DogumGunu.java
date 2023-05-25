package com.atamertc.aksam;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/*
String olarak dogum gununuzu girin
bugune kadar kac yil kac ay kac hafta kac gun yasamissiniz onu yazdiralim
 */
public class DogumGunu {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dg = "04/02/1997";
        LocalDate date = LocalDate.parse(dg, formatter);
        Period period = Period.between(date, LocalDate.now());
        System.out.printf("%d yil %d ay %d gundur hayattasiniz", period.getYears(),
                period.getMonths(), period.getDays());
    }
}
