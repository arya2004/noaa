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

    @PostMapping("/assignment")
    public ResponseEntity<String> saveAssignment(@RequestBody Assignment assignment) {
        
        if(assignment != null){
            System.out.println(assignment);
        }
        boolean result = service1.saveAssignment(assignment);
        // System.out.println("test");
        if(result)
            return ResponseEntity.ok("Assignment Created Successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/assignment")
    public ResponseEntity<List<Assignment>> fetchAllAssignment() {
        List<Assignment> assignments;
        assignments = service1.fetchAllAssignment();
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/assignment/{id}")
    public ResponseEntity<Assignment> fetchAssignmentById(@PathVariable("id") Long id) {
        Assignment assignment;
        assignment = service1.fetchAssignmentById(id);
        return ResponseEntity.ok(assignment);
    }

    @DeleteMapping("/assignment/{id}")
    public ResponseEntity<String> deleteAssignment(@PathVariable("id") Long id) {
        boolean result = service1.deleteAssignment(id);
        if(result)
            return ResponseEntity.ok("User deleted Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/assignment/{id}")
    public ResponseEntity<String> updateAssignment(@PathVariable("id") Long id, @RequestBody Assignment assignment) {
        boolean result = service1.updateAssignment(id,assignment);
        if(result)
            return ResponseEntity.ok("User Updated Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
