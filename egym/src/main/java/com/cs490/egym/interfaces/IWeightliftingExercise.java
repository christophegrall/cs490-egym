package com.cs490.egym.interfaces;

import com.cs490.egym.enums.WeightTypeEnum;

public interface IWeightliftingExercise extends IExerciseRel {
	public double getWeight();
	public void setWeight(double weight);
	public WeightTypeEnum getWeightType();
	public void setWeightType(WeightTypeEnum weightType);
	public Integer getReps();
	public void setReps(Integer reps);
	public Integer getSets();
	public void setSets(Integer sets);
}
