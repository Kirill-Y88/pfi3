package ru.geekbrains.pfi3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.pfi3.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {
    public Student findStudentByName (String name);
    public void deleteStudentByName (String name);

}
