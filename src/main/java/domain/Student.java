package domain;
//Student sınıfı, bir öğrencinin adını, soyadını, numarasını ve bölümünü içerecektir.

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "firstname",nullable = false)
    private String name;

    @Column(name = "lastname",nullable = false)
    private String surname;


    private int studentNumber;

    @Column(name = "student_department",nullable = false)
    private String department;


    @ManyToMany
    @JoinTable(
            name = "t_students_and_courses",
            joinColumns = {@JoinColumn(name = "std_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    List<Course> courseList=new ArrayList<>();

    //Getter-Setter


    public Long getId() {
        return Id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentNumber=" + studentNumber +
                ", department='" + department + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
