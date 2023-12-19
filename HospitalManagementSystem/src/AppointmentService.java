import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentService implements HealthService<MuayeneSonucu> {
    private Map<Bashekim, List<MuayeneSonucu>> muayeneSonucuMap;

    public AppointmentService() {
        this.muayeneSonucuMap = new HashMap<>();
    }

    @Override
    public void addRecord(Bashekim bashekim, String record) {
        System.out.println("Hasta için Muayene Sonucu eklenemedi. Lütfen MuayeneSonucu tipinde bir kayıt ekleyin.");
    }

    @Override
    public void addRecord(User<MuayeneSonucu> user, MuayeneSonucu record) {
        System.out.println("Bu metot sadece Bashekim tipi için kullanılabilir.");
    }

    @Override
    public void displayRecords(User<MuayeneSonucu> user) {
        System.out.println("Bu metot sadece Bashekim tipi için kullanılabilir.");
    }

    @Override
    public void addRecord(Bashekim bashekim, MuayeneSonucu muayeneSonucu) {
        if (muayeneSonucu != null) {
            muayeneSonucuMap.computeIfAbsent(bashekim, k -> new ArrayList<>()).add(muayeneSonucu);
            System.out.println("Muayene sonucu başarıyla eklendi.");
        } else {
            System.out.println("Hasta için Muayene Sonucu eklenemedi. Lütfen MuayeneSonucu tipinde bir kayıt ekleyin.");
        }
    }

    @Override
    public void displayRecords(Bashekim bashekim) {
        System.out.println(bashekim.getName() + " için Muayene Sonucu Listesi:");
        List<MuayeneSonucu> muayeneSonuclar = muayeneSonucuMap.getOrDefault(bashekim, new ArrayList<>());
        if (muayeneSonuclar.isEmpty()) {
            System.out.println("Herhangi bir muayene sonucu bulunmamaktadır.");
        } else {
            for (MuayeneSonucu muayeneSonucu : muayeneSonuclar) {
                System.out.println("Hasta Adı: " + muayeneSonucu.getHastaAdi());
                System.out.println("Hasta TC No: " + muayeneSonucu.getTcNo());
                System.out.println("Muayene Notu: " + muayeneSonucu.getMuayeneNotu());
                System.out.println("------------------------");
            }
        }
        System.out.println();
    }

    @Override
    public boolean hasRecord(Bashekim selectedBashekim, MuayeneSonucu muayeneSonucu) {
        List<MuayeneSonucu> muayeneSonuclar = muayeneSonucuMap.get(selectedBashekim);

        // Doktorun muayeneSonucuMap içinde girişi yoksa, hata mesajı ver ve false döndür.
        if (muayeneSonuclar == null) {
            System.out.println("Belirtilen doktor için appointment service bulunamadı.");
            return false;
        }

        // Muayene sonucunun doktorun muayene sonuçları arasında olup olmadığını kontrol et.
        return muayeneSonuclar.contains(muayeneSonucu);
    }
}