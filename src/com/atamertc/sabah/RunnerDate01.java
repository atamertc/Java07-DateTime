package com.atamertc.sabah;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

public class RunnerDate01 {
    public static void main(String[] args) {
        /*
        Tarih - zaman bilgisi programlarda nerelerde kullanilir?
        Yapilan islemlerin ne kadar surede gerceklestigini izlemek
        Hangi kullanici hangi islemi ne zaman gerceklestirdi
        Kullanici sisteme giris cikis zamani
        Uyelerinizin dogum tarihini tutmak icin
        Program calisma suresinu tutmak icin
        Hata olustugu tarih, cozuldugu tarih
        Date Calendar
        Java 8 ile beraber Time geldi
        Zaman damgasi ile tarih tutma -> Long tipinde
        Long bilgisi Unix epoch time getirir: 01.01.1970 00:00:00:0000
        Guncel tarih ile bu tarih farkini alir ve bunu long olarak verir.
        1000 000 000 ns -> 1 sn
        1000 ms         -> 1 sn
        60 sn           -> 1 dk
        60 dk           -> 1 sa
        24 sa           -> 1 g

        -Faydalari-
        Long tipinde veri tutmak daha az yer kaplar
        Hesaplama islemlerinde cok daha efektif sonuclar alinir
         */

        System.out.println("Simdiki zaman: "+System.currentTimeMillis());
        //Simdiki zaman: 1682404647652
        //Simdiki zaman: 1682404712226

        //Date Sinifi - cogu metod deprecated olmus durumda
        //Yeni java versiyonlarinda tamamen kaldirilacaktir
        Date date = new Date();
        System.out.println("Tarih: " + date);
        System.out.println("Tarih.getTime: " + date.getTime());
        System.out.println("Tarih.getDate: " + date.getDate());//Ayin kacinci gunu
        System.out.println("Tarih.getDay: " + date.getDay());//Haftanin kacinci gunu
        System.out.println("------------------------------------------------------");
        /*
        LocalDate       -> Tarih 25 04 2023
        LocalTime       -> Saat 09:57:25
        LocalDateTime   -> Tarih + Zaman
        ZonedDateTime   ->
         */

        //LocalDate Sinifi
        System.out.println("LOCALDATE SINIFI");
        System.out.println("Local Date: " + LocalDate.now());
        System.out.println("Local Time: " + LocalTime.now());
        System.out.println("Local Date Time: " + LocalDateTime.now());
        System.out.println("Zoned Date Time: " + ZonedDateTime.now());
        System.out.println("------------------------------------------------------");

        LocalDate bugun = LocalDate.now();
        System.out.println("getDayOfMonth(): " + bugun.getDayOfMonth());
        System.out.println("getDayOfYear(): " + bugun.getDayOfYear());
        System.out.println("getDayOfWeek(): " + bugun.getDayOfWeek());
        System.out.println();
        System.out.println("getYear(): " + bugun.getYear());
        System.out.println("getMonth(): " + bugun.getMonth());
        System.out.println("isLeapYear(): " + bugun.isLeapYear());
        System.out.println();
        LocalDate yarin = bugun.plusDays(1);
        System.out.println("Yarinin Tarihi: "+yarin);
        LocalDate dun = bugun.minusDays(1);
        System.out.println("Dunun Tarihi: "+dun);
        System.out.println("------------------------------------------------------");

        //.of() metodu bir seylerden bir sey olustururken kullanilir genelde
        LocalDate belirliTarih = LocalDate.of(2023, 2, 28);
        System.out.println(belirliTarih.minusMonths(1));
        System.out.println(belirliTarih); //Ustteki islem bu tarihi degistirmez
        System.out.println("------------------------------------------------------");

        LocalDate yuzyilOnce = LocalDate.now().minus(100, ChronoUnit.YEARS);
        System.out.println("Yuz yil once: " + yuzyilOnce);
        LocalDate elliayOnce = LocalDate.now().minus(50, ChronoUnit.MONTHS);
        System.out.println("Elli ay once: " + elliayOnce);

        LocalDate belirliTarih2 = LocalDate.of(2000, Month.APRIL, 2);
        System.out.println(belirliTarih2);
        System.out.println("------------------------------------------------------");

        //LocalTime Sinifi
        System.out.println("LOCALTIME SINIFI");
        System.out.println("Local Time: " + LocalTime.now());
        LocalTime zaman = LocalTime.now();
        System.out.println("getHour: " + zaman.getHour());
        System.out.println("getMinute: " + zaman.getMinute());
        System.out.println("getNano: " + zaman.getNano());
        System.out.println("getSecond: " + zaman.getSecond());
        System.out.println();
        LocalTime ikiSaatSonra = zaman.plusHours(2);
        System.out.println("Iki Saat Sonra: " + ikiSaatSonra);

        LocalTime onbesDakikaSonra = zaman.plus(15, ChronoUnit.MINUTES);
        System.out.println("onbesDakikaSonra: " + onbesDakikaSonra);

        LocalTime belirliSaat = LocalTime.of(12, 0, 50);
        System.out.println("belirliSaat: " + belirliSaat);
        System.out.println("------------------------------------------------------");

        //LocalDateTime Sinifi
        System.out.println("LOCALDATETIME SINIFI");
        System.out.println("Local Date Time: " + LocalDateTime.now());
        LocalDateTime ldt = LocalDateTime.of(belirliTarih2, belirliSaat);
        System.out.println(ldt);

        //1 ay ekledigimiz zaman bir sonraki ayin son tarihini geciyorsa bir sonraki ayin
        //son tarihini doner, artan gunleri maalesef kirpiyor
        LocalDate ld = LocalDate.of(2000, 1, 31);
        System.out.println("Eklenecek ay: "+ld);
        System.out.println("1 ay sonra: "+ld.plusMonths(1));

        //ZonedDateTime Sinifi
        System.out.println("ZONEDDATETIME SINIFI");
        System.out.println("Zoned Date Time: " + ZonedDateTime.now());
        ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("Europe/Istanbul"));

        ZonedDateTime zdtIstanbul = ZonedDateTime.now(ZoneId.of("Europe/Istanbul"));
        System.out.println("zdtIstanbul" + zdtIstanbul);
        System.out.println("--------------------------------------------------------");

//        Set<String> zoneIdler = ZoneId.getAvailableZoneIds();
//        for (String zoneId : zoneIdler) {
//            System.out.println(zoneId);
//        }
//        System.out.println(zoneIdler.size());

        //Period Kullanimi
        LocalDate dogumGunu = LocalDate.of(1997, 2, 4);
        LocalDate bugun2 = LocalDate.now();
        System.out.println(Period.between(dogumGunu, bugun2));
        Period yas = Period.between(dogumGunu, bugun2);
        System.out.println(yas.getYears() + " yil " + yas.getMonths() + " ay " + yas.getDays() + " gun");

        //Yapilan islem suresi takibi
        Long baslangicMs = System.currentTimeMillis();// 1. Yontem
        Long baslangicNs = System.nanoTime();// 2. Yontem
        Instant baslangicIns = Instant.now();// 3. Yontem
        long toplam = 0;
        for (long i = 0; i < 1_000_000_000L; i++) {
            toplam++;
        }
        Long bitisMs = System.currentTimeMillis();
        Long bitisNs = System.nanoTime();
        Instant bitisIns = Instant.now();
        System.out.println("Islem suresi ms: " + (bitisMs - baslangicMs));
        System.out.println("Islem suresi ns: " + (bitisNs - baslangicNs));
        //Duration icindeki metodlar sayesinde her turde sureye ulasilir
        Duration duration = Duration.between(baslangicIns, bitisIns);
        System.out.println("Instant milisaniye: "+duration.toMillis());
        System.out.println("Instant nanosaniye: " + duration.toNanos());

        //DateTimeFormatter
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy");
        LocalDate dogumGunu2 = LocalDate.of(1997, 2, 4);
        System.out.println("Dogdugum gun hangi gun: "+dogumGunu2.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()));
        System.out.println("Formatsiz hali: " + dogumGunu2);
        System.out.println("Formatli hali: " + dogumGunu2.format(dtf));



        DateFormat tarih = new SimpleDateFormat("yyyy/MM/dd");
        Date kiralamaTarihi = new Date();
        String tarihKira = tarih.format(kiralamaTarihi);
        DateFormat saat = new SimpleDateFormat("HH:mm:ss");
        Date kiralamaSaati = new Date();
        String saatKira = saat.format(kiralamaSaati);
        System.out.println(tarihKira + " " + saatKira);





    }
}
