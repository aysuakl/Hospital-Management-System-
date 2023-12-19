import java.util.ArrayList;
import java.util.List;

public class User<T> {
    private int id;
    private String tcNo;
    private String name;
    private String password;
    private String type;
    private List<T> records;

    public User(int id, String tcNo, String name, String password, String type) {
        this.id = id;
        this.tcNo = tcNo;
        this.name = name;
        this.password = password;
        this.type = type;
        this.records = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public void addRecord(T record) {
        records.add(record);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", tcNo='" + tcNo + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", records=" + records +
                '}';
    }
}