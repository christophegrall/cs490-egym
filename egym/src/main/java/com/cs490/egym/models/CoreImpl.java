package com.cs490.egym.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.cs490.egym.interfaces.CoreExercise;

@Entity
@Table(name="CORE")
public class CoreImpl implements CoreExercise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CORE_ID")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="EXERCISE_ID")
	private ExerciseImpl exerciseID;
	
	@OneToOne
	@JoinColumn(name="USER_ID")
	private User userID;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATE", insertable=false)
	@NotNull
	private Date date;
	
	@Column(name="MINUTES")
	private Integer minutes;
	
	@Column(name="REPS")
	private Integer reps;
	
	@Column(name="SETS")
	private Integer sets;
	
	protected CoreImpl() {}

	public CoreImpl(Integer id, ExerciseImpl exerciseID, User userID, Date date, Integer minutes, Integer reps, Integer sets) {
		this.id = id;
		this.exerciseID = exerciseID;
		this.userID = userID;
		this.date = date;
		this.minutes = minutes;
		this.reps = reps;
		this.sets = sets;
	}
	
	public CoreImpl(ExerciseImpl exerciseID, User userID, Date date, Integer minutes, Integer reps, Integer sets) {
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
	public ExerciseImpl getExerciseID() {
		return exerciseID;
	}

	@Override
	public void setExerciseID(ExerciseImpl exerciseID) {
		this.exerciseID = exerciseID;
	}

	@Override
	public User getUserID() {
		return userID;
	}

	@Override
	public void setUserID(User userID) {
		this.userID = userID;
	}

	@Override
	public Date getDate() {
		return date;
	}
	
	@Override
	public void setDate(Date date) {
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
