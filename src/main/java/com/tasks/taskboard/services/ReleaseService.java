package com.tasks.taskboard.services;

import com.tasks.taskboard.dto.request.ReleaseRequestDto;
import com.tasks.taskboard.dto.response.ReleaseResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collection;


/** Интерфейс для работы с объектами Release */
public interface ReleaseService {
    /** Создание нового объекта Release
     */
    ResponseEntity<?> create(@RequestBody ReleaseRequestDto release);


    /** Получить список всех объектов Release
     * @return список всех релизов
     */
    ResponseEntity<Collection<ReleaseResponseDto>> readAll();

    /** Получить объект Release
     * @param id - id объекта Release
     */
    ResponseEntity<ReleaseResponseDto> read(Long id);

    /** Обновить объект Release
     * @param id - id объекта Release
     * @return перезаписанный объект release
     */
    ResponseEntity<ReleaseResponseDto> update(Long id, ReleaseRequestDto release);

    /** Удалить объект release
     * @param id - id объекта Release
     * @return true если удалено, иначе false
     */
    ResponseEntity delete(Long id);

    /** Удалить все объекты Release
     * @return true если удалены, иначе false
     */
    ResponseEntity deleteAll();
}
