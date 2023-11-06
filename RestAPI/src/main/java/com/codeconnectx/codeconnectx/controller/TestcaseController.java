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

import com.codeconnectx.codeconnectx.model.Testcase;
import com.codeconnectx.codeconnectx.service.AssignmentService;

@RestController
public class TestcaseController {
    
    @Autowired
    AssignmentService service;

    @PostMapping("/classroom/{classroomid}/assignment/{assign_id}/testcase")
    public ResponseEntity<String> saveTestcase(@RequestBody Testcase testcase, @PathVariable("assign_id") String assign_id, @PathVariable("classroomid") String classroomid){
        boolean result = service.saveTestcase(testcase,assign_id,classroomid);
        if(result){
            return ResponseEntity.ok("testcase created");
        }else{
            return ResponseEntity.ok("Couldnt save the testcase");
        }
    }

    @GetMapping("/classroom/{classroomid}/assignment/{assign_id}/testcase")
    public ResponseEntity<List<Object>> fetchAllTestcase(@PathVariable("assign_id") String assign_id, @PathVariable("classroomid") String classroomid){
        List<Object> result = service.fetchAllTestcase(assign_id,classroomid);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/classroom/{classroomid}/assignment/{assign_id}/testcase/{testcaseid}")
    public ResponseEntity<Object> fetchTestcaseById(@PathVariable("assign_id") String assign_id,@PathVariable("testcaseid") String testcaseid, @PathVariable("classroomid") String classroomid){
        Object result = service.fetchTestcaseById(assign_id,testcaseid,classroomid);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/classroom/{classroomid}/assignment/{assign_id}/testcase/{testcaseid}")
    public ResponseEntity<String> deleteTestcase(@PathVariable("assign_id") String assign_id,@PathVariable("testcaseid") String testcaseid, @PathVariable("classroomid") String classroomid){
        
        boolean result = service.deleteTestcase(assign_id,testcaseid,classroomid);
        if(result){
            return ResponseEntity.ok("testcase deleted successfully");
        }else{
            return ResponseEntity.ok("Cannot delete  testcase");
        }
         
    }
    
}
