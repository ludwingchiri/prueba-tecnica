package net.xiliosoft.prueba_tecnica.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import net.xiliosoft.prueba_tecnica.dto.TaskDTO;
import net.xiliosoft.prueba_tecnica.mapper.TaskMapper;
import net.xiliosoft.prueba_tecnica.model.Task;
import net.xiliosoft.prueba_tecnica.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class TaskService {

    @Inject
    private TaskRepository taskRepository;

    public List<TaskDTO> listar() {
        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void guardar(TaskDTO dto) {
        Task entity;

        if (dto.getId() != null) {
            entity = taskRepository.findById(dto.getId());
            entity.setTitle(dto.getTitle());
            entity.setDescription(dto.getDescription());
            entity.setDueDate(dto.getDueDate());
            entity.setCompleted(dto.getCompleted());
        } else {
            entity = TaskMapper.toEntity(dto);
        }

        taskRepository.save(entity);
    }

    public void eliminar(TaskDTO dto) {
        Task entity = taskRepository.findById(dto.getId());
        taskRepository.delete(entity);
    }
}
