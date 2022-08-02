package in.ac.charusat.studentmgmtsystem.model.controller;

import in.ac.charusat.studentmgmtsystem.model.Course;
import in.ac.charusat.studentmgmtsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository CourseRepository;
//    List<Student> students = new ArrayList<>(
//            Arrays.asList(
//                    new Student(1, "Tom", "US"),
//                    new Student(2, "Harry", "Canada"),
//                    new Student(3, "Nick", "UK")
//            )
//    );

    // Mappings - URL endpoints
    // Get the list of all student
    @GetMapping("/listCourses")
    public List<Course> getAllStudents() {
        return CourseRepository.findAll();
    }

    // Get the student information
    @GetMapping("/course/{id}")
    public Course getStudent(@PathVariable Integer id) {
        return CourseRepository.findById(id).get();
    }

    // Delete the student
    @DeleteMapping("/course/{id}")
    public List<Course> deleteStudent(@PathVariable Integer id) {
        CourseRepository.delete(CourseRepository.findById(id).get());
        return CourseRepository.findAll();
    }

    // Add new student
    @PostMapping("/course")
    public List<Course> addStudent(@RequestBody Course student) {
        CourseRepository.save(student);
        return CourseRepository.findAll();
    }

    // Update the student information
    @PutMapping("/course/{id}")
    public List<Course> updateStudent(@RequestBody Course student, @PathVariable Integer id) {
        Course studentObj = CourseRepository.findById(id).get();
        studentObj.setName(student.getName());

        CourseRepository.save(studentObj);
        return CourseRepository.findAll();
    }

}
