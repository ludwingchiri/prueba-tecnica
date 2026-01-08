package net.xiliosoft.prueba_tecnica.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TaskDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String title;
    private String description;
    private Date dueDate;
    private Boolean completed;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskDTO)) return false;
        TaskDTO task = (TaskDTO) o;
        return id != null && id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

