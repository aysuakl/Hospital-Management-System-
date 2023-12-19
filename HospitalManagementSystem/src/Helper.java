import java.util.ArrayList;
import java.util.Scanner;

public class Helper {

    public static boolean isValidTcNumber(String tcNumber) {
        if (tcNumber == null || tcNumber.length() != 11) {
            System.out.println("Hata: TC Kimlik numarası 11 basamaklı olmalıdır.");
            return false;
        }

        for (char c : tcNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                System.out.println("Hata: TC Kimlik numarası sadece sayılardan oluşmalıdır.");
                return false;
            }
        }

        return true;
    }

    public static boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            System.out.println("Hata: Şifre en az 8 karakterden oluşmalıdır.");
            return false;
        }
        return true;
    }

    public static int getMenuChoice(Scanner scanner, int maxChoice) {
        int choice = -1;

        do {
            System.out.print("Seçiminizi yapın (1-" + maxChoice + "): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Geçersiz giriş. Lütfen bir sayı girin: ");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < 1 || choice > maxChoice);

        return choice;
    }

    private static Bashekim findBashekimById(ArrayList<Bashekim> bashekimList, int selectedBashekimId) {
        for (Bashekim bashekim : bashekimList) {
            if (bashekim.getId() == selectedBashekimId) {
                return bashekim;
            }
        }
        return null;
    }

    public static void muayeneSonucuEkle(ArrayList<Bashekim> bashekimList, Scanner scanner) {
        System.out.print("Hangi başhekimin muayene sonucu eklemek istersiniz? (Başhekim ID): ");
        int selectedBashekimId = scanner.nextInt();

        Bashekim selectedBashekim = findBashekimById(bashekimList, selectedBashekimId);

        if (selectedBashekim != null) {
            if (selectedBashekim.getAppointmentService() != null) {
                System.out.print("Hasta Adı: ");
                String hastaAdi = scanner.next();

                System.out.print("Hasta TC No: ");
                String tcNo = scanner.next();

                System.out.print("Muayene Notu: ");
                String muayeneNotu = scanner.next();

                MuayeneSonucu muayeneSonucu = new MuayeneSonucu(hastaAdi, tcNo, muayeneNotu);

                if (!selectedBashekim.getAppointmentService().hasRecord(selectedBashekim, muayeneSonucu)) {
                    selectedBashekim.getAppointmentService().addRecord(selectedBashekim, muayeneSonucu);
                    selectedBashekim.getAppointmentService().displayRecords(selectedBashekim);
                    System.out.println("Muayene sonucu başarıyla eklendi.");
                } else {
                    System.out.println("Aynı TC No'ya sahip muayene sonucu zaten mevcut. Eklenemedi.");
                }
            } else {
                System.out.println("Belirtilen başhekim için bir AppointmentService bulunamadı.");

                // Eğer belirtilen başhekim için AppointmentService bulunamazsa, yeni bir AppointmentService oluşturabilirsiniz.
                selectedBashekim.setAppointmentService(new AppointmentService());
                System.out.println("Yeni bir AppointmentService oluşturuldu.");
            }
        } else {
            System.out.println("Belirtilen ID'ye sahip başhekim bulunamadı.");
        }
    }

    public static void doktorEkle(ArrayList<Bashekim> bashekimList, Scanner scanner) {
        System.out.print("Hangi başhekimin listesine yeni doktor eklemek istersiniz? (Başhekim ID): ");
        int selectedBashekimId = scanner.nextInt();

        Bashekim selectedBashekim = findBashekimById(bashekimList, selectedBashekimId);

        if (selectedBashekim != null) {
            System.out.println("Yeni doktor bilgilerini girin:");

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("TC No: ");
            String tcno = scanner.nextLine();

            System.out.print("Adı: ");
            String name = scanner.nextLine();

            System.out.print("Şifre: ");
            String password = scanner.nextLine();

            System.out.print("Tipi: ");
            String type = scanner.nextLine();

            User<MuayeneSonucu> newDoctor = new User<>(id, tcno, name, password, type);
            selectedBashekim.addDoctor(newDoctor);

            System.out.println("Yeni doktor başarıyla eklendi.");
        } else {
            System.out.println("Belirtilen ID'ye sahip başhekim bulunamadı.");
        }
    }

    public static void displayAllDoctors(ArrayList<Bashekim> bashekimList) {
        System.out.println("Tüm Başhekimlerin Doktor Listeleri:");
        for (Bashekim bashekim : bashekimList) {
            bashekim.displayDoctors();
        }
    }

    public static void displayDoctorsOfAllBashekim(ArrayList<Bashekim> bashekimList) {
        System.out.println("Tüm Başhekimlerin Doktor Listeleri:");
        for (Bashekim bashekim : bashekimList) {
            System.out.println("Başhekim ID: " + bashekim.getId());
            System.out.println("Başhekim Adı: " + bashekim.getName());
            bashekim.displayDoctors();
        }
    }

    public static void displayAllDoctorsWithMenu(ArrayList<Bashekim> bashekimList, Scanner scanner) {
        System.out.println("Tüm Başhekimlerin Doktor Listeleri:");
        for (Bashekim bashekim : bashekimList) {
            System.out.println("Başhekim ID: " + bashekim.getId());
            System.out.println("Başhekim Adı: " + bashekim.getName());
        }

        System.out.print("Hangi Başhekimin doktor listesini görmek istersiniz? (Başhekim ID): ");
        int selectedBashekimId = scanner.nextInt();

        Bashekim selectedBashekim = findBashekimById(bashekimList, selectedBashekimId);

        if (selectedBashekim != null) {
            selectedBashekim.displayDoctors();
        } else {
            System.out.println("Belirtilen ID'ye sahip başhekim bulunamadı");
        }
    }
}