package com.tasks.taskboard.services;

import com.tasks.taskboard.entities.TaskBoardEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Сервис, реализующий методы для работы контроллера

@Service
public class TaskBoardServiceImpl implements TaskBoardService {

    // Хранилище заданий
    private static final HashMap<Integer, TaskBoardEntity> taskBoardsRepository = new HashMap<>();


    @Override
    public void create(Integer id, String status,
                       String releaseVersion, Integer author,
                       Integer executor, String taskType, String description) {
        TaskBoardEntity taskBoard = new TaskBoardEntity(id, status, releaseVersion, author,
                executor, taskType, description);
        taskBoardsRepository.put(id, taskBoard);
    }

    @Override
    public List<TaskBoardEntity> readAll() {
        return new ArrayList<>(taskBoardsRepository.values());
    }

    @Override
    public TaskBoardEntity read(int id) {
        return taskBoardsRepository.get(id);
    }


    @Override
    public boolean update(int id, TaskBoardEntity taskBoard) {
        if (taskBoardsRepository.containsKey(id)) {
            taskBoard.setId(id);
            taskBoardsRepository.put(id, taskBoard);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (taskBoardsRepository.containsKey(id)) {
            taskBoardsRepository.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAll() {
        if (!taskBoardsRepository.isEmpty()) {
            taskBoardsRepository.clear();
            return true;
        }
        return false;
    }
}
