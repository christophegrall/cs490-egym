package com.cs490.egym.interfaces;

import java.sql.Timestamp;

import com.cs490.egym.models.Exercise;

public interface IExerciseRel {
	public Integer getID();
	public void setID(Integer id);
	public Exercise getExerciseID();
	public void setExerciseID(Exercise exerciseID);
	public Integer getUserID();
	public void setUserID(Integer userID);
	public Timestamp getDate();
	public void setDate(Timestamp date);
}
