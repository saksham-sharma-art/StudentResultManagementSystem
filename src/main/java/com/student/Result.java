package com.student;

public class Result {
    private int rollNo;
    private double math;
    private double science;
    private double english;

    public Result(int rollNo, double math, double science, double english) {
        this.rollNo = rollNo;
        this.math = math;
        this.science = science;
        this.english = english;
    }

    public double getTotal() {
        return math + science + english;
    }

    public double getAverage() {
        return getTotal() / 3;
    }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else return "D";
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo +
                ", Total: " + getTotal() +
                ", Average: " + getAverage() +
                ", Grade: " + getGrade();
    }

    public int getRollNo() { return rollNo; }
    public double getMath() { return math; }
    public double getScience() { return science; }
    public double getEnglish() { return english; }
}