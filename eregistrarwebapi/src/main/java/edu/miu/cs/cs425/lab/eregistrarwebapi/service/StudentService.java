package edu.miu.cs.cs425.lab.eregistrarwebapi.service;

import edu.miu.cs.cs425.lab.eregistrarwebapi.model.Student;

import java.awt.print.Book;
import java.util.List;

public interface StudentService {
    public abstract List<Student> getStudents();
    public abstract Student saveStudent(Student student);
    public abstract Student getStudentById(Long studentId);
    public void deleteStudentById(Long studentId);
//    public abstract List<Student> findByKeyword(String Keyword);
    public abstract Student updateStudentById(Student editedStudent, Long studentId);
}
