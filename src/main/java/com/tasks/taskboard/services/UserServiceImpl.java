package com.tasks.taskboard.services;

import com.tasks.taskboard.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Сервис, реализующий методы для работы контроллера

@Service
public class UserServiceImpl implements UserService {

    // Хранилище пользователей
    private static final HashMap<Integer, UserEntity> usersRepository = new HashMap<>();


    @Override
    public void create(Integer id, String name, String surname, String contacts, String role) {
        UserEntity user = new UserEntity(id, name, surname, contacts, role);
        usersRepository.put(id, user);
    }

    @Override
    public List<UserEntity> readAll() {
        return new ArrayList<>(usersRepository.values());
    }

    @Override
    public UserEntity read(int id) {
        return usersRepository.get(id);
    }


    @Override
    public boolean update(int id, UserEntity user) {
        if (usersRepository.containsKey(id)) {
            user.setId(id);
            usersRepository.put(id, user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (usersRepository.containsKey(id)) {
            usersRepository.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAll() {
        if (!usersRepository.isEmpty()) {
            usersRepository.clear();
            return true;
        }
        return false;
    }
}
