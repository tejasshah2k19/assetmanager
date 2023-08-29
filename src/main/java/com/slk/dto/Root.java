package com.slk.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Root {
	private Result result;
	private ArrayList<ResponseDTOList> responseDTOList;
	@JsonIgnore
	private ArrayList<Object> industryList;
	@JsonIgnore
	public boolean isThisEndOfResponse;

	@JsonIgnore
	private Integer totalListSize;

	private LastUpdateTime lastUpdateTime;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public ArrayList<ResponseDTOList> getResponseDTOList() {
		return responseDTOList;
	}

	public void setResponseDTOList(ArrayList<ResponseDTOList> responseDTOList) {
		this.responseDTOList = responseDTOList;
	}

	public ArrayList<Object> getIndustryList() {
		return industryList;
	}

	public void setIndustryList(ArrayList<Object> industryList) {
		this.industryList = industryList;
	}

 

	public Integer getTotalListSize() {
		return totalListSize;
	}

	public void setTotalListSize(Integer totalListSize) {
		this.totalListSize = totalListSize;
	}

	public LastUpdateTime getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(LastUpdateTime lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
