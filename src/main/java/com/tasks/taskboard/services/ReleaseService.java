package com.tasks.taskboard.services;

import com.tasks.taskboard.entities.ReleaseEntity;

import java.util.List;

/**
 * Интерфейс для работы с объектами Release
 */

public interface ReleaseService {

    /**
     * Создание нового объекта Release
     */
    void create(String version, String start, String end);

    /**
     * Получить список всех объектов Release
     *
     * @return список всех релизов
     */
    List<ReleaseEntity> readAll();

    /**
     * Получить объект Release
     *
     * @param version - версия объекта Release
     */
    ReleaseEntity read(String version);

    /**
     * Обновить объект Release
     *
     * @param version - версия объекта Release
     * @return true, если данные обновлены, иначе false
     */
    boolean update(String version, ReleaseEntity release);

    /**
     * Удалить объект Release
     *
     * @param version - версия объекта Release
     * @return true если удалено, иначе false
     */
    boolean delete(String version);

    /**
     * Удалить все объекты Release
     *
     * @return true если удалены, иначе false
     */
    boolean deleteAll();
}


