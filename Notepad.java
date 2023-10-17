package Notepad;

import java.io.*;
import java.util.Scanner;

public class Notepad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   //Değişkenleri tanımladık.
        Scanner sc=new Scanner(System.in);
        FileWriter fileWriter = null;
        FileReader fileReader = null;
        String line;
        boolean exit=true;

        File myFile = new File("notlar.txt");    //Dosya oluşturma işlemi

        while(exit==true) {
            //Notepad uygulamasını bir menü içinde tasarlamak için while döngüsü kullanıyoruz.
            //Boolean değişkenimiz true olduğu sürece döngü devam eder.

            System.out.println("1- Dosyaya veri yaz.\n2- Dosyadan veri oku.\n\nÇıkış için 1 ve 2 hariç bir sayı girin.\n");
            System.out.println("Lütfen bir seçim yapınız.");
            int choice = scanner.nextInt();
            switch (choice) {                     //Switch-case menü yapısı
                case 1:

                    System.out.print("Bir metin girin: ");

                    String metin = sc.nextLine();
                    try {
                        fileWriter = new FileWriter(myFile, true); //Dosyaya veri yazma işlemleri
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        printWriter.print("\n");
                        printWriter.print(metin);
                        System.out.println("Metin yazdırıldı.\n");
                        printWriter.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:

                    try {
                        fileReader = new FileReader(myFile);


                        BufferedReader bufferedReader = new BufferedReader(fileReader);

                        System.out.println("Okunan veriler yazdırılıyor..\n");
                        while ((line = bufferedReader.readLine()) != null) {        //Dosyadan veri okuma işlemleri..
                            //Verileri satır satır okuyoruz.

                            System.out.println(line);  //Yazdır

                        }
                        System.out.println("\n");
                        bufferedReader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default: exit=false;
                break;
            }
        }
    }
}

