package pojo.classes;

public class Employee {

    String fname;
    String lname;

    double salary;
    String profession;
    String department;

    public Employee() {

    }

    public Employee(String fname, String lname, double salary, String profession, String department) {
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
        this.department = department;
        this.profession = profession;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}