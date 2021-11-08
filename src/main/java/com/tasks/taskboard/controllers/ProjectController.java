package com.tasks.taskboard.controllers;

import com.tasks.taskboard.dto.request.ProjectRequestDto;
import com.tasks.taskboard.exceptions.NotValidParametersException;
import com.tasks.taskboard.services.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Project controller", description = "Предоставляет методы для работы с проектами")
@RestController
@RequestMapping(value = "/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)

    /** Операция create
     */
    @Operation(summary = "Создание нового проекта", description = "Позволяет создать проект")
    @PostMapping(value = "/create")
    public void create(@RequestBody ProjectRequestDto project) {
        projectService.create(project);
    }

    /**
     * Операция readAll
     */
    @Operation(summary = "Получить список проектов", description = "Возвращает список проектов")
    @GetMapping(value = "/getAll")
    public void readAll() throws NotValidParametersException {
        projectService.readAll();
    }

    /**
     * Операция read
     * @param id - версия проекта
     */
    @Operation(summary = "Получить проект по id", description = "Возвращает проект по его id")
    @GetMapping(value = "/{id}")
    public void read(@PathVariable(name = "id") Long id) {
        projectService.read(id);
    }


    /**
     * Операция update
     */
    @Operation(summary = "Обновить проект", description = "Позволяет перезаписать проект")
    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable(name = "id") Long id, @RequestBody ProjectRequestDto project) {
        projectService.update(id, project);
    }

    /**
     * Операция delete
     */
    @Operation(summary = "Удалить проект по id", description = "Позволяет удалить проект по его id")
    @DeleteMapping(value = "/{id}/delete")
    public void delete(@PathVariable(name = "id") Long id) {
        projectService.delete(id);
    }

    @Operation(summary = "Удалить все проекты", description = "Позволяет удалить все проекты")
    @DeleteMapping(value = "/deleteAll")
    public void deleteAll() {
        projectService.deleteAll();
    }
}





