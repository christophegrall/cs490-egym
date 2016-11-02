package com.cs490.egym.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.cs490.egym.enums.WeightTypeEnum;
import com.cs490.egym.interfaces.WeightliftingExercise;

@Entity
@Table(name="WEIGHTLIFTING")
public class WeightliftingImpl implements WeightliftingExercise {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="WEIGHTLIFTING_ID")
	private Integer id;
	
	@Column(name="WEIGHT")
	private double weight;
	
	@Column(name="WEIGHT_TYPE")
	@Enumerated(EnumType.STRING)
	private WeightTypeEnum weightType;
	
	@Column(name="REPS")
	private Integer reps;
	
	@Column(name="SETS")
	private Integer sets;
	
	@OneToOne
	@JoinColumn(name="EXERCISE_ID")
	private ExerciseImpl exerciseID;
	
	//TODO:Datatype needs to be User
	//TODO:Add OneToOne & JoinColumn
	@Column(name="USER_ID")
	private Integer userID;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATE", insertable=false)
	@NotNull
	private Date date;
	
	protected WeightliftingImpl() {}
	
	public WeightliftingImpl(Integer id, double weight, WeightTypeEnum weightType, Integer reps, Integer sets, ExerciseImpl exerciseID, Integer userID,
			Date date) {
		this.id = id;
		this.weight = weight;
		this.weightType = weightType;
		this.reps = reps;
		this.sets = sets;
		this.exerciseID = exerciseID;
		this.userID = userID;
		this.date = date;
	}

	public WeightliftingImpl(double weight, WeightTypeEnum weightType, Integer reps, Integer sets, ExerciseImpl exerciseID, Integer userID,
			Date date) {
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
	public ExerciseImpl getExerciseID() {
		return exerciseID;
	}

	@Override
	public void setExerciseID(ExerciseImpl exerciseID) {
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
	public Date getDate() {
		return date;
	}

	@Override
	public void setDate(Date date) {
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
