package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    // http://localhost:8080/student
//    @GetMapping("student")
//    public Student getStudent() {
//        Student student = new Student("Claudia","Ramirez", 1);
//        return student;
//    }

    // Spring Boot ResponseEntity
    @GetMapping("student")
    public ResponseEntity <Student> getStudent() {
        Student student = new Student("Claudia","Ramirez", 1);
        //return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header", "claudia")
                .body(student);
    }

    // http://localhost:8080/students
//    @GetMapping("students")
//    public List<Student> getStudents() {
//        List<Student> students = new ArrayList<>();
//        students.add(new Student("Tatiana", "Lopez", 1));
//        students.add(new Student("Paola", "Garcia", 2));
//        students.add(new Student("Maria", "Cueva", 3));
//        students.add(new Student("Gozde", "Salas", 4));
//        return students;
//    }

    // Spring Boot ResponseEntity
    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tatiana", "Lopez", 1));
        students.add(new Student("Paola", "Garcia", 2));
        students.add(new Student("Maria", "Cueva", 3));
        students.add(new Student("Gozde", "Salas", 4));
        return ResponseEntity.ok(students);
    }

    // Spring Boot Rest API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/students/3/Maria/Cueva
//    @GetMapping("students/{id}/{first-name}/{last-name}")
//    public Student studentPathVariable(@PathVariable("id") int id,
//                                       @PathVariable("first-name") String firstName,
//                                       @PathVariable("last-name") String lastName) {
//        return new Student(firstName, lastName, id);
//    }

    // Spring Boot ResponseEntity
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int id,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        Student student = new Student(firstName, lastName, id);
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API with Request Param
    //http://localhost:8080/students/query?id=1&firstName=Maria&lastName=Cueva
//    @GetMapping("students/query")
//    public Student studentRequestVariable(@RequestParam int id,
//                                          @RequestParam String firstName,
//                                          @RequestParam String lastName) {
//        return new Student(firstName, lastName, id);
//    }

    // Spring Boot ResponseEntity
    @GetMapping("students/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
       Student student = new Student(firstName, lastName, id);
       return ResponseEntity.ok(student);
    }

    // Spring Boot Rest API that handles HTTP POST Request - creating new resource
    // @PostMapping and @RequestBody
//    @PostMapping("students/create")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Student createStudent(@RequestBody Student student) {
//        System.out.println(student.getId());
//        System.out.println(student.getFirstName());
//        System.out.println(student.getLastName());
//        return student;
//    }

    // Spring Boot ResponseEntity
    @PostMapping("students/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Spring boot REST API that handles HTTP PUT Request - updating existing resource
    // Spring Boot ResponseEntity
//    @PutMapping("students/{id}/update")
//    public Student updateStudent(@RequestBody Student student, @PathVariable int id) {
//        System.out.println(student.getFirstName());
//        System.out.println(student.getLastName());
//        return student;
//    }

    @PutMapping("students/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }


    // Spring Boot REST API that handles HTTP DELETE Request - deleting the existing resource
//    @DeleteMapping("students/{id}/delete")
//    public String deleteStudent(@PathVariable int id) {
//        System.out.println(id);
//        return "Student deleted successfully";
//    }

    @DeleteMapping("students/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        System.out.println(id);
        return ResponseEntity.ok("Student deleted successfully");
    }

}
