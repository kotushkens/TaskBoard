package com.tasks.taskboard.services;

import com.tasks.taskboard.dto.request.UserRequestDto;
import com.tasks.taskboard.dto.response.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;


/** Интерфейс для работы с объектами User */
public interface UserService {
    /** Создание нового объекта User
     */
    ResponseEntity<?> create(@RequestBody UserRequestDto user);


    /** Получить список всех объектов User
     * @return список всех релизов
     */
    ResponseEntity<Collection<UserResponseDto>> readAll();

    /** Получить объект User
     * @param id - id объекта User
     */
    ResponseEntity<UserResponseDto> read(Long id);

    /** Обновить объект User
     * @param id - id объекта User
     * @return перезаписанный объект user
     */
    ResponseEntity<UserResponseDto> update(Long id, UserRequestDto user);

    /** Удалить объект user
     * @param id - id объекта User
     * @return true если удалено, иначе false
     */
    ResponseEntity delete(Long id);

    /** Удалить все объекты User
     * @return true если удалены, иначе false
     */
    ResponseEntity deleteAll();
}
