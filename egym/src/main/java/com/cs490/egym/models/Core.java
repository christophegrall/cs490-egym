package com.cs490.egym.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cs490.egym.interfaces.ICoreExercise;

@Entity
public class Core implements ICoreExercise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="EXERCISE_ID")
	private int exerciseID;
	
	@Column(name="USER_ID")
	private int userID;
	
	@Column(name="TIME", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable=false, insertable=false)	
	private Timestamp date;
	
	@Column(name="MINUTES")
	private int minutes;
	
	@Column(name="REPS")
	private int reps;
	
	@Column(name="SETS")
	private int sets;
	
	protected Core() {}

	public Core(int exerciseID, int userID, Timestamp date, int minutes, int reps, int sets) {
		this.exerciseID = exerciseID;
		this.userID = userID;
		this.date = date;
		this.minutes = minutes;
		this.reps = reps;
		this.sets = sets;
	}

	@Override
	public int getID() {
		return id;
	}

	@Override
	public void setID(int id) {
		this.id = id;
	}

	@Override
	public int getExerciseID() {
		return exerciseID;
	}

	@Override
	public void setExerciseID(int exerciseID) {
		this.exerciseID = exerciseID;
	}

	@Override
	public int getUserID() {
		return userID;
	}

	@Override
	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public Timestamp getDate() {
		return date;
	}
	
	@Override
	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public int getReps() {
		return reps;
	}

	@Override
	public void setReps(int reps) {
		this.reps = reps;
	}

	@Override
	public int getSets() {
		return sets;
	}

	@Override
	public void setSets(int sets) {
		this.sets = sets;
	}

	@Override
	public int getMinutes() {
		return minutes;
	}

	@Override
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	@Override
	public String toString() {
		return String.format("Core [id=%s, exerciseID=%s, userID=%s, date=%s, minutes=%s, reps=%s, sets=%s]", id,
				exerciseID, userID, date, minutes, reps, sets);
	}
}
