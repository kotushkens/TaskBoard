package com.tasks.taskboard.services;

import com.tasks.taskboard.dto.request.ProjectRequestDto;
import com.tasks.taskboard.dto.response.ProjectResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;


/** Интерфейс для работы с объектами Project */
public interface ProjectService {
    /**
     * Создание нового объекта Project
     */
    ResponseEntity<ProjectResponseDto> create(@RequestBody ProjectRequestDto project);


    /**
     * Получить список всех объектов Project
     *
     * @return список всех релизов
     */
    ResponseEntity<Collection<ProjectResponseDto>> readAll();

    /** Получить объект Project
     * @param id - id объекта Project
     */
    /*    ResponseEntity<ProjectResponseDto> read(Long id);

     *//** Обновить объект Project
     * @param id - id объекта Project
     * @return перезаписанный объект project
     *//*
    ResponseEntity<ProjectResponseDto> update(Long id, ProjectRequestDto project);

    *//** Удалить объект project
     * @param id - id объекта Project
     * @return true если удалено, иначе false
     *//*
    ResponseEntity delete(Long id);*/

    /**
     * Удалить все объекты Project
     *
     * @return true если удалены, иначе false
     */
    ResponseEntity deleteAll();
}
