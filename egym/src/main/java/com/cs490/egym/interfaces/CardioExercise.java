package com.cs490.egym.interfaces;

public interface CardioExercise extends ExerciseRel {
	public double getDistance();
	public void setDistance(double distance);
	public Integer getMinutes();
	public void setMinutes(Integer minutes);
}
