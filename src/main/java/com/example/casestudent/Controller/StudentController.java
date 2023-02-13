package com.example.casestudent.Controller;


import com.example.casestudent.Models.StudentModel;
import com.example.casestudent.Models.StudentQueryModel;
import com.example.casestudent.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/getStudents/")
    private Page<StudentModel> getStudents(Pageable pageable, @RequestBody StudentQueryModel studentQueryModel){
        return  studentService.getStudents(pageable,studentQueryModel);
    }
}
