package com.toolbox.toolbox.Domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectBasicDTO {
    private String id;
    private String name;
    private List<String> prerequisites;
    private List<String> corequisites;
    private int credits;
    private int level;
    private String area;
    private boolean state;
}
