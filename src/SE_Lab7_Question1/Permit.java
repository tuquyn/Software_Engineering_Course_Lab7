package SE_Lab7_Question1;

public class Permit {
    private String permitNr;
    private String regNr;
    private Employee owner;
    private String area;

    public Permit(String permitNr, String regNr, Employee owner) {
        this.permitNr = permitNr;
        this.regNr = regNr;
        this.owner = owner;
        this.area = null;
    }
    public Permit(String permitNr, String regNr, String area,  Employee owner) {
        this.permitNr = permitNr;
        this.regNr = regNr;
        this.owner = owner;
        this.area = area;
    }

    public String getPermitNr() {
        return permitNr;
    }

    public void setPermitNr(String permitNr) {
        this.permitNr = permitNr;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "\n\tPermit{" +
                "permitNr='" + permitNr + '\'' +
                ", regNr='" + regNr + '\'' +
                ", " + owner +
                "}";
    }
}
