package com.tasks.taskboard.controllers;

import com.tasks.taskboard.entities.ProjectEntity;
import com.tasks.taskboard.exceptions.RequestException;
import com.tasks.taskboard.services.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Класс-контроллер для обработки клиентских запросов
 * на определенные эндпоинты (URI)
 */
@Tag(name = "Project controller", description = "Предоставляет методы для работы с проектами")
@RestController
public class ProjectController {
    private final ProjectService projectService;

    /**
     * @param projectService - внедрение зависимости (интерфейса ProjectService)
     *                       при помощи аннотации @Autowired
     */
    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)

    /** Операция create
     * @param @RequestBody - объект подставляется из тела запроса
     */
    @Operation(summary = "Создание нового проекта", description = "Позволяет создать проект")
    @PostMapping(value = "/projects")
    public ResponseEntity<?> create(@RequestBody ProjectEntity project) {
        projectService.create(project.getId(), project.getName(), project.getIsPaid(), project.getLatestRelease());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Операция readAll
     */
    @Operation(summary = "Получить список проектов", description = "Возвращает список проектов")
    @GetMapping(value = "/projects")
    public ResponseEntity<List<ProjectEntity>> readAll() throws RequestException {
        final List<ProjectEntity> projects = projectService.readAll();
        if (projects != null && !projects.isEmpty()) {
            return new ResponseEntity<>(projects, HttpStatus.OK);
        } else {
            throw new RequestException("Список пуст");
        }
    }

        /**
         * Операция read
         *
         * @param id - id проекта
         */
        @Operation(summary = "Получить проект по id", description = "Возвращает проект по его id")
        @GetMapping(value = "/projects/{id}")
        public ResponseEntity<ProjectEntity> read ( @PathVariable(name = "id") int id){
            final ProjectEntity project = projectService.read(id);
            if (project != null) {
                return new ResponseEntity<>(project, HttpStatus.OK);
            } else {
                throw new RequestException("Объект не найден");
            }
        }


        /**
         * Операция update
         */
        @Operation(summary = "Обновить проект", description = "Позволяет перезаписать проект")
        @PutMapping(value = "/projects/{id}")
        public ResponseEntity<?> update ( @PathVariable(name = "id") int id, @RequestBody ProjectEntity project){
            final boolean updated = projectService.update(id, project);
            if (updated) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                throw new RequestException("Объект с данным id не найден");
            }
        }

        /**
         * Операция delete
         */
        @Operation(summary = "Удалить проект по id", description = "Позволяет удалить проект по его id")
        @DeleteMapping(value = "/projects/{id}")
        public ResponseEntity<?> delete ( @PathVariable(name = "id") int id){
            final boolean deleted = projectService.delete(id);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                throw new RequestException("Объект с данным id не найден");
            }
        }

        @Operation(summary = "Удалить все проекты", description = "Позволяет удалить все проекты")
        @DeleteMapping(value = "/projects")
        public ResponseEntity<?> deleteAll () {
            final boolean deleted = projectService.deleteAll();
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                throw new RequestException("Список пуст");
            }
        }
    }


