package com.tasks.taskboard.services;

import com.tasks.taskboard.dto.request.TaskBoardRequestDto;
import com.tasks.taskboard.dto.response.TaskBoardResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;


/** Интерфейс для работы с объектами TaskBoard */
public interface TaskBoardService {
    /** Создание нового объекта TaskBoard
     */
    ResponseEntity<?> create(@RequestBody TaskBoardRequestDto taskBoard);


    /** Получить список всех объектов TaskBoard
     * @return список всех релизов
     */
    ResponseEntity<Collection<TaskBoardResponseDto>> readAll();

    /** Получить объект TaskBoard
     * @param id - id объекта TaskBoard
     */
    ResponseEntity<TaskBoardResponseDto> read(Long id);

    /** Обновить объект TaskBoard
     * @param id - id объекта TaskBoard
     * @return перезаписанный объект taskBoard
     */
    ResponseEntity<TaskBoardResponseDto> update(Long id, TaskBoardRequestDto taskBoard);

    /** Удалить объект taskBoard
     * @param id - id объекта TaskBoard
     * @return true если удалено, иначе false
     */
    ResponseEntity delete(Long id);

    /** Удалить все объекты TaskBoard
     * @return true если удалены, иначе false
     */
    ResponseEntity deleteAll();
}
