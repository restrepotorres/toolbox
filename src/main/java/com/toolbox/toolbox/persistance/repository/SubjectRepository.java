package com.toolbox.toolbox.persistance.repository;

import com.toolbox.toolbox.persistance.entity.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepository  extends MongoRepository<Subject,String> {
}
