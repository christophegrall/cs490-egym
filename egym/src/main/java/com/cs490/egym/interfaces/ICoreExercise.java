package com.cs490.egym.interfaces;

public interface ICoreExercise extends IExerciseRel {
	public int getReps();
	public void setReps(int reps);
	public int getSets();
	public void setSets(int sets);
	public int getMinutes();
	public void setMinutes(int minutes);
}
