package com.toolbox.toolbox.Domain.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectFullDTO {
    private String id;
    private String name;
    private List<String> prerequisites;
    private List<String> corequisites;
    private int credits;
    private int level;
    private String summary;
    private int hoursWeek;
    private HashMap<String, String[]> usefulResources; // TipoRecurso: resumen url
    private List<String> tips;
    private String area;
    private Boolean electiva;
    private boolean state; // no vista, cursada
}
