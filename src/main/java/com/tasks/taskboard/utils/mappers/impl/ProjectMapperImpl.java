package com.tasks.taskboard.utils.mappers.impl;

import com.tasks.taskboard.dto.request.ProjectRequestDto;
import com.tasks.taskboard.dto.response.ProjectResponseDto;
import com.tasks.taskboard.entities.ProjectEntity;
import com.tasks.taskboard.utils.mappers.ProjectMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectResponseDto projectToProjectDto(ProjectEntity entity) {
        if (entity == null) {
            return null;
        }

        ProjectResponseDto projectResponseDto = new ProjectResponseDto();

        projectResponseDto.setId(entity.getId());
        projectResponseDto.setName(entity.getName());
        projectResponseDto.setIsPaid(entity.getIsPaid());
        projectResponseDto.setLatestRelease(entity.getLatestRelease());

        return projectResponseDto;
    }

    @Override
    public ProjectEntity ProjectDtoToProject(ProjectRequestDto dto) {
        if (dto == null) {
            return null;
        }

        ProjectEntity projectEntity = new ProjectEntity();

        projectEntity.setName(dto.getName());
        projectEntity.setIsPaid(dto.getIsPaid());
        projectEntity.setLatestRelease(dto.getLatestRelease());

        return projectEntity;
    }
}
