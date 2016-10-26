package com.cs490.egym.interfaces;

public interface ICardioExercise extends IExerciseRel {
	public double getDistance();
	public void setDistance(double distance);
	public int getMinutes();
	public void setMinutes(int minutes);
}
