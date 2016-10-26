package com.cs490.egym.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cs490.egym.enums.DifficultyEnum;
import com.cs490.egym.enums.TypeEnum;
import com.cs490.egym.interfaces.IExercise;

@Entity
public class Exercise implements IExercise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="DIFFICULTY")
	private DifficultyEnum difficulty;
	
	@Column(name="TYPE")
	private TypeEnum type;
	
	@Column(name="BUILTIN")
	private boolean builtin;
	
	protected Exercise() {}

	public Exercise(String name, String description, DifficultyEnum difficulty, TypeEnum type,
			boolean builtin) {
		this.name = name;
		this.description = description;
		this.difficulty = difficulty;
		this.type = type;
		this.builtin = builtin;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
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
