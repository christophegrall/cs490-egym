package com.cs490.egym.interfaces;

import java.util.Date;

import com.cs490.egym.models.ExerciseImpl;

public interface ExerciseRel {
	public Integer getID();
	public void setID(Integer id);
	public ExerciseImpl getExerciseID();
	public void setExerciseID(ExerciseImpl exerciseID);
	public Integer getUserID();
	public void setUserID(Integer userID);
	public Date getDate();
	public void setDate(Date date);
}
