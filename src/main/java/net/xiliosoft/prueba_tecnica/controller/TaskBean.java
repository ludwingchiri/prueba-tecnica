package net.xiliosoft.prueba_tecnica.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import net.xiliosoft.prueba_tecnica.dto.TaskDTO;
import net.xiliosoft.prueba_tecnica.service.TaskService;

@Named
@ViewScoped
public class TaskBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
    private TaskService taskService;

    private List<TaskDTO> tasks;
    private TaskDTO taskSeleccionada;

    @PostConstruct
    public void init() {
        tasks = taskService.listar();
    }
        
    public void nuevo() {
        taskSeleccionada = new TaskDTO();
    }

    public void guardar() {
        taskService.guardar(taskSeleccionada);
        tasks = taskService.listar();
    }

    public void eliminar() {
    	if (taskSeleccionada != null && taskSeleccionada.getId() != null) {
	    	taskService.eliminar(taskSeleccionada);
	        tasks = taskService.listar();
	        taskSeleccionada = null;
    	}
    }

    public void onRowSelect(SelectEvent event) {
        taskSeleccionada = (TaskDTO) event.getObject();
    }
    
    public void editar() {
    }

	public List<TaskDTO> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskDTO> tasks) {
		this.tasks = tasks;
	}

	public TaskDTO getTaskSeleccionada() {
		return taskSeleccionada;
	}

	public void setTaskSeleccionada(TaskDTO taskSeleccionada) {
		this.taskSeleccionada = taskSeleccionada;
	}
}
