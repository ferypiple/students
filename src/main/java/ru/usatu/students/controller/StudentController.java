package ru.usatu.students.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.usatu.students.model.Student;
import ru.usatu.students.service.StudentService;
import java.util.List;

/*класс контроллера отвечает за обработку входящих запросов REST API,
подготовку модели и возврат представления для отображения в качестве ответа */
//@RestController в Spring по сути представляют собой просто комбинацию @Controller и @ResponseBody
@CrossOrigin
@RestController
//@RequestMapping Это одна из основных аннотаций в Spring, которая сопоставляет HTTP-запросы (URL-адреса) с методами
@RequestMapping("/students")
public class StudentController {
    //Приватная костанта нужная для снижения прямой зависимости от классов обработчиков
    private final StudentService studentService;
    //Конструктор необходимый для снижения прямой зависимости от классов обработчиков
    //@Qualifer нужен для однозначного определения от какого класса обработчика идет реализация
    public StudentController(@Qualifier("studentServiceXML") StudentService studentService) {
        this.studentService= studentService;
    }
    //@GetMapping-Обрабатывает get-запросы
    @GetMapping
    //Аннотация @ResponseBody ставится на методы, которые работают с данными, а не с моделями.
    // Ее не требуется указывать явно, если используется @RestController.
    public @ResponseBody
    //Обрабатывает всех студентов
    List<Student> getStudents() throws Exception {
        return studentService.getStudents(); }
    //@GetMapping-Обрабатывает get-запросы
    @GetMapping("/{id}")
    //Аннотация @ResponseBody ставится на методы, которые работают с данными, а не с моделями.
    public @ResponseBody
    //Обрабатывает одного студента
    //аннотацию @PathVariable можно использовать для обработки переменных шаблона в отображении URI запроса и использовать их в качестве параметров метода.
    Student getStudent(@PathVariable int id) throws Exception {return studentService.getStudent(id);}
    //@PostMapping — Обрабатывает post-запросы
    @PostMapping
    //Аннотация @ResponseBody ставится на методы, которые работают с данными, а не с моделями.
    public @ResponseBody
    //Вы можете использовать аннотацию @RequestBody на параметре метода, для того чтобы тело запроса конвертировалось в этот параметр.
    Student addStudent(@RequestBody Student student) throws Exception {return studentService.addStudent(student);}
    //@PutMapping — Обрабатывает put-запросы
    @PutMapping("/{id}")
    //Аннотация @ResponseBody ставится на методы, которые работают с данными, а не с моделями.
    public @ResponseBody
    //аннотацию @PathVariable можно использовать для обработки переменных шаблона в отображении URI запроса и использовать их в качестве параметров метода.
    //Вы можете использовать аннотацию @RequestBody на параметре метода, для того чтобы тело запроса конвертировалось в этот параметр.
    Student editStudent(@PathVariable int id, @RequestBody String name) throws Exception {return studentService.editStudent(id,name);}
    //@DeleteMapping — Обрабатывает delete-запросы
    @DeleteMapping("/{id}")
    //Она позволяет устанавливать код ответа. Обычно Spring сам устанавливает нужный код ответа, но бывают моменты, когда это нужно переопределить.
    @ResponseStatus(HttpStatus.OK)
    //аннотацию @PathVariable можно использовать для обработки переменных шаблона в отображении URI запроса и использовать их в качестве параметров метода.
    public void deleteStudent(@PathVariable int id) throws Exception { studentService.deleteStudent(id);}
}
