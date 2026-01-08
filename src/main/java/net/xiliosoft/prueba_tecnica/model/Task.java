package net.xiliosoft.prueba_tecnica.model;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TASKS",
		uniqueConstraints = @UniqueConstraint(columnNames = "title")
)
@SequenceGenerator(
        name = "taskSeq",
        sequenceName = "TASKS_SEQ",
        allocationSize = 1
)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskSeq")
    @Column(name = "ID")
    private Long id;

	@NotBlank(message = "El título es obligatorio")
    @Size(max = 100, message = "El título no debe ser mayor a 100 caracteres")
    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;

    @Size(max = 500, message = "La descripción no debe ser mayor a 500 caracteres")
    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @NotNull
    @FutureOrPresent(message = "La fecha no puede ser pasada")
    @Temporal(TemporalType.DATE)
    @Column(name = "DUE_DATE")
    private Date dueDate;

    @Column(name = "COMPLETED")
    private Boolean completed = false;

    @Column(name = "CREATED_AT", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        if (completed == null) {
            completed = false;
        }
    }

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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
