package com.student;

import java.sql.*;

public class DatabaseManager implements AutoCloseable {
    private Connection conn;

    public DatabaseManager() throws Exception {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "1806");
    }

    public void addStudent(Student s) throws SQLException {
        String sql = "INSERT INTO students VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, s.getRollNo());
        ps.setString(2, s.getName());
        ps.executeUpdate();
    }

    public void addResult(Result r) throws SQLException {
        String sql = "INSERT INTO results VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, r.getRollNo());
        ps.setDouble(2, r.getMath());
        ps.setDouble(3, r.getScience());
        ps.setDouble(4, r.getEnglish());
        ps.executeUpdate();
    }

    public void showAllStudents() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");
        while (rs.next()) {
            System.out.println(rs.getInt("roll_no") + " - " + rs.getString("name"));
        }
    }

    public void showResult(int rollNo) throws SQLException {
        String sql = "SELECT * FROM results WHERE roll_no = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, rollNo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Result r = new Result(
                    rollNo,
                    rs.getDouble("math"),
                    rs.getDouble("science"),
                    rs.getDouble("english")
            );
            System.out.println(r);
        } else {
            System.out.println("Result not found for roll no " + rollNo);
        }
    }

    public void updateMarks(int rollNo, double newMath, double newScience, double newEnglish) throws SQLException {
        String sql = "UPDATE results SET math = ?, science = ?, english = ? WHERE roll_no = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, newMath);
        ps.setDouble(2, newScience);
        ps.setDouble(3, newEnglish);
        ps.setInt(4, rollNo);
        ps.executeUpdate();
    }

    public void deleteStudent(int rollNo) throws SQLException {
        conn.prepareStatement("DELETE FROM results WHERE roll_no = " + rollNo).executeUpdate();
        conn.prepareStatement("DELETE FROM students WHERE roll_no = " + rollNo).executeUpdate();
    }

    public void close() throws SQLException {
        conn.close();
    }
}