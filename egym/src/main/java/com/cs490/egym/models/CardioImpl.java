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

import com.cs490.egym.interfaces.CardioExercise;

@Entity
@Table(name="CARDIO")
public class CardioImpl implements CardioExercise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CARDIO_ID")
	private Integer id;
	
	@Column(name="DISTANCE")
	private double distance;
	
	@Column(name="MINUTES")
	private Integer minutes;
	
	@OneToOne
	@JoinColumn(name="EXERCISE_ID")
	private ExerciseImpl exerciseID;
	
	@OneToOne
	@JoinColumn(name="USER_ID")
	private User userID;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATE")
	@NotNull
	private Date date;
	
	protected CardioImpl() {}
	
	public CardioImpl(Integer id, double distance, Integer minutes, ExerciseImpl exerciseID, User userID, Date date) {
		this.id = id;
		this.distance = distance;
		this.minutes = minutes;
		this.exerciseID = exerciseID;
		this.userID = userID;
		this.date = date;
	}
	
	public CardioImpl(double distance, Integer minutes, ExerciseImpl exerciseID, User userID, Date date) {
		this.distance = distance;
		this.minutes = minutes;
		this.exerciseID = exerciseID;
		this.userID = userID;
		this.date = date;
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
	public double getDistance() {
		return distance;
	}

	@Override
	public void setDistance(double distance) {
		this.distance = distance;
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
		return String.format("Cardio [id=%s, distance=%s, minutes=%s, exerciseID=%s, userID=%s, date=%s]", id, distance,
				minutes, exerciseID, userID, date);
	}
}
