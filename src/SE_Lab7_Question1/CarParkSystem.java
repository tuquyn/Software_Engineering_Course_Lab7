package SE_Lab7_Question1;

import java.util.HashSet;

public class CarParkSystem {
    private HashSet<Employee>employeeList;
    private HashSet<Permit>permitList;

    public CarParkSystem() {
        this.employeeList = new HashSet<Employee>();
        this.permitList = new HashSet<Permit>();
    }
    private Employee employeeSearch(String id){
        for(Employee e : employeeList){
            if(e.getId() == id) return e;
        }
        return null;
    }
    public void addEmployee(String id, String name, String phone){
        Employee e = new Employee(id, name, phone);
        if(employeeSearch(id) != null) {
            System.out.println("Add employee error");
            return;
        }
        employeeList.add(e);
    }
    public void addEmployee(Employee e){
        if(employeeSearch(e.getId()) != null) {
            System.out.println("Add employee error");
            return;
        }
        employeeList.add(e);
    }
    public void deleteEmployee(String id){
        Employee e = employeeSearch(id);
        if(e == null){
            System.out.println("Delete employee error");
            return;
        }
        employeeList.remove(e);
        for(Permit p : e.getPermits()){
            permitList.remove(p);
        }
    }
    public void changeNumberEmployee(String id, String phone){
        Employee e = employeeSearch(id);
        if(e == null) {
            System.out.println("Change number employee error");
            return;
        }
        deleteEmployee(id);
        e.setPhone(phone);
        addEmployee(e);
    }
    private Permit permitSearch(String permitNr, String regNr){
        if(permitNr != null)
            for(Permit p : permitList){
                if(p.getPermitNr() == permitNr) return p;
            }
        if(regNr != null)
            for(Permit p: permitList){
                if(p.getRegNr() == regNr) return p;
            }
        return null;
    }
    public void addPermit(String permitNr, String regNr, String id){
        Employee e = employeeSearch(id);
        if(permitSearch(permitNr, regNr) != null || e == null || e.getPermits().size() >= 2) {
            System.out.println("Add permit error");
            return;
        }
        Permit p = new Permit(permitNr, regNr, e);
        permitList.add(p);
        employeeList.remove(e);

        e.addPermit(p);
        employeeList.add(e);
    }
    public void terminatePermit(String permitNr){
        Permit p = permitSearch(permitNr, null);
        if(p == null){
            System.out.println("Terminate permit error");
            return;
        }

        permitList.remove(p);
        p.getOwner().deletePermit(p);
    }
    public void replacePermit(String oldPermitNr, String newPermitNr, String regNr, String area){
        Permit oldPermit = permitSearch(oldPermitNr, null);
        if(oldPermit == null || permitSearch(newPermitNr, null) != null || permitSearch(null, regNr) != null){
            System.out.println("Replace permit error");
            return;
        }
        Employee owner = oldPermit.getOwner();
        Permit p = new Permit(newPermitNr, regNr, area, owner);
        permitList.remove(oldPermit);
        permitList.add(p);

        employeeList.remove(owner);
        owner.deletePermit(oldPermit);
        owner.addPermit(p);
        employeeList.add(owner);
    }
    public void printOwnerPermit(String permitNr){
        Permit p = permitSearch(permitNr, null);
        if(p == null){
            System.out.println("print owner error");
            return;
        }
        System.out.println(p.getOwner());
    }
    public void printAllPermits(){
        if(permitList.size() == 0){
            System.out.println("No permit exists");
            return;
        }
        for(Permit p : permitList){
            System.out.println(p);
        }
    }

    @Override
    public String toString() {
        return "CarParkSystem{\n" +
                "employeeList=" + employeeList +
                ", \npermitList=" + permitList +
                "}\n";
    }
}
