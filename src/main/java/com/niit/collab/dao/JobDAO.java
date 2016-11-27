package com.niit.collab.dao;

import java.util.List;

import com.niit.collab.model.Blog;
import com.niit.collab.model.Job;

public interface JobDAO {
	public boolean saveOrUpdate(Job job);
	public boolean delete(Job job);
	public Job get(int id);
	public List<Job> list();

}
