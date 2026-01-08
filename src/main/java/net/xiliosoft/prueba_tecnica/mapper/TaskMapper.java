package net.xiliosoft.prueba_tecnica.mapper;

import net.xiliosoft.prueba_tecnica.dto.TaskDTO;
import net.xiliosoft.prueba_tecnica.model.Task;

public class TaskMapper {

    public static TaskDTO toDTO(Task entity) {
        if (entity == null) return null;

        TaskDTO dto = new TaskDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setDueDate(entity.getDueDate());
        dto.setCompleted(entity.getCompleted());
        return dto;
    }

    public static Task toEntity(TaskDTO dto) {
        if (dto == null) return null;

        Task entity = new Task();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setDueDate(dto.getDueDate());
        entity.setCompleted(dto.getCompleted());
        return entity;
    }
}
