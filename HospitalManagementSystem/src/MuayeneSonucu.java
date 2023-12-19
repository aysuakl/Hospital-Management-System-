import java.util.Objects;

public class MuayeneSonucu {
    private String hastaAdi;
    private String tcNo;
    private String muayeneNotu;

    public MuayeneSonucu(String hastaAdi, String tcNo, String muayeneNotu) {
        this.hastaAdi = hastaAdi;
        this.tcNo = tcNo;
        this.muayeneNotu = muayeneNotu;
    }

    public String getHastaAdi() {
        return hastaAdi;
    }

    public void setHastaAdi(String hastaAdi) {
        this.hastaAdi = hastaAdi;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getMuayeneNotu() {
        return muayeneNotu;
    }

    public void setMuayeneNotu(String muayeneNotu) {
        this.muayeneNotu = muayeneNotu;
    }

    @Override
    public String toString() {
        return "MuayeneSonucu{" +
                "hastaAdi='" + hastaAdi + '\'' +
                ", tcNo='" + tcNo + '\'' +
                ", muayeneNotu='" + muayeneNotu + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MuayeneSonucu that = (MuayeneSonucu) o;
        return tcNo.equals(that.tcNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tcNo);
    }
}