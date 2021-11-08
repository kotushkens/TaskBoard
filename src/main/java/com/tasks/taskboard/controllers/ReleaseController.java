package com.tasks.taskboard.controllers;

import com.tasks.taskboard.dto.request.ReleaseRequestDto;
import com.tasks.taskboard.exceptions.NotValidParametersException;
import com.tasks.taskboard.services.ReleaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Release controller", description = "Предоставляет методы для работы с релизами")
@RestController
@RequestMapping(value = "/release")
public class ReleaseController {
    private final ReleaseService releaseService;

    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)

    /** Операция create
     */
    @Operation(summary = "Создание нового релиза", description = "Позволяет создать релиз")
    @PostMapping(value = "/create")
    public void create(@RequestBody ReleaseRequestDto release) {
        releaseService.create(release);
    }

    /**
     * Операция readAll
     */
    @Operation(summary = "Получить список релизов", description = "Возвращает список релизов")
    @GetMapping(value = "/getAll")
    public void readAll() throws NotValidParametersException {
        releaseService.readAll();
    }

    /**
     * Операция read
     * @param id - версия релиза
     */
    @Operation(summary = "Получить релиз по id", description = "Возвращает релиз по его id")
    @GetMapping(value = "/{id}")
    public void read(@PathVariable(name = "id") Long id) {
        releaseService.read(id);
    }


    /**
     * Операция update
     */
    @Operation(summary = "Обновить релиз", description = "Позволяет перезаписать релиз")
    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable(name = "id") Long id, @RequestBody ReleaseRequestDto release) {
        releaseService.update(id, release);
    }

    /**
     * Операция delete
     */
    @Operation(summary = "Удалить релиз по id", description = "Позволяет удалить релиз по его id")
    @DeleteMapping(value = "/{id}/delete")
    public void delete(@PathVariable(name = "id") Long id) {
        releaseService.delete(id);
    }

    @Operation(summary = "Удалить все релизы", description = "Позволяет удалить все релизы")
    @DeleteMapping(value = "/deleteAll")
    public void deleteAll() {
        releaseService.deleteAll();
    }
}





