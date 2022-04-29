package com.jobType.model;

import java.util.List;



public class JobService {

	private JobTypeDAO_interface dao;

	public JobService() {
		dao = new JobTypeDAO();
	}

	public void addJobType(String job_typename) {

		dao.insert(job_typename);

	}

	public JobTypeVO updateJobType(Integer job_typenum, String job_typename) {

		JobTypeVO jobTypeVO = new JobTypeVO();

		jobTypeVO.setJob_typenum(job_typenum);
		jobTypeVO.setJob_typename(job_typename);
		
		dao.update(jobTypeVO);
		return jobTypeVO;
	}

	public void deleteJobType(Integer job_typenum) {
		dao.delete(job_typenum);
	}

	public JobTypeVO getOneJobType(Integer job_typenum) {
		return dao.findByPrimaryKey(job_typenum);
	}

	public List<JobTypeVO> getAll() {
		return dao.getAll();
	}

}
