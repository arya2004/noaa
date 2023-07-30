package com.codeconnectx.codeconnectx.service;

import com.codeconnectx.codeconnectx.model.Assignment;

import java.util.List;

public interface Service1 {
    boolean saveAssignment(Assignment assignment);

    List<Assignment> fetchAllAssignment();

    Assignment fetchAssignmentById(Long id);

    boolean deleteAssignment(Long id);

    boolean updateAssignment(Long id, Assignment assignment);
}
