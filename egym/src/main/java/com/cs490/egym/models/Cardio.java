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

import com.cs490.egym.interfaces.ICardioExercise;

@Entity
@Table(name="CARDIO")
public class Cardio implements ICardioExercise {
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
	private Exercise exerciseID;
	
	@Column(name="USER_ID")
	private Integer userID;
	
	@Column(name="TIME", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable=false, insertable=false)	
	private Timestamp date;
	
	protected Cardio() {}
	
	public Cardio(double distance, Integer minutes, Exercise exerciseID, Integer userID, Timestamp date) {
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
