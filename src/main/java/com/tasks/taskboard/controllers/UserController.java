package com.tasks.taskboard.controllers;

import com.tasks.taskboard.dto.request.UserRequestDto;
import com.tasks.taskboard.exceptions.NotValidParametersException;
import com.tasks.taskboard.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User controller", description = "Предоставляет методы для работы с пользователями")
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)

    /** Операция create
     */
    @Operation(summary = "Создание нового пользователя", description = "Позволяет создать пользователя")
    @PostMapping(value = "/create")
    public void create(@RequestBody UserRequestDto user) {
        userService.create(user);
    }

    /**
     * Операция readAll
     */
    @Operation(summary = "Получить список пользователей", description = "Возвращает список пользователей")
    @GetMapping(value = "/getAll")
    public void readAll() throws NotValidParametersException {
        userService.readAll();
    }

    /**
     * Операция read
     * @param id - версия пользовательа
     */
    @Operation(summary = "Получить пользователя по id", description = "Возвращает пользователя по его id")
    @GetMapping(value = "/{id}")
    public void read(@PathVariable(name = "id") Long id) {
        userService.read(id);
    }


    /**
     * Операция update
     */
    @Operation(summary = "Обновить пользователя", description = "Позволяет перезаписать пользователя")
    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable(name = "id") Long id, @RequestBody UserRequestDto user) {
        userService.update(id, user);
    }

    /**
     * Операция delete
     */
    @Operation(summary = "Удалить пользователеля id", description = "Позволяет удалить пользователя по его id")
    @DeleteMapping(value = "/{id}/delete")
    public void delete(@PathVariable(name = "id") Long id) {
        userService.delete(id);
    }

    @Operation(summary = "Удалить все пользователя", description = "Позволяет удалить все пользователя")
    @DeleteMapping(value = "/deleteAll")
    public void deleteAll() {
        userService.deleteAll();
    }
}





