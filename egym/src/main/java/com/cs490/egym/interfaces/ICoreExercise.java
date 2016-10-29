package com.cs490.egym.interfaces;

public interface ICoreExercise extends IExerciseRel {
	public Integer getReps();
	public void setReps(Integer reps);
	public Integer getSets();
	public void setSets(Integer sets);
	public Integer getMinutes();
	public void setMinutes(Integer minutes);
}
