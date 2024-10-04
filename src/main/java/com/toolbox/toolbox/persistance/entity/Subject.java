package com.toolbox.toolbox.persistance.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
@Document(collection = "subjects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
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
    private HashMap<String, String[]> usefulResources; //TipoRecurso: resumen url
    private List <String> tips;
    private String area;
    private Boolean electiva;
    private boolean state; //no vista, cursada
}