package com.atamertc.aksam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SiparisGunu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Alisveris tarihini giriniz (Gun/Ay/Yil): ");
        String input = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int faturaTarihi = 15;
        LocalDate aliverisTarihi = LocalDate.parse(input, formatter);

        if (aliverisTarihi.getDayOfMonth() > faturaTarihi) {
            System.out.println("Fatura tarihi gecmis");
            System.out.println("Fatura tarihine "+
                    (Math.abs(aliverisTarihi.getDayOfMonth() + 30 - faturaTarihi))+ " gun kaldi");
        } else if (aliverisTarihi.getDayOfMonth() == faturaTarihi) {
            System.out.println("Fatura tarihi bugundur");
        } else {
            System.out.println("Fatura tarihine daha var");
            System.out.println("Fatura tarihine "+
                    (Math.abs(aliverisTarihi.getDayOfMonth() - 30 + faturaTarihi))+ " gun kaldi");
        }
    }

}
