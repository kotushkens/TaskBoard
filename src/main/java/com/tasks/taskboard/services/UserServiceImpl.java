package com.tasks.taskboard.services;

import com.tasks.taskboard.dto.request.UserRequestDto;
import com.tasks.taskboard.dto.response.UserResponseDto;
import com.tasks.taskboard.entities.UserEntity;
import com.tasks.taskboard.exceptions.NotValidParametersException;
import com.tasks.taskboard.exceptions.ObjectDoesNotExistsException;
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
public class UserServiceImpl implements UserService {
    // Хранилище релизов
    private static final HashMap<Long, UserResponseDto> objects = new HashMap<>();


    @Override
    //????????????????/
    public ResponseEntity<UserResponseDto> create(UserRequestDto user) throws NotValidParametersException {
        try {
            // UserEntity userEntity = new UserEntity(user);
            UserResponseDto response = new UserResponseDto(user);
            response.setMessage("Объект успешно создан");
            objects.put(user.getId(), response);
            return ResponseEntity.ok()
                    .body(response);
        } catch (NotValidParametersException ex) {
            throw new NotValidParametersException("Не удалось создать объект");
        }
    }

    @Override
    public ResponseEntity<Collection<UserResponseDto>> readAll() throws NotValidParametersException {
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
    public ResponseEntity<UserResponseDto> read(Long id) throws ObjectDoesNotExistsException {
        if (objects.containsKey(id)) {
            return ResponseEntity.ok()
                    .body(objects.get(id));
        } else {
            throw new ObjectDoesNotExistsException("Объект c id " + id + " не найден");
        }
    }


    @Override
    public ResponseEntity<UserResponseDto> update(Long id, UserRequestDto user)
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
