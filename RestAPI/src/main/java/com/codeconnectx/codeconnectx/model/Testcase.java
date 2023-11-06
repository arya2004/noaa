package com.codeconnectx.codeconnectx.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class Testcase implements Serializable{
    private Long testcaseid;
    private boolean ishidden;
    private String input_case;
    private String output_case;
}
