package com.tasks.taskboard.controllers;

import com.tasks.taskboard.entities.UserEntity;
import com.tasks.taskboard.enums.Roles;
import com.tasks.taskboard.exceptions.RequestException;
import com.tasks.taskboard.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

/**
 * Класс-контроллер для обработки клиентских запросов
 * на определенные эндпоинты (URI)
 */
@Tag(name = "User controller", description = "Предоставляет методы для работы с пользователями")
@RestController
public class UserController {
    private final UserService userService;

    /**
     * @param userService - внедрение зависимости (интерфейса UserService)
     *                         при помощи аннотации @Autowired
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)

    /** Операция create
     * @param @RequestBody - объект подставляется из тела запроса
     */
    @Operation(summary = "Создание нового пользователя", description = "Позволяет создать пользователя")
    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestBody UserEntity user) {
        userService.create(user.getId(), user.getName(), user.getSurname(),
                                        user.getContacts(), user.getRole());
        String role = user.getRole().trim().toUpperCase(Locale.ROOT);
        if(role != null) {
            try {
                Roles.valueOf(role);
            } catch(IllegalArgumentException ex) {
                throw new IllegalArgumentException("Данное значение недопустимо");
            }
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Операция readAll
     */
    @Operation(summary = "Получить список пользователей", description = "Возвращает список пользователей")
    @GetMapping(value = "/users")
    public ResponseEntity<List<UserEntity>> readAll() throws RequestException {
        final List<UserEntity> users = userService.readAll();
        if (users != null && !users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            throw new RequestException("Список пуст");
        }
    }

    /**
     * Операция read
     * @param id - id пользователей
     */
    @Operation(summary = "Получить задание по id", description = "Возвращает задание по его id")
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<UserEntity> read(@PathVariable(name = "id") int id) {
        final UserEntity user = userService.read(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            throw new RequestException("Пользователь не найден");
        }
    }


    /**
     * Операция update
     */
    @Operation(summary = "Обновить данные пользователя", description = "Позволяет перезаписать пользователя")
    @PutMapping(value = "/users/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody UserEntity user) {
        final boolean updated = userService.update(id, user);
        String role = user.getRole().trim().toUpperCase(Locale.ROOT);
        if(role != null) {
            try {
                Roles.valueOf(role);
            } catch(IllegalArgumentException ex) {
                throw new IllegalArgumentException("Данное значение недопустимо");
            }
        }
        if (updated) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new RequestException("Пользователь с данным id не найден");
        }
    }

    /**
     * Операция delete
     */
    @Operation(summary = "Удалить задание по id", description = "Позволяет удалить задание по его id")
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = userService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new RequestException("Объект с данным id не найден");
        }
    }

    @Operation(summary = "Удалить всех пользователей", description = "Позволяет удалить всех пользователей")
    @DeleteMapping(value = "/users")
    public ResponseEntity<?> deleteAll() {
        final boolean deleted = userService.deleteAll();
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new RequestException("Список пуст");
        }
    }
}



