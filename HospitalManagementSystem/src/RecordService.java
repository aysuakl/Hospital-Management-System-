import java.util.ArrayList;
import java.util.List;

public class RecordService<T> {
    private List<User<T>> users;

    public RecordService() {
        this.users = new ArrayList<>();
    }

    public void addUser(User<T> user) {
        users.add(user);
    }

    public void addRecord(User<T> user, T record) {
        user.addRecord(record);
    }

    public void displayRecords(User<T> user) {
        System.out.println(user.getName() + " için Kayıtlar:");
        List<T> records = user.getRecords();
        for (T record : records) {
            System.out.println(record);
        }
        System.out.println("------------------------");
    }

    public List<User<T>> getUsers() {
        return users;
    }

    public void addRecordToAllUsers(T record) {
        for (User<T> user : users) {
            user.addRecord(record);
        }
    }
}