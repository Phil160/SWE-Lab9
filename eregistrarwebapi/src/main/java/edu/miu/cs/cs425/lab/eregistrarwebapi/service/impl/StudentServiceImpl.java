package edu.miu.cs.cs425.lab.eregistrarwebapi.service.impl;



import edu.miu.cs.cs425.lab.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.lab.eregistrarwebapi.repository.StudentRepository;
import edu.miu.cs.cs425.lab.eregistrarwebapi.service.StudentService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public void deleteStudentById(Long studentId) {
         studentRepository.deleteById(studentId);
    }
//
//    @Override
//    public List<Student> findByKeyword(String keyword) {
//        return studentRepository.findByKeyword(keyword);
//    }

    @Override
    public Student updateStudentById(Student editedStudent, Long studentId) {
        return studentRepository.findById(studentId)
                .map(studentToUpdate->{
                    studentToUpdate.setStudentNumber(editedStudent.getStudentNumber());
                    studentToUpdate.setFirstName(editedStudent.getFirstName());
                    studentToUpdate.setMiddleName(editedStudent.getMiddleName());
                    studentToUpdate.setLastName(editedStudent.getMiddleName());
                    studentToUpdate.setCgpa(editedStudent.getCgpa());
                    studentToUpdate.setEnrollmentDate(editedStudent.getEnrollmentDate());
                    studentToUpdate.setIsInternational(editedStudent.getIsInternational());
                    return studentRepository.save(studentToUpdate);
                }).orElseGet(()-> {
                    return studentRepository.save(editedStudent);
                });
    }
}
