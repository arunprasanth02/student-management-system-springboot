package com.studentmanagement.spring.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentss")
public class Student {

    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int srollno;

    @jakarta.persistence.Column(name = "sname", nullable = false)
    private String sname;


    
    @jakarta.persistence.Column(name = "email", nullable = false)
    private String email;

    @jakarta.persistence.Column(name = "location", nullable = false)
    private String location;

    public Student() {
    }

    public Student(String sname, String email, String location) {
        
        this.sname = sname;
        this.email = email;
        this.location = location;
    }

    public int getSrollno() {
        return srollno;
    }

    public void setSrollno(int srollno) {
        this.srollno = srollno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Student [srollno=" + srollno + ", sname=" + sname + ", email=" + email + ", location=" + location + "]";
    }

	

    

    
    


}

