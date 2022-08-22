package lambda_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lambda_01 {
    static ArrayList<String> names = new ArrayList<>(Arrays.asList("Tulay", "Zekeriya", "hasan", "ismail", "osman", "fatih", "ersin", "mevlut"));
    static List<Integer> numbers = new ArrayList<>(Arrays.asList(25, 65, 56, 55, 98, 89, 65, 55, 21, 54, 9, 35, 35, 34));

    /* TASK :

  Soru 1-) Input olarak verilen listteki isimlerden
     * icinde 'a' harfi bulunanlari silen bir code create ediniz.
     *
     * INPUT : list1={"Ali","Veli","Ayse","Fatma","Omer"}
     * OUTPUT : [Veli,Omer]
     */

    public static void aHarfiBulunanlariSilenMethod(ArrayList<String> list) {
        //1. yol
//      System.out.println(list.stream()//akisa alindi
//                .map(t -> t.toLowerCase())//hepsi kucuk  aerfe cevrildi
//                .filter(t -> !t.contains("a"))//a harfi olmayanlar filtrelendi
//                .collect(Collectors.toList()));//liste atildi
        //2.yol
//        System.out.println(list.stream()//akisa alindi
//                .filter(t -> !t.contains("a") && !t.contains("A"))//a harfi olmayanlar filtrelendi
//                .collect(Collectors.toList()));//liste atildi

        //3.yol
        list.removeIf(t -> t.contains("a") || t.contains("A"));
        System.out.println(names);

        //Soru 2 - //en buyuk elemani bulun
    }

    public static void getMAx(List<Integer> list) {
        list.stream().reduce(Integer::max); //list teki en buyuk elemani bulma


    }

    public static void getMAx02(List<Integer> list) {
        Optional<Integer> Maxsayi = list.stream().reduce(Math::max);
        System.out.println("Maxsayi :" + Maxsayi);
        System.out.println(list.stream().reduce(Integer::max));//spesifik bir method cagirirsaniz cevap verme suresi kisaliyor


    }
    /*
    reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
kullanımı yaygındır pratiktir.
Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.
     */

    //Soru -3
    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
//Lambda Expression...
    public static void elemanlariTopla(List<Integer> sayilar) {
        sayilar.stream().reduce(0, (a, b) -> a + b);

        sayilar.stream().reduce(Integer::sum);
        System.out.println(sayilar.stream().reduce(Integer::sum));//spesifik method daha hizlidir.

    }
    // Soru -4
    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void elemanlaricarp(List<Integer> sayilar) {
        Integer toplam=sayilar.stream().filter(a-> a%2==0).reduce(1,(a,b)->a*b);
        System.out.println("elemanlaricarp toplami :"+toplam);

        sayilar.stream().filter(My_Methods::ciftElemaniBul).reduce(1,(a,b)->a*b);

        sayilar.stream().filter(My_Methods::ciftElemaniBul).reduce(Math::multiplyExact);


    }
}