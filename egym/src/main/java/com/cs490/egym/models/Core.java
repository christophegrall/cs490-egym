package com.cs490.egym.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cs490.egym.interfaces.ICoreExercise;

@Entity
@Table(name="CORE")
public class Core implements ICoreExercise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CORE_ID")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="EXERCISE_ID")
	private Exercise exerciseID;
	
	@Column(name="USER_ID")
	private Integer userID;
	
	@Column(name="TIME", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable=false, insertable=false)	
	private Timestamp date;
	
	@Column(name="MINUTES")
	private Integer minutes;
	
	@Column(name="REPS")
	private Integer reps;
	
	@Column(name="SETS")
	private Integer sets;
	
	protected Core() {}

	public Core(Exercise exerciseID, Integer userID, Timestamp date, Integer minutes, Integer reps, Integer sets) {
		this.exerciseID = exerciseID;
		this.userID = userID;
		this.date = date;
		this.minutes = minutes;
		this.reps = reps;
		this.sets = sets;
	}

	@Override
	public Integer getID() {
		return id;
	}

	@Override
	public void setID(Integer id) {
		this.id = id;
	}

	@Override
	public Exercise getExerciseID() {
		return exerciseID;
	}

	@Override
	public void setExerciseID(Exercise exerciseID) {
		this.exerciseID = exerciseID;
	}

	@Override
	public Integer getUserID() {
		return userID;
	}

	@Override
	public void setUserID(Integer userID) {
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
	public Integer getReps() {
		return reps;
	}

	@Override
	public void setReps(Integer reps) {
		this.reps = reps;
	}

	@Override
	public Integer getSets() {
		return sets;
	}

	@Override
	public void setSets(Integer sets) {
		this.sets = sets;
	}

	@Override
	public Integer getMinutes() {
		return minutes;
	}

	@Override
	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	@Override
	public String toString() {
		return String.format("Core [id=%s, exerciseID=%s, userID=%s, date=%s, minutes=%s, reps=%s, sets=%s]", id,
				exerciseID, userID, date, minutes, reps, sets);
	}
}
