import java.util.ArrayList;

public class Bashekim {
    private int id;
    private String tcNo;
    private String name;
    private String password;
    private String specialization;
    private AppointmentService appointmentService;
    private ArrayList<User<MuayeneSonucu>> doctorList;

    public Bashekim(int id, String tcNo, String name, String password, String specialization) {
        this.id = id;
        this.tcNo = tcNo;
        this.name = name;
        this.password = password;
        this.specialization = specialization;
        this.appointmentService = new AppointmentService();
        this.doctorList = new ArrayList<>();
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public AppointmentService getAppointmentService() {
        return appointmentService;
    }

    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public ArrayList<User<MuayeneSonucu>> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(ArrayList<User<MuayeneSonucu>> doctorList) {
        this.doctorList = doctorList;
    }

    public void addDoctor(User<MuayeneSonucu> newDoctor) {
        doctorList.add(newDoctor);
    }

    public void displayDoctors() {
        System.out.println("Doktor Listesi - " + this.getName() + " için:");
        if (doctorList.isEmpty()) {
            System.out.println("Herhangi bir doktor eklenmemiş.");
        } else {
            for (User<MuayeneSonucu> doctor : doctorList) {
                System.out.println("Doktor ID: " + doctor.getId());
                System.out.println("Doktor Adı: " + doctor.getName());
                System.out.println("Doktor TC No: " + doctor.getTcNo());
                System.out.println("Doktor Tipi: " + doctor.getType());
                System.out.println("------------------------");
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Bashekim{" +
                "id=" + id +
                ", tcNo='" + tcNo + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", specialization='" + specialization + '\'' +
                ", appointmentService=" + appointmentService +
                ", doctorList=" + doctorList +
                '}';
    }
}