package com.tasks.taskboard.services.impl;

import com.tasks.taskboard.dto.request.ProjectRequestDto;
import com.tasks.taskboard.dto.response.ProjectResponseDto;
import com.tasks.taskboard.entities.ProjectEntity;
import com.tasks.taskboard.exceptions.NotValidParametersException;
import com.tasks.taskboard.exceptions.ObjectDoesNotExistsException;
import com.tasks.taskboard.repositories.ProjectRepository;
import com.tasks.taskboard.services.ProjectService;
import com.tasks.taskboard.utils.mappers.impl.ProjectMapperImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


// Сервис, реализующий методы для работы контроллера

@Service
public class ProjectServiceImpl implements ProjectService {
    // Хранилище релизов
    private static final ArrayList<ProjectResponseDto> objects = new ArrayList<>();
    private final ProjectMapperImpl mapper;
    private final ProjectRepository repository;

    @Autowired
    public ProjectServiceImpl(ProjectMapperImpl mapper, @Qualifier("project") ProjectRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    //????????????????/
    public ResponseEntity<ProjectResponseDto> create(ProjectRequestDto project) throws NotValidParametersException {
        try {
            // ProjectEntity projectEntity = new ProjectEntity(project);
            ProjectEntity entity = mapper.ProjectDtoToProject(project);
            repository.save(entity);
            ProjectResponseDto response = mapper.projectToProjectDto(entity);
            objects.add(response);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (NotValidParametersException ex) {
            throw new NotValidParametersException("Не удалось создать объект");
        }
    }

    @Override
    public ResponseEntity<Collection<ProjectResponseDto>> readAll() throws NotValidParametersException {
        try {
            if (CollectionUtils.isNotEmpty(objects)) {
                return ResponseEntity.ok()
                        .body(objects);
            } else {
                throw new ObjectDoesNotExistsException("Список пуст");
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Список не инициализирован");
        }
    }

   /* @Override
    public ResponseEntity<ProjectResponseDto> read(Long id) throws ObjectDoesNotExistsException {
        if (objects.containsKey(id)) {
            return ResponseEntity.ok()
                    .body(objects.get(id));
        } else {
            throw new ObjectDoesNotExistsException("Объект c id " + id + " не найден");
        }
    }*/


   /* @Override
    public ResponseEntity<ProjectResponseDto> update(Long id, ProjectRequestDto project)
            throws ObjectDoesNotExistsException {
        if (objects.containsKey(id)) {
            return ResponseEntity.ok()
                    .body(objects.get(id));
        } else {
            throw new ObjectDoesNotExistsException("Объект c id " + id + " не найден");
        }
    }*/

 /*   @Override
    public ResponseEntity<String> delete(Long id) throws ObjectDoesNotExistsException {
        if (objects.containsKey(id)) {
            objects.remove(id);
            return ResponseEntity.ok()
                    .body("Объект удален");
        }
        throw new ObjectDoesNotExistsException("Объект c id " + id + " не найден");
    }*/

    @Override
    public ResponseEntity<String> deleteAll() throws  NotValidParametersException {
        if (CollectionUtils.isNotEmpty(objects)) {
            objects.clear();
            return ResponseEntity.ok()
                    .body("Список очищен");
        } else {
            throw new NotValidParametersException("Cписок пуст");
        }
    }
}
