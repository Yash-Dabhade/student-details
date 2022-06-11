package com.example.studentdatabase;

public class student {
    private String rollno,marks;
    private String name,branch;
    private String percentage;


    public student(String rollno, String name, String branch, String marks, String percentage) {
        this.rollno = rollno;
        this.marks = marks;
        this.name = name;
        this.branch = branch;
        this.percentage = percentage;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
