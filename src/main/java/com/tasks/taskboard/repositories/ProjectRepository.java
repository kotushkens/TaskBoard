package com.tasks.taskboard.repositories;

import com.tasks.taskboard.entities.ProjectEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("project")
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {
/*    ProjectEntity save(ProjectEntity entity);
    List<ProjectEntity> findAll();
    Optional<ProjectEntity> findById(Long id);
    void delete(Long id);
    void deleteAll();*/
}
