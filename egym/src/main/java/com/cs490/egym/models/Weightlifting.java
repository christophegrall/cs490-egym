package com.cs490.egym.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cs490.egym.enums.WeightTypeEnum;
import com.cs490.egym.interfaces.IWeightliftingExercise;

@Entity
public class Weightlifting implements IWeightliftingExercise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="WEIGHT")
	private double weight;
	
	@Column(name="WEIGHT_TYPE")
	private WeightTypeEnum weightType;
	
	@Column(name="REPS")
	private int reps;
	
	@Column(name="SETS")
	private int sets;
	
	@Column(name="EXERCISE_ID")
	private int exerciseID;
	
	@Column(name="USER_ID")
	private int userID;
	
	@Column(name="TIME", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable=false, insertable=false)	
	private Timestamp date;
	
	protected Weightlifting() {}

	public Weightlifting(double weight, WeightTypeEnum weightType, int reps, int sets, int exerciseID, int userID,
			Timestamp date) {
		this.weight = weight;
		this.weightType = weightType;
		this.reps = reps;
		this.sets = sets;
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
	public double getWeight() {
		return weight;
	}

	@Override
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public WeightTypeEnum getWeightType() {
		return weightType;
	}

	@Override
	public void setWeightType(WeightTypeEnum weightType) {
		this.weightType = weightType;
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
	public String toString() {
		return String.format(
				"Weightlifting [id=%s, weight=%s, weightType=%s, reps=%s, sets=%s, exerciseID=%s, userID=%s, date=%s]",
				id, weight, weightType, reps, sets, exerciseID, userID, date);
	}
}
