package pojo.classes;

public class Student {

    String fname;
    String lname;

    String department;

    Address address;

    public Student() {
    }

    public Student(String fname, String lname, String department, Address address) {
        this.fname = fname;
        this.lname = lname;
        this.department = department;
        this.address = address;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}