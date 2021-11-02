package com.tasks.taskboard.services;

import com.tasks.taskboard.entities.ProjectEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


// Сервис, реализующий методы для работы контроллера

@Service
public class ProjectServiceImpl implements ProjectService {

    // Хранилище проектов
    private static final HashMap<Integer, ProjectEntity> projectsRepository = new HashMap<>();


    @Override
    public void create(Integer id, String name, String isPaid, String latestRelease) {
        ProjectEntity project = new ProjectEntity(id, name, isPaid, latestRelease);
        projectsRepository.put(id, project);
    }

    @Override
    public List<ProjectEntity> readAll() {
        return new ArrayList<>(projectsRepository.values());
    }

    @Override
    public ProjectEntity read(int id) {
        return projectsRepository.get(id);
    }


    @Override
    public boolean update(int id, ProjectEntity project) {
        if (projectsRepository.containsKey(id)){
            project.setId(id);
            projectsRepository.put(id, project);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (projectsRepository.containsKey(id)){
            projectsRepository.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAll() {
        if (!projectsRepository.isEmpty()){
            projectsRepository.clear();
            return true;
        }
        return false;
    }
}
