package com.atamertc.aksam;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class SiparisGunu2 {

    public static void main(String[] args) {
        LocalDate alisVerisTarihi = alisVerisTarihiAl();
        LocalDate faturaTarihi = LocalDate.of(alisVerisTarihi.getYear(), alisVerisTarihi.getMonth(), 15);
        faturaTarihiKontrol(alisVerisTarihi, faturaTarihi);
    }

    public static void faturaTarihiKontrol(LocalDate alisVerisTarihi, LocalDate faturaTarihi) {
        if (alisVerisTarihi.isBefore(faturaTarihi)) {
            System.out.println("Fatura tarihine daha var");
            long kalanGun = ChronoUnit.DAYS.between(alisVerisTarihi, faturaTarihi);
            System.out.println(kalanGun + " gun vardır");
        } else if (alisVerisTarihi.isEqual(faturaTarihi)) {
            System.out.println("Fatura tarihi bugundur");
        } else {
            System.out.println("Fatura tarihi geçmiştir");
            faturaTarihi = faturaTarihi.plusMonths(1);
            long kalanGun = ChronoUnit.DAYS.between(alisVerisTarihi, faturaTarihi);
            System.out.println(kalanGun + " gun vardır");
        }
    }

    public static LocalDate alisVerisTarihiAl() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen bir fatura tarihi giriniz (yıl-ay-gun)");
        String tarih = scanner.nextLine();
        return LocalDate.parse(tarih);
    }
}
