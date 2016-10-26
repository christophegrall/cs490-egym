package com.cs490.egym.interfaces;

import java.sql.Timestamp;

public interface IExerciseRel {
	public int getID();
	public void setID(int id);
	public int getExerciseID();
	public void setExerciseID(int exerciseID);
	public int getUserID();
	public void setUserID(int userID);
	public Timestamp getDate();
	public void setDate(Timestamp date);
}
