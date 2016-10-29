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

import com.cs490.egym.enums.WeightTypeEnum;
import com.cs490.egym.interfaces.IWeightliftingExercise;

@Entity
@Table(name="WEIGHTLIFTING")
public class Weightlifting implements IWeightliftingExercise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="WEIGHTLIFTING_ID")
	private Integer id;
	
	@Column(name="WEIGHT")
	private double weight;
	
	@Column(name="WEIGHT_TYPE")
	private WeightTypeEnum weightType;
	
	@Column(name="REPS")
	private Integer reps;
	
	@Column(name="SETS")
	private Integer sets;
	
	@OneToOne
	@JoinColumn(name="EXERCISE_ID")
	private Exercise exerciseID;
	
	//TODO:Datatype needs to be User
	//TODO:Add OneToOne & JoinColumn
	@Column(name="USER_ID")
	private Integer userID;
	
	@Column(name="TIME", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable=false, insertable=false)	
	private Timestamp date;
	
	protected Weightlifting() {}

	public Weightlifting(double weight, WeightTypeEnum weightType, Integer reps, Integer sets, Exercise exerciseID, Integer userID,
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
	public String toString() {
		return String.format(
				"Weightlifting [id=%s, weight=%s, weightType=%s, reps=%s, sets=%s, exerciseID=%s, userID=%s, date=%s]",
				id, weight, weightType, reps, sets, exerciseID, userID, date);
	}
}
