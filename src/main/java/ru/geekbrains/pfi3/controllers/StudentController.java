package ru.geekbrains.pfi3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.pfi3.entities.Student;
import ru.geekbrains.pfi3.servises.StudentServise;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentServise studentServise;

    @GetMapping()
    public List<Student> getAll (){
        return studentServise.findAll();
    }

    @PostMapping("/add")
    public void putStudent(@RequestParam String name,
                           @RequestParam int age){
        System.out.println("name = " + name + " age = " + age);
        studentServise.addStudent(new Student(name,age));
    }

    @ResponseBody
    @GetMapping("/{name}")
    public Student findStudent (@PathVariable String name){
        return studentServise.findByName(name);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteStudent (@PathVariable String name){
        studentServise.delete(name);
    }

    @PutMapping
    public void updateStudent(@RequestParam String name,
                              @RequestParam int age){
        studentServise.updateStudent(new Student(name,age));
    }

}
