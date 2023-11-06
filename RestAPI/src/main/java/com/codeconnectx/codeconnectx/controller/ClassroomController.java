package com.codeconnectx.codeconnectx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeconnectx.codeconnectx.model.Classroom;
import com.codeconnectx.codeconnectx.model.Testcase;
import com.codeconnectx.codeconnectx.service.AssignmentService;

@RestController
public class ClassroomController {
    
    @Autowired
    AssignmentService service;

    @PostMapping("/classroom")
    public ResponseEntity<String> saveClassroom(@RequestBody Classroom classroom){
        boolean result = service.saveClassroom(classroom);
        if(result){
            return ResponseEntity.ok("classroom created");
        }else{
            return ResponseEntity.ok("Couldnt save the classroom");
        }
    }

    @GetMapping("/classroom")
    public ResponseEntity<List<Object>> fetchAllClassrooms(){
        List<Object> result = service.fetchAllClassrooms();
        
        return ResponseEntity.ok(result);
    }

    @GetMapping("/classroom/{class_id}")
    public ResponseEntity<Object> fetchClassroomById(@PathVariable("class_id") String class_id){
        Object result = service.fetchClassroomById(class_id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/classroom/{class_id}")
    public ResponseEntity<String> deleteClassroom(@PathVariable("class_id") String class_id){
        
        boolean result = service.deleteClassroom(class_id);
        if(result){
            return ResponseEntity.ok("classrom deleted successfully");
        }else{
            return ResponseEntity.ok("Cannot delete  classroom");
        }
         
    }

}
