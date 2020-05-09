package com.pojo.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import pojo.classes.Address;
import pojo.classes.Employee;
import pojo.classes.Sample;
import pojo.classes.Student;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class AppTest {

    private Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
    private String json;

    @Test
    public void toJson() {
        System.out.println("LEARNING GSON TO SERIALIZE");

        Employee e = new Employee("Sanket", "Sarode", 40000.00, "Java Developer", "Computer Science");
        Employee e1 = new Employee();
        e1.setFname("Rahul");
        e1.setLname("Roy");
        e1.setSalary(35000.00);
        e1.setProfession("PHP Developer");
        e1.setDepartment("Computer Science");

        System.out.println(gson.toJson(e));
        System.out.println(gson.toJson(e1));
    }

    @Test
    public void fromJson() {
        System.out.println("LEARNING GSON TO DESERIALIZE JSON");
        json = "{\n" +
                "  \"fname\": \"XYzzz\",\n" +
                "  \"lname\": \"Abcc\",\n" +
                "  \"salary\": 25000.0,\n" +
                "  \"profession\": \"PHP Developer\",\n" +
                "  \"department\": \"Computer Science\"\n" +
                "}";

        Employee e = gson.fromJson(json, Employee.class);
        System.out.println("Fname: " + e.getFname() + "\n" +
                "Lname: " + e.getLname() + "\n" +
                "Salary: " + e.getSalary() + "\n" +
                "Profession: " + e.getProfession() + "\n" +
                "Department: " + e.getDepartment());
    }

    @Test
    public void addressStudent_toJson() {
        System.out.println("LEARNING CLASS WITHIN OTHER CLASS - JSON WITHIN JSON - SERIALIZE");

        Student s = new Student();
        Address addr = new Address();

        addr.setHouseNumber(5);
        addr.setStreet("Avenue St");
        addr.setState("MH");
        addr.setCountry("IN");
        addr.setZip_code(431001);

        s.setFname("Ashish");
        s.setLname("ZoYa");
        s.setDepartment("Social Science");
        s.setAddress(addr);

        Address addr1 = new Address("IN", "MH", 452154, "Ave Street", 6);
        Student std = new Student("Suraj", "Rana", "Physics", addr1);

        System.out.println(gson.toJson(s));
        System.out.println(gson.toJson(std));
    }

    @Test
    public void addressStudent_fromJson() {
        System.out.println("LEARNING CLASS WITHIN OTHER CLASS - JSON WITHIN JSON - DESERIALIZE");
        json = "{\n" +
                "  \"fname\": \"Abhay\",\n" +
                "  \"lname\": \"Singh\",\n" +
                "  \"department\": \"Chemistry\",\n" +
                "  \"address\": {\n" +
                "    \"country\": \"IN\",\n" +
                "    \"state\": \"MH\",\n" +
                "    \"zip_code\": 452154,\n" +
                "    \"street\": \"Ave Street\",\n" +
                "    \"houseNumber\": 6\n" +
                "  }\n" +
                "}";
        Student std = gson.fromJson(json, Student.class);
        Address addr = std.getAddress();

        System.out.println("Student: " + "\n" +
                "Fname: " + std.getFname() + "\n" +
                "Lname: " + std.getLname() + "\n" +
                "Department: " + std.getDepartment() + "\n" +
                "Address: " + "\n" +
                "House#: " + addr.getHouseNumber() + "\n" +
                "Street: " + addr.getStreet() + "\n" +
                "State: " + addr.getState() + "\n" +
                "Country: " + addr.getCountry() + "\n" +
                "ZipCode: " + addr.getZip_code());
    }

    @Test
    public void usingJsonFileSerialize() throws Exception {
        System.out.println("USING JSON FILE - SERIALIZE");
        Writer w = new FileWriter(System.getProperty("user.dir") + "\\src\\test\\resources\\test.json", false);
        Sample[] users = new Sample[]{
                new Sample("vuw", "uvw"),
                new Sample("qrt", "qrt")
        };
        gson.toJson(users, w);
        w.close();
    }

    @Test
    public void usingJsonFileDeSerialize_using_ArrayOfObjects() {
        System.out.println("USING JSON FILE - DESERIALIZE - using array of objects");

        try {
            Sample[] s = gson.fromJson(new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\Sample.json"), Sample[].class);
            for (Sample sam : s) {
                System.out.println("Username: " + sam.getUsername());
                System.out.println("Password: " + sam.getPassword());
            }
        } catch (Exception e) {
            System.out.println("Exception is reading file: " + e.getMessage());
        }
    }

    @Test
    public void usingJsonFileDeSerialize_using_ListOfObjects() {
        System.out.println("USING JSON FILE - DESERIALIZE - using list of objects");

        try {
            Type userList = new TypeToken<ArrayList<Sample>>() {
            }.getType();
            ArrayList<Sample> s = gson.fromJson(new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\Sample.json"), userList);
            for (Sample sam : s) {
                System.out.println("Username: " + sam.getUsername());
                System.out.println("Password: " + sam.getPassword());
            }
        } catch (Exception e) {
            System.out.println("Exception is reading file: " + e.getMessage());
        }
    }
}