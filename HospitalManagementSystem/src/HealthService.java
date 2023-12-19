public interface HealthService<T> {
    void addRecord(Bashekim bashekim, String record);

    void addRecord(User<T> user, T record);

    void displayRecords(User<T> user);

    void addRecord(Bashekim bashekim, T muayeneSonucu);

    void displayRecords(Bashekim bashekim);

    boolean hasRecord(Bashekim selectedBashekim, MuayeneSonucu muayeneSonucu);
}