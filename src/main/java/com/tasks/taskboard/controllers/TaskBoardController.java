package com.tasks.taskboard.controllers;

import com.tasks.taskboard.entities.TaskBoardEntity;
import com.tasks.taskboard.exceptions.RequestException;
import com.tasks.taskboard.services.TaskBoardService;
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
@Tag(name = "TaskBoard controller", description = "Предоставляет методы для работы с заданиями")
@RestController
public class TaskBoardController {
    private final TaskBoardService taskBoardService;

    /**
     * @param taskBoardService - внедрение зависимости (интерфейса TaskBoardService)
     *                         при помощи аннотации @Autowired
     */
    @Autowired
    public TaskBoardController(TaskBoardService taskBoardService) {
        this.taskBoardService = taskBoardService;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)

    /** Операция create
     * @param @RequestBody - объект подставляется из тела запроса
     */
    @Operation(summary = "Создание нового задания", description = "Позволяет создать задание")
    @PostMapping(value = "/taskBoards")
    public ResponseEntity<?> create(@RequestBody TaskBoardEntity taskBoard) {
        taskBoardService.create(taskBoard.getId(), taskBoard.getStatus(),
                taskBoard.getReleaseVersion(), taskBoard.getAuthor(),
                taskBoard.getExecutor(), taskBoard.getTaskType(), taskBoard.getDescription());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Операция readAll
     */
    @Operation(summary = "Получить список заданий", description = "Возвращает список заданий")
    @GetMapping(value = "/taskBoards")
    public ResponseEntity<List<TaskBoardEntity>> readAll() throws RequestException {
        final List<TaskBoardEntity> taskBoards = taskBoardService.readAll();
        if (taskBoards != null && !taskBoards.isEmpty()) {
            return new ResponseEntity<>(taskBoards, HttpStatus.OK);
        } else {
            throw new RequestException("Список пуст");
        }
    }

    /**
     * Операция read
     *
     * @param id - id задания
     */
    @Operation(summary = "Получить задание по id", description = "Возвращает задание по его id")
    @GetMapping(value = "/taskBoards/{id}")
    public ResponseEntity<TaskBoardEntity> read(@PathVariable(name = "id") int id) {
        final TaskBoardEntity taskBoard = taskBoardService.read(id);
        if (taskBoard != null) {
            return new ResponseEntity<>(taskBoard, HttpStatus.OK);
        } else {
            throw new RequestException("Объект не найден");
        }
    }


    /**
     * Операция update
     */
    @Operation(summary = "Обновить задание", description = "Позволяет перезаписать задание")
    @PutMapping(value = "/taskBoards/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody TaskBoardEntity taskBoard) {
        final boolean updated = taskBoardService.update(id, taskBoard);
        if (updated) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new RequestException("Объект с данным id не найден");
        }
    }

    /**
     * Операция delete
     */
    @Operation(summary = "Удалить задание по id", description = "Позволяет удалить задание по его id")
    @DeleteMapping(value = "/taskBoards/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = taskBoardService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new RequestException("Объект с данным id не найден");
        }
    }

    @Operation(summary = "Удалить все задания", description = "Позволяет удалить все задания")
    @DeleteMapping(value = "/taskBoards")
    public ResponseEntity<?> deleteAll() {
        final boolean deleted = taskBoardService.deleteAll();
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new RequestException("Список пуст");
        }
    }
}



