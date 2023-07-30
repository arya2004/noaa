package com.codeconnectx.codeconnectx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeconnectx.codeconnectx.model.Assignment;
import com.codeconnectx.codeconnectx.repository.AssignmentDao;

import java.util.List;

@Service
public class Serviceimpl implements Service1{
    
    @Autowired
    private AssignmentDao dao;

    @Override
    public boolean saveAssignment(Assignment assignment){
        return dao.saveAssignment(assignment);
    }

    @Override
    public List<Assignment> fetchAllAssignment() {
        return dao.fetchAllAssignment(); 
    }

    @Override
    public Assignment fetchAssignmentById(Long id){
        return dao.fetchAssignmentById(id);
    }

    @Override
    public boolean deleteAssignment(Long id){
        return dao.deleteAssignment(id);
    }

    @Override
    public boolean updateAssignment(Long id, Assignment assignment){
        return dao.updateAssignment(id, assignment);
    }

}
