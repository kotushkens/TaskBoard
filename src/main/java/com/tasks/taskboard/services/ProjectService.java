package com.tasks.taskboard.services;

import com.tasks.taskboard.entities.ProjectEntity;

import java.util.List;


/** Интерфейс для работы с объектами Project */
public interface ProjectService {
    /** Создание нового объекта Project
     */
    void create(Integer id, String name, String isPaid, String latestRelease);

    /** Получить список всех объектов Project
     * @return список всех проектов
     */
    List<ProjectEntity> readAll();

    /** Получить объект Project
    * @param id - id объекта Project
     */
    ProjectEntity read(int id);

    /** Обновить объект Project
    * @param id - id объекта Project
    * @return true, если данные обновлены, иначе false
     */
    boolean update(int id, ProjectEntity project);

    /** Удалить объект project
    * @param id - id объекта Project
    * @return true если удалено, иначе false
     */
    boolean delete(int id);

    /** Удалить все объекты Project
     * @return true если удалены, иначе false
     */
    boolean deleteAll();
}
