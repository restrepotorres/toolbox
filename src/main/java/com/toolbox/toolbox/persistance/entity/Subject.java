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
    //Generated value?
    @Id
    private String id;
    private String name;
    private List<String> prerequisites;
    private List<String> corequisites;
    private int credits;
    private int level;
    private int version;
    private String summary;
    private int hoursWeek;
    private List <String> usefulResources; //hashmap?
    private List <String> tips;
    private String area;
    private boolean state; //no vista, cursada
    //private int timesViewed; //para recursantes
}