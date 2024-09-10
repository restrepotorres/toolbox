package com.toolbox.toolbox.persistance.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    private int id;
    private String name;
    //private List<Subject> prerequisites;
    //private List<Subject> corequisites;
    private int credits;
    private int semester;
    private int version;
    private String summary;
    private int hoursWeek;
}
