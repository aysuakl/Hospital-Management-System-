import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Bashekim> bashekimList = new ArrayList<>();

        Bashekim b = new Bashekim(101, "20235987156", "Ali Kilinc", "2023ali2023", "Heart Doctor");
        Bashekim c = new Bashekim(102, "41788987822", "Dilara Betul Erdem", "aysuyuseverim2020", "Eye Doctor");
        Bashekim d = new Bashekim(103, "31729579032", "Memed Bingul", "aysumukemmeldir", "Ears,Nose Doctor");

        bashekimList.add(b);
        bashekimList.add(c);
        bashekimList.add(d);

        boolean devam = true;

        while (devam) {
            System.out.println("Ana Menü");
            System.out.println("1. Muayene Sonucu Ekle");
            System.out.println("2. Doktor Ekle");
            System.out.println("3. Tüm Başhekimlerin Doktor Listelerini Görüntüle");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminizi yapın (1, 2, 3 veya 4): ");

            int choice = Helper.getMenuChoice(scanner, 4);

            switch (choice) {
                case 1:
                    Helper.muayeneSonucuEkle(bashekimList, scanner);
                    break;
                case 2:
                    Helper.doktorEkle(bashekimList, scanner);
                    break;
                case 3:
                    Helper.displayDoctorsOfAllBashekim(bashekimList);
                    break;
                case 4:
                    devam = false;
                    System.out.println("Programdan çıkılıyor.");
                    break;
                default:
                    System.out.println("Geçersiz seçim.");
            }

            if (devam) {
                System.out.print("Devam etmek istiyor musunuz? (E/H): ");
                String devamSecimi = scanner.next();

                if (devamSecimi.equalsIgnoreCase("H")) {
                    devam = false;
                    System.out.println("Programdan çıkılıyor.");
                }
            }
        }

        // Scanner'ı kapatmıyoruz, çünkü program devam ediyor. Program döngünüsünü kapatmak istiyorsan altı aç.
        // scanner.close();
    }
}