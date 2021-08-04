package ru.geekbrains.pfi3.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.pfi3.entities.Student;
import ru.geekbrains.pfi3.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentServise {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAll(){
       return studentRepository.findAll();
    }

    public Student findByName(String name){
        return studentRepository.findStudentByName(name);
    }

    @Transactional
    public void delete (String name){
        studentRepository.deleteStudentByName(name);
    }

    public void addStudent (Student student){
        studentRepository.saveAndFlush(student);
    }

    public void updateStudent (Student student){
        Student studentTemp = studentRepository.findStudentByName(student.getName());
        studentTemp.setAge(student.getAge());
        studentRepository.save(studentTemp);
    }

}
