package com.tasks.taskboard.services;

import com.tasks.taskboard.entities.ReleaseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ReleaseServiceImpl implements ReleaseService {
// Сервис, реализующий методы для работы контроллера


    // Хранилище релизов
    private static final HashMap<String, ReleaseEntity> ReleasesRepository = new HashMap<>();


    @Override
    public void create(String version, String start, String end) {
        ReleaseEntity release = new ReleaseEntity(version, start, end);
        ReleasesRepository.put(version, release);
    }

    @Override
    public List<ReleaseEntity> readAll() {
        return new ArrayList<>(ReleasesRepository.values());
    }

    @Override
    public ReleaseEntity read(String version) {
        return ReleasesRepository.get(version);
    }


    @Override
    public boolean update(String version, ReleaseEntity Release) {
        if (ReleasesRepository.containsKey(version)) {
            Release.setVersion(version);
            ReleasesRepository.put(version, Release);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String version) {
        if (ReleasesRepository.containsKey(version)) {
            ReleasesRepository.remove(version);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAll() {
        if (!ReleasesRepository.isEmpty()) {
            ReleasesRepository.clear();
            return true;
        }
        return false;
    }
}


