package com.tasks.taskboard.services;

import com.tasks.taskboard.entities.UserEntity;

import java.util.List;

    /**
     * Интерфейс для работы с объектами User
     */

    public interface UserService {
        /**
         * Создание нового объекта User
         */
        void create(Integer id, String name, String surname, String contacts, String role);

        /**
         * Получить список всех объектов User
         *
         * @return список всех релизов
         */
        List<UserEntity> readAll();

        /**
         * Получить объект User
         *
         * @param id - id объекта User
         */
        UserEntity read(int id);

        /**
         * Обновить объект User
         *
         * @param id - id объекта User
         * @return true, если данные обновлены, иначе false
         */
        boolean update(int id, UserEntity User);

        /**
         * Удалить объект User
         *
         * @param id - id объекта User
         * @return true если удалено, иначе false
         */
        boolean delete(int id);

        /**
         * Удалить все объекты User
         *
         * @return true если удалены, иначе false
         */
        boolean deleteAll();
    }



