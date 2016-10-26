package com.cs490.egym.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cs490.egym.interfaces.ICardioExercise;

@Entity
public class Cardio implements ICardioExercise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="DISTANCE")
	private double distance;
	
	@Column(name="MINUTES")
	private int minutes;
	
	@Column(name="EXERCISE_ID")
	private int exerciseID;
	
	@Column(name="USER_ID")
	private int userID;
	
	@Column(name="TIME", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable=false, insertable=false)	
	private Timestamp date;
	
	protected Cardio() {}
	
	public Cardio(double distance, int minutes, int exerciseID, int userID, Timestamp date) {
		this.distance = distance;
		this.minutes = minutes;
		this.exerciseID = exerciseID;
		this.userID = userID;
		this.date = date;
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
	public double getDistance() {
		return distance;
	}

	@Override
	public void setDistance(double distance) {
		this.distance = distance;
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
		return String.format("Cardio [id=%s, distance=%s, minutes=%s, exerciseID=%s, userID=%s, date=%s]", id, distance,
				minutes, exerciseID, userID, date);
	}
}
