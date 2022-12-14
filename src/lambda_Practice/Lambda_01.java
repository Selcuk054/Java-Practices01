package lambda_Practice;

import java.awt.desktop.AboutEvent;
import java.util.*;
import java.util.stream.Collectors;

public class Lambda_01 {//okul projesinde listele vb lamda expression ile yapiniz
    static ArrayList<String> names = new ArrayList<>(
            Arrays.asList("Tulay", "zekeriya", "hasan", "ismail", "osman", "fatih","Ersin","Mevlit"));
    static List<Integer> numbers=new ArrayList<>(Arrays.asList(25,65,-56,55,98,-89,65,55,21,-54,9,35,35,34));

    static List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "adana", "trilice", "havucdilim", "buryan",
            "kokorec", "kuzutandir", "guvec"));
    /* SORU 1-) :Input olarak verilen listteki isimlerden icinde ‘a’ harfi bulunanlari silen bir code create ediniz.
     */
    public static void aHarfleriSilenGerisiniYazdiran(ArrayList<String> isimler){
//       1.yol
//        System.out.println(isimler.stream()//akiisa alindi
//                .map(m -> m.toLowerCase())//hepsi kucuk harffe cevrilfi
//                .filter(m -> !m.contains("a"))//a harfi olmayanlar filtrelendi
//                .collect(Collectors.toList()));//lisste atildi
//      2.yol
//        System.out.println(isimler.stream()//akiisa alindi
//                .filter(m -> !m.contains("a") && !m.contains("A"))//a harfi olmayanlar filtrelendi
//                .collect(Collectors.toList()));//lisste atildi
//      3.yol
        isimler.removeIf(t->t.contains("a") || t.contains("A"));
        System.out.println(names);
    }

    // SORU 2-) en buyyk elemani bulun
    public static void maxElemanBul(List<Integer> sayi){
        Optional<Integer> maxSayi=
                sayi.stream().
                        reduce(Math::max);
        System.out.println("maxSayi = " + maxSayi);
        //2.yol
        System.out.println("sayi.stream().reduce(Integer::max) = " + sayi.
                stream().
                reduce(Integer::max));//spesifik bir method cagirirsaniz daha hizli yanit alirsiniz
//        reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
//                kullanımı yaygındır pratiktir.
//        Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
//        bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
//                reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
//                reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
//        İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.
    }

    // SORU 3-) : List'teki tum elemanlarin toplamini yazdiriniz. Lambda Expression..

    public static void elemanlariTopla(List<Integer> sayilar){
        //1. yol
        System.out.println("sayilar.stream().reduce(0,(a,b)-> a+b) = " +
                sayilar.stream()
                        .reduce(0, (a, b) -> a + b));
        //2. yol
        System.out.println("sayilar.stream().reduce(Integer::sum) = " + sayilar.stream().
                reduce(Integer::sum).get());//spesifik methoda gore daha hizlidir
    }

    // SORU 4-) : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void elemanlariCarp(List<Integer> sayilar){
        //lambda expression ile
        System.out.println("sayilar.stream().reduce(1,(a,b)-> a*b) = " +
                sayilar.stream()
                        .filter(My_Methods::ciftElemaniBul)//method referans kullanildi kendi classimizda
                        // create ettigimiz seed methodu kulandik
                        .reduce(1, (a, b) -> a * b));
        //method referans ile
        System.out.println(sayilar.stream().filter(My_Methods::ciftElemaniBul)
                .reduce(Math::multiplyExact));
    }

    //SORU 5-) tek sayilarin lerin karesini buyukten kucuge
    public static void teklerinKareBuyuktenKucuge(List<Integer> sayi) {
        sayi.stream()//liste akisa alindi
                .filter(t->t%2!=0)//tek olan rakamlari sayilari filtreledim
                .map(t-> t*t) //her tek sayinin karesini aldim.
                .sorted(Comparator.reverseOrder())//buyukten kucuge siraliyoruz
                .forEach(My_Methods::yazdir);//seed method kullanilarak method ref ile yazdirildi
    }

    // Soru 6-) List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfabetikBuyukHarfTekrarsiz(List<String> yemek) {
    }
    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void strKarakterSayisiYazdir(List<String> yemek) {
    }
    // Task :TODO list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHarfeGoreTersSira(List<String> yemek) {//yukarida tanimladigim listlerden calisacagim
        yemek.stream()
                .sorted(Comparator.comparing(t->t.toString().charAt(t.toString().length()-1)).reversed())
                //sirama yaptik, tostring ile herbir eleman string e cevrildi,
                //son karakter i charAt ile alindi
                //reserved ile son harfe gore tersine siralandi
                .forEach(My_Methods::yazdir);//yazdirildi




    }
    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz
    // buyukten kucuge sirali  print ediniz..
    public static void karakterCiftKareBuyuktenKucuge(List<String> yemek) {
    }
    // TODO Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void karakterSayiYedidenBuyuk(List<String> yemek) {
/*
System.out.println("yemek.stream().anyMatch(t->t.toString().length()<7) = " + yemek.stream().anyMatch(t -> t.toString().length() < 7));
System.out.println("yemek.stream().allMatch(t->t.toString().length()<7) = " + yemek.stream().allMatch(t -> t.toString().length() < 7));
System.out.println("yemek.stream().noneMatch(t->t.toString().length()<7) = " + yemek.stream().noneMatch(t -> t.toString().length() < 7));
Sorunun farkli cozumleri.
 */

       boolean kontrol = yemek.stream().allMatch(t->t.length()<=7);//true ise if calisacak degilse else
       if(kontrol){
           System.out.println("List elemanlari 7 ve daha az haften olusmus");
       }else System.out.println("Bazi elemanlar 7 den buyuk");

       //Lambda yazim java 8 in faydalari ne guzel

        System.out.println(yemek.stream()
                .allMatch(t -> t.length() <= 7) ?
                "List elemanlari 7 ve daha az haften olusmus" : "Bazi elemanlar 7 den buyuk");


    }
    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.
    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void basHarfiWIleBaslayan(List<String> yemek) {
    }
    // TODO Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    public static void xIleBitenEleman(List<String> yemek) {





    }
    // TODO Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void karkterEnFazla(List<String> yemek) {
        //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
        // şekilde kesilmiş bir akış return eder. Stream return eder.

        yemek.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed());
        //


    }
    /*
TRİCK : •    Stream'ler ekrana direk yazdırılamaz. Stream'i toArray() ile Array'e çeviririz.
Array'i de Arrays.toString() 'in içine alıp yazdırabiliriz.
•  Ör; System.out.println(Arrays.toString(***.toArray())); veya System.out.println(Arrays.asList(***.toArray()));
kullanılabilir.
*/
    //TODO Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void sonHarfeGoreSiralaIlkHaricElmanlariYaz(List<String> yemek) {
    }

}