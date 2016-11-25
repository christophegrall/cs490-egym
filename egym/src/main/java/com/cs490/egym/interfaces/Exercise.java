package com.cs490.egym.interfaces;

import com.cs490.egym.enums.DifficultyEnum;
import com.cs490.egym.enums.TypeEnum;

public interface Exercise {
	public Integer getId();
	public void setId(Integer id);
	public String getName();
	public void setName(String name);
	public String getDescription();
	public void setDescription(String description);
	public DifficultyEnum getDifficulty();
	public void setDifficulty(DifficultyEnum difficulty);
	public TypeEnum getType();
	public void setType(TypeEnum type);
	public Integer getUserId();
	public void setUserId(Integer userId);
}
