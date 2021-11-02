package com.tasks.taskboard.controllers;

import com.tasks.taskboard.entities.ReleaseEntity;
import com.tasks.taskboard.exceptions.RequestException;
import com.tasks.taskboard.services.ReleaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    /**
     * Класс-контроллер для обработки клиентских запросов
     * на определенные эндпоинты (URI)
     */
    @Tag(name = "Release controller", description = "Предоставляет методы для работы с релизами")
    @RestController
    public class ReleaseController {
        private final ReleaseService releaseService;

        /**
         * @param releaseService - внедрение зависимости (интерфейса ReleaseService)
         *                       при помощи аннотации @Autowired
         */
        @Autowired
        public ReleaseController(ReleaseService releaseService) {
            this.releaseService = releaseService;
        }

        @ExceptionHandler(DataIntegrityViolationException.class)

        /** Операция create
         * @param @RequestBody - объект подставляется из тела запроса
         */
        @Operation(summary = "Создание нового релиза", description = "Позволяет создать релиз")
        @PostMapping(value = "/releases")
        public ResponseEntity<?> create(@RequestBody ReleaseEntity release) {
            releaseService.create(release.getVersion(), release.getStart(), release.getEnd());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        /**
         * Операция readAll
         */
        @Operation(summary = "Получить список релизов", description = "Возвращает список релизов")
        @GetMapping(value = "/releases")
        public ResponseEntity<List<ReleaseEntity>> readAll() throws RequestException {
            final List<ReleaseEntity> releases = releaseService.readAll();
            if (releases != null && !releases.isEmpty()) {
                return new ResponseEntity<>(releases, HttpStatus.OK);
            } else {
                throw new RequestException("Список пуст");
            }
        }

        /**
         * Операция read
         *
         * @param version - версия релиза
         */
        @Operation(summary = "Получить релиз по версии", description = "Возвращает релиз по его версии")
        @GetMapping(value = "/releases/{version}")
        public ResponseEntity<ReleaseEntity> read(@PathVariable(name = "version") String version) {
            final ReleaseEntity release = releaseService.read(version);
            if (release != null) {
                return new ResponseEntity<>(release, HttpStatus.OK);
            } else {
                throw new RequestException("Объект не найден");
            }
        }


        /**
         * Операция update
         */
        @Operation(summary = "Обновить релиз", description = "Позволяет перезаписать релиз")
        @PutMapping(value = "/releases/{version}")
        public ResponseEntity<?> update(@PathVariable(name = "version") String version, @RequestBody ReleaseEntity release) {
            final boolean updated = releaseService.update(version, release);
            if (updated) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                throw new RequestException("Объект с данной версией не найден");
            }
        }

        /**
         * Операция delete
         */
        @Operation(summary = "Удалить релиз по версии", description = "Позволяет удалить релиз по его версии")
        @DeleteMapping(value = "/releases/{version}")
        public ResponseEntity<?> delete(@PathVariable(name = "version") String version) {
            final boolean deleted = releaseService.delete(version);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                throw new RequestException("Объект с данной версией не найден");
            }
        }

        @Operation(summary = "Удалить все релизы", description = "Позволяет удалить все релизы")
        @DeleteMapping(value = "/Releases")
        public ResponseEntity<?> deleteAll() {
            final boolean deleted = releaseService.deleteAll();
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                throw new RequestException("Список пуст");
            }
        }
    }





