package ru.usatu.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.usatu.students.model.Student;
//Эта аннотация используется в классах Java, которые напрямую обращаются к базе данных.
// В  @Repository аннотации работает как маркер для любого класса , который выполняет роль хранилища или доступ к данным объекта.
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
