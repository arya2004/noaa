package com.codeconnectx.codeconnectx.model;

import java.io.Serializable;
import lombok.Data;
import java.util.List;

@Data
public class Assignment implements Serializable{
    private Long assignmentid;
    private String name;
    private String description;
    private String input_format;
    private String output_format;
    private List<String> input_case;
    private List<String> output_case;
    private String constraints;
    private String date_time;
    private List<String> Testcases;
}
