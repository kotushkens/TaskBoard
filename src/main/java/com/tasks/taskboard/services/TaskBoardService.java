package com.tasks.taskboard.services;

import com.tasks.taskboard.entities.TaskBoardEntity;

import java.util.List;

/**
 * Интерфейс для работы с объектами TaskBoard
 */

public interface TaskBoardService {
    /**
     * Создание нового объекта TaskBoard
     */
    void create(Integer id, String status,
                String releaseVersion, Integer author,
                Integer executor, String taskType, String description);

    /**
     * Получить список всех объектов TaskBoard
     *
     * @return список всех релизов
     */
    List<TaskBoardEntity> readAll();

    /**
     * Получить объект TaskBoard
     *
     * @param id - id объекта TaskBoard
     */
    TaskBoardEntity read(int id);

    /**
     * Обновить объект TaskBoard
     *
     * @param id - id объекта TaskBoard
     * @return true, если данные обновлены, иначе false
     */
    boolean update(int id, TaskBoardEntity TaskBoard);

    /**
     * Удалить объект TaskBoard
     *
     * @param id - id объекта TaskBoard
     * @return true если удалено, иначе false
     */
    boolean delete(int id);

    /**
     * Удалить все объекты TaskBoard
     *
     * @return true если удалены, иначе false
     */
    boolean deleteAll();
}


