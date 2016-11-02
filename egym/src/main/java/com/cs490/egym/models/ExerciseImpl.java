package com.cs490.egym.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.cs490.egym.enums.DifficultyEnum;
import com.cs490.egym.enums.TypeEnum;
import com.cs490.egym.interfaces.Exercise;

@Entity
@Table(name="EXERCISE")
public class ExerciseImpl implements Exercise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EXERCISE_ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="DIFFICULTY")
	@Enumerated(EnumType.STRING)
	private DifficultyEnum difficulty;
	
	@Column(name="TYPE")
	@Enumerated(EnumType.STRING)
	private TypeEnum type;
	
	@Column(name="BUILTIN")
	@NotNull
	private boolean builtin;
	
	protected ExerciseImpl() {}

	public ExerciseImpl(Integer id, String name, String description, DifficultyEnum difficulty, TypeEnum type,
			boolean builtin) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.difficulty = difficulty;
		this.type = type;
		this.builtin = builtin;
	}
	
	public ExerciseImpl(String name, String description, DifficultyEnum difficulty, TypeEnum type,
			boolean builtin) {
		this.name = name;
		this.description = description;
		this.difficulty = difficulty;
		this.type = type;
		this.builtin = builtin;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public DifficultyEnum getDifficulty() {
		return difficulty;
	}

	@Override
	public void setDifficulty(DifficultyEnum difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public TypeEnum getType() {
		return type;
	}

	@Override
	public void setType(TypeEnum type) {
		this.type = type;
	}

	@Override
	public boolean getBuiltin() {
		return builtin;
	}

	@Override
	public void setBuiltin(boolean builtin) {
		this.builtin = builtin;
	}

	@Override
	public String toString() {
		return String.format("Exercise [id=%s, name=%s, description=%s, difficulty=%s, type=%s, builtin=%s]", id, name,
				description, difficulty, type, builtin);
	}
}
