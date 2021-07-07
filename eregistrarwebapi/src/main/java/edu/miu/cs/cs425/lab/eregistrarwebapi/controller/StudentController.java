package edu.miu.cs.cs425.lab.eregistrarwebapi.controller;

import edu.miu.cs.cs425.lab.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.lab.eregistrarwebapi.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = {"/eregistrar/api/student"})
@CrossOrigin(origins = {"http://127.0.0.1:5500/", "http://localhost:5500/"}, allowedHeaders = "*")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @GetMapping(value = {"/list"})
    public List<Student> listStudent(){
        return studentService.getStudents();
    }
    @GetMapping(value = {"/get/{studentId}"})
    public Student getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }
    @PostMapping(value = {"/add"})
    public Student addNewStudent(@Valid @RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @PutMapping(value = {"/update/{studentId}"})
    public Student updateStudent(@Valid @RequestBody Student editedStudent,@PathVariable Long  studentId){
        return studentService.updateStudentById(editedStudent, studentId);
   }
   @DeleteMapping(value = {"/delete/{studentId}"})
   public void deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudentById(studentId);
   }
}
