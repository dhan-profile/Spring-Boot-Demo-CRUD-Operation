package com.mypractice.DemoCrudOperation.Others;

class University {
    private class Student {
        private int id;
        private String name, dept;

        // Constructor
        public Student(int id, String name, String dept) {
            this.id = id;
            this.name = name;
            this.dept = dept;
        }
    }

    private class Professor {
        private int id;
        private String name, dept;

        // Constructor
        public Professor(int id, String name, String dept) {
            this.id = id;
            this.name = name;
            this.dept = dept;
        }
    }

    // Getters and Setters for Student
    public Student createStudent(int id, String name, String dept) {
        return new Student(id, name, dept);
    }

    public int getStudentId(Student student) {
        return student.id;
    }

    public void setStudentId(Student student, int id) {
        student.id = id;
    }

    public String getStudentName(Student student) {
        return student.name;
    }

    public void setStudentName(Student student, String name) {
        student.name = name;
    }

    public String getStudentDept(Student student) {
        return student.dept;
    }

    public void setStudentDept(Student student, String dept) {
        student.dept = dept;
    }

    // Getters and Setters for Professor
    public Professor createProfessor(int id, String name, String dept) {
        return new Professor(id, name, dept);
    }

    public int getProfessorId(Professor professor) {
        return professor.id;
    }

    public void setProfessorId(Professor professor, int id) {
        professor.id = id;
    }

    public String getProfessorName(Professor professor) {
        return professor.name;
    }

    public void setProfessorName(Professor professor, String name) {
        professor.name = name;
    }

    public String getProfessorDept(Professor professor) {
        return professor.dept;
    }

    public void setProfessorDept(Professor professor, String dept) {
        professor.dept = dept;
    }

    public static void main(String[] args) {
        University university = new University();

        // Create a Student
        Student student = university.createStudent(1, "Haris", "Computer Science");
        System.out.println("Student ID: " + university.getStudentId(student));
        System.out.println("Student Name: " + university.getStudentName(student));
        System.out.println("Student Dept: " + university.getStudentDept(student));

        // Create a Professor
        Professor professor = university.createProfessor(101, "Dr. Nataraj", "Mathematics");
        System.out.println("Professor ID: " + university.getProfessorId(professor));
        System.out.println("Professor Name: " + university.getProfessorName(professor));
        System.out.println("Professor Dept: " + university.getProfessorDept(professor));
    }
}
