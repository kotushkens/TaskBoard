package com.tasks.taskboard.services.impl;

import com.tasks.taskboard.dto.request.ReleaseRequestDto;
import com.tasks.taskboard.dto.response.ReleaseResponseDto;
import com.tasks.taskboard.exceptions.NotValidParametersException;
import com.tasks.taskboard.exceptions.ObjectDoesNotExistsException;
import com.tasks.taskboard.services.ReleaseService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;


// Сервис, реализующий методы для работы контроллера

@Service
public class ReleaseServiceImpl implements ReleaseService {
    // Хранилище релизов
    private static final HashMap<Long, ReleaseResponseDto> objects = new HashMap<>();


    @Override
    //????????????????/
    public ResponseEntity<ReleaseResponseDto> create(ReleaseRequestDto release) throws NotValidParametersException {
        try {
           // ReleaseEntity releaseEntity = new ReleaseEntity(release);
            ReleaseResponseDto response = new ReleaseResponseDto(release);
            response.setMessage("Объект успешно создан");
            objects.put(release.getId(), response);
            return ResponseEntity.ok()
                    .body(response);
        } catch (NotValidParametersException ex) {
            throw new NotValidParametersException("Не удалось создать объект");
        }
    }

    @Override
    public ResponseEntity<Collection<ReleaseResponseDto>> readAll() throws NotValidParametersException {
        try {
            if (CollectionUtils.isNotEmpty(objects.values())) {
                return ResponseEntity.ok()
                        .body(objects.values());
            } else {
                throw new ObjectDoesNotExistsException("Список пуст");
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Список не инициализирован");
        }
    }

    @Override
    public ResponseEntity<ReleaseResponseDto> read(Long id) throws ObjectDoesNotExistsException {
        if (objects.containsKey(id)) {
            return ResponseEntity.ok()
                    .body(objects.get(id));
        } else {
            throw new ObjectDoesNotExistsException("Объект c id " + id + " не найден");
        }
    }


    @Override
    public ResponseEntity<ReleaseResponseDto> update(Long id, ReleaseRequestDto release)
            throws ObjectDoesNotExistsException {
        if (objects.containsKey(id)) {
            return ResponseEntity.ok()
                    .body(objects.get(id));
        } else {
            throw new ObjectDoesNotExistsException("Объект c id " + id + " не найден");
        }
    }

    @Override
    public ResponseEntity<String> delete(Long id) throws ObjectDoesNotExistsException {
        if (objects.containsKey(id)) {
            objects.remove(id);
            return ResponseEntity.ok()
                    .body("Объект удален");
        }
        throw new ObjectDoesNotExistsException("Объект c id " + id + " не найден");
    }

    @Override
    public ResponseEntity<String> deleteAll() throws  NotValidParametersException {
        if (!objects.isEmpty()) {
            objects.clear();
            return ResponseEntity.ok()
                    .body("Список очищен");
        } else {
            throw new NotValidParametersException("Cписок пуст");
        }
    }
}
