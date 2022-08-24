package lambda_Practice;


    import java.io.IOException;

    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.util.Arrays;
    import java.util.stream.Collectors;
    import java.util.stream.Stream;
/*
dosya eklemek icin 2 yol var
1) Files.lines(Path.of("path")  buradan stream e eklemek icin
Stream <String> satir=Files.lines(Path.of(".........."));
bu bize tekrardan stream tanimlamadan kullanmayi saglar
2) //Files.lines(Paths.get("..........")).  kullanilir
==========================================================
intellj dosya eklemek icin src => new=>file=>text diyoruz ve istedigimiz metni buraya kopyaliyoruz
bu dosyanin path almak icin dosyanin uzerine gelip sag tikliyoruz(burada dosya C7_TextFile)
sonrasinda copy path seciyoruz bundan sonra iki secenek var
1) absolute path seciyoruz yada
2) path from content root seciyoruz
her ikisinde de path kopyalamis oluyoruz
cevirirken EXCEPTION OLUSMASIN DIYE => throws IOException <= EKLEMELIYIZ
buda lines altinda kirmizi uyari veriyor uzerine tiklayinca kendiliginden oluyor
*/
public class Lambda02_DosyaOkuma {// yolu src/lambda_practice/siirler.txt
    //src/lambda_practice/siirler.txt
    public static void main(String[] args) throws IOException {
        System.out.println("\nTASK 01 --> siirler.txt dosyasini konsolda yazdiriniz -->  ");

        //1. yol
        Path muti=Path.of("src/lambda_Practice/siirler.txt");//siirler dosyasi muti obj sine atandi

        Stream <String> akis=Files.lines(muti);//muti obj si akis obj sine atanarak Stream classsinda akisa alindi
        // akis.forEach(System.out::println);
        //buyuk harfe cevirdil
        akis.map(String::toUpperCase).forEach(My_Methods::yazdir);

        //2.yol
        Files.
                lines(Path.of("src/lambda_practice/siirler.txt"))
                .forEach(My_Methods::yazdir);

        //Soru 1
        System.out.println("\nTASK 1  --> siirler.txt dosyasindaki ilk satiri kucuk harflerle yazdirin  -->  ");
        Files.lines(muti).map(String::toUpperCase).limit(1).forEach(System.out::println);
        System.out.println(Files.lines(muti).map(String::toUpperCase).findFirst().get()); //get kullandigimizda optional i kaldiriyor.

        //Soru 2
        System.out.println("\nTASK 2 --> siirler.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println(Files.lines(muti)//dosya akisa alindi
                .map(String::toLowerCase)//tamami kucuk harfe cevrildi
                .filter(t -> t.contains("hatir"))//her bir satirda asari kelimesi varmi yokmi kontrol edildi.
                .count());//kac satirda hatir kelimesi gectigini verdi.

        //Soru 3
        System.out.println("\nTASK 3  --> siirler.txt dosyasindaki ayni kelimeleri cikartarak yazdiriniz. -->  ");
       //1. yol
        System.out.println(Files.lines(muti)
                .map(t -> t.split(" "))//herbir kelime alindi
                .flatMap(Arrays::stream)//duz bir yapiya yani tek bir array e cevirdi
                .distinct()
                .collect(Collectors.toList()));// Toplayip liste yazdirdi
        //2.yol
        System.out.println(Files.lines(muti)
                .map(t -> t.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.toSet()));

        //SORU 4-)
        System.out.println("\nTASK 4 --> siirler.txt dosyasindaki tum kelimeleri natural order yazdiriniz. -->  ");
        Files.lines(muti).
                map(t-> t.toLowerCase().
                        split(" ")).
                flatMap(Arrays::stream).
                sorted().
                forEach(My_Methods::yazdir);

        //SORU 5-)
        System.out.println("\nTASK 5 --> siirler.txt dosyasinda gonlum kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(muti).map(t -> t.toLowerCase().split(" ")).flatMap(Arrays::stream).filter(t -> t.equals("gonlum")).count());

        //SORU 6-)
        System.out.println("\nTASK 6 --> siirler.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        System.out.println(Files.lines(muti).map(t -> t.toLowerCase().split(" ")).flatMap(Arrays::stream).filter(t -> t.contains("a")).count());

        //SORU 7-)
        System.out.println("\nTASK 7 --> siirler.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        System.out.println(Files.lines(muti).map(t -> t.toLowerCase().split(" ")).flatMap(Arrays::stream).filter(t -> t.contains("a")).collect(Collectors.toList()));

        //SORU 8-)
        System.out.println("\nTASK 8 --> siirler.txt dosyasinda kac farklı harf kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(muti).
                map(t -> t.toLowerCase().
                        split("")).
                flatMap(Arrays::stream).
                distinct().
                count());


        System.out.println("\nTASK 9 --> siirler.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        System.out.println("\nTASK 10 --> siirler.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
    }
}
