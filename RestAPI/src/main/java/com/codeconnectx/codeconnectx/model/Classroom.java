package com.codeconnectx.codeconnectx.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Classroom implements Serializable{
    private Long classroomid;
    private String name;
    private String description;
    private String teacherkey;
}
