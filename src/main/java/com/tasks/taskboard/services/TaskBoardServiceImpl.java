package com.tasks.taskboard.services;

import com.tasks.taskboard.dto.request.TaskBoardRequestDto;
import com.tasks.taskboard.dto.response.TaskBoardResponseDto;
import com.tasks.taskboard.entities.TaskBoardEntity;
import com.tasks.taskboard.exceptions.NotValidParametersException;
import com.tasks.taskboard.exceptions.ObjectDoesNotExistsException;
import com.tasks.taskboard.utils.MappingUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


// Сервис, реализующий методы для работы контроллера

@Service
public class TaskBoardServiceImpl implements TaskBoardService {
    // Хранилище заданий
    private static final HashMap<Long, TaskBoardResponseDto> objects = new HashMap<>();
    MappingUtils mapper = new MappingUtils();

    @Override
    //????????????????/
    public ResponseEntity<TaskBoardResponseDto> create(TaskBoardRequestDto taskBoard) throws NotValidParametersException {
        try {
            // TaskBoardEntity taskBoardEntity = new TaskBoardEntity(taskBoard);
            TaskBoardResponseDto response = new TaskBoardResponseDto(taskBoard);
            response.setMessage("Объект успешно создан");
            objects.put(taskBoard.getId(), response);
            return ResponseEntity.ok()
                    .body(response);
        } catch (NotValidParametersException ex) {
            throw new NotValidParametersException("Не удалось создать объект");
        }
    }

    @Override
    public ResponseEntity<Collection<TaskBoardResponseDto>> readAll() throws NotValidParametersException {
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
    public ResponseEntity<TaskBoardResponseDto> read(Long id) throws ObjectDoesNotExistsException {
        if (objects.containsKey(id)) {
            return ResponseEntity.ok()
                    .body(objects.get(id));
        } else {
            throw new ObjectDoesNotExistsException("Объект c id " + id + " не найден");
        }
    }


    @Override
    public ResponseEntity<TaskBoardResponseDto> update(Long id, TaskBoardRequestDto taskBoard)
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
