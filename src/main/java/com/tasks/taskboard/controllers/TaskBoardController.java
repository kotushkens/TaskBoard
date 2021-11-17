package com.tasks.taskboard.controllers;

import com.tasks.taskboard.dto.request.TaskBoardRequestDto;
import com.tasks.taskboard.exceptions.NotValidParametersException;
import com.tasks.taskboard.services.TaskBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "TaskBoard controller", description = "Предоставляет методы для работы с заданиями")
@RestController
@RequestMapping(value = "/taskBoard")
public class TaskBoardController {
    private final TaskBoardService taskBoardService;

    public TaskBoardController(TaskBoardService taskBoardService) {
        this.taskBoardService = taskBoardService;
    }

    /** Операция create
     */
    @Operation(summary = "Создание нового задания", description = "Позволяет создать задание")
    @PostMapping(value = "/create")
    public void create(@RequestBody TaskBoardRequestDto taskBoard) {
        taskBoardService.create(taskBoard);
    }

    /**
     * Операция readAll
     */
    @Operation(summary = "Получить список заданиеов", description = "Возвращает список заданий")
    @GetMapping(value = "/getAll")
    public void readAll() throws NotValidParametersException {
        taskBoardService.readAll();
    }

    /**
     * Операция read
     * @param id - версия заданиеа
     */
    @Operation(summary = "Получить задание по id", description = "Возвращает задание по его id")
    @GetMapping(value = "/{id}")
    public void read(@PathVariable(name = "id") Long id) {
        taskBoardService.read(id);
    }


    /**
     * Операция update
     */
    @Operation(summary = "Обновить задание", description = "Позволяет перезаписать задание")
    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable(name = "id") Long id, @RequestBody TaskBoardRequestDto taskBoard) {
        taskBoardService.update(id, taskBoard);
    }

    /**
     * Операция delete
     */
    @Operation(summary = "Удалить задание по id", description = "Позволяет удалить задание по его id")
    @DeleteMapping(value = "/{id}/delete")
    public void delete(@PathVariable(name = "id") Long id) {
        taskBoardService.delete(id);
    }

    @Operation(summary = "Удалить все задания", description = "Позволяет удалить все задания")
    @DeleteMapping(value = "/deleteAll")
    public void deleteAll() {
        taskBoardService.deleteAll();
    }
}





