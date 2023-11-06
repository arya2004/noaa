package com.codeconnectx.codeconnectx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeconnectx.codeconnectx.model.Assignment;
import com.codeconnectx.codeconnectx.service.AssignmentService;

@RestController
//@RequestMapping("/")
public class AssignmentController {
    
    @Autowired
    private AssignmentService service1;

    @PostMapping("/classroom/{classroomid}/assignment")
    public ResponseEntity<String> saveAssignment(@RequestBody Assignment assignment,@PathVariable("classroomid") String classroomid) {
        
        if(assignment != null){
            System.out.println(assignment);
        }
        boolean result = service1.saveAssignment(assignment,classroomid);
        // System.out.println("test");
        if(result)
            return ResponseEntity.ok("Assignment Created Successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/classroom/{classroomid}/assignment")
    public ResponseEntity<List<Object>> fetchAllAssignment(@PathVariable("classroomid") String classroomid) {
        List<Object> assignments;
        assignments = service1.fetchAllAssignment(classroomid);
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/classroom/{classroomid}/assignment/{id}")
    public ResponseEntity<Object> fetchAssignmentById(@PathVariable("id") Long id,@PathVariable("classroomid") String classroomid) {
        Object assignment;
        assignment = service1.fetchAssignmentById(id,classroomid);
        return ResponseEntity.ok(assignment);
    }

    @DeleteMapping("/classroom/{classroomid}/assignment/{id}")
    public ResponseEntity<String> deleteAssignment(@PathVariable("id") Long id,@PathVariable("classroomid") String classroomid) {
        boolean result = service1.deleteAssignment(id,classroomid);
        if(result)
            return ResponseEntity.ok("User deleted Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/classroom/{classroomid}/assignment/{id}")
    public ResponseEntity<String> updateAssignment(@PathVariable("classroomid") String classroomid,@PathVariable("id") Long id, @RequestBody Assignment assignment) {
        boolean result = service1.updateAssignment(id,assignment,classroomid);
        if(result)
            return ResponseEntity.ok("User Updated Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
