package com.jobType.model;

import java.io.Serializable;

public class JobTypeVO implements Serializable{
	private Integer job_typenum;
	private String job_typename;
	
	@Override
	public String toString() {
		return "JobTypeVO [job_typenum=" + job_typenum + ", job_typename=" + job_typename + "]";
	}
	public Integer getJob_typenum() {
		return job_typenum;
	}
	public void setJob_typenum(Integer job_typenum) {
		this.job_typenum = job_typenum;
	}
	public String getJob_typename() {
		return job_typename;
	}
	public void setJob_typename(String job_typename) {
		this.job_typename = job_typename;
	}
	

}
