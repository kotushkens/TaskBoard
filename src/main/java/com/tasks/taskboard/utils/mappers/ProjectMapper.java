package com.tasks.taskboard.utils.mappers;

import com.tasks.taskboard.dto.request.ProjectRequestDto;
import com.tasks.taskboard.dto.response.ProjectResponseDto;
import com.tasks.taskboard.entities.ProjectEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Класс для конвертации объектов в DTO и наоборот
 */

@Component
@Mapper
public interface ProjectMapper {
    ProjectResponseDto projectToProjectDto(ProjectEntity entity);

    ProjectEntity ProjectDtoToProject(ProjectRequestDto dto);
}
