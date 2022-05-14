package com.jobType.model;

import java.util.List;


public interface JobTypeDAO_interface {
    public void insert(String job_typename);
    public void update(JobTypeVO jobType);
    public void delete(Integer job_typenum);
    public JobTypeVO findByPrimaryKey(Integer job_typenum);
    public List<JobTypeVO> getAll();

}
