package SE_Lab7_Question1;

import java.util.HashSet;

public class Employee {
    private String id;
    private String name;
    private String phone;
    private HashSet<Permit> permits;

    public Employee(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.permits = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HashSet<Permit> getPermits() {
        return permits;
    }

    public void setPermits(HashSet<Permit> permits) {
        this.permits = permits;
    }

    public void addPermit(Permit permit){
        this.permits.add(permit);
    }
    public void deletePermit(Permit permit){
        this.permits.remove(permit);
    }

    @Override
    public String toString() {
        return "\n\tEmployee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                "}";
    }
}
