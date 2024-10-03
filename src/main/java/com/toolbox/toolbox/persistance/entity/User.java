package com.toolbox.toolbox.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private int id;
    private String username;
    private String password;
    private String email;
    @DBRef
    private Set<Role> roles = new HashSet<>();
    @DBRef
    private Set<Subject> subjects = new HashSet<>();
}
