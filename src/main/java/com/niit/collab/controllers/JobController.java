package com.niit.collab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collab.dao.BlogDAO;
import com.niit.collab.dao.JobDAO;
import com.niit.collab.model.Blog;
import com.niit.collab.model.Job;

@RestController
public class JobController {

@Autowired
private JobDAO jobDAO;

@PostMapping(value="/createjob")
public ResponseEntity<Job> addjob(@RequestBody Job job){
 System.out.println("hello");
 jobDAO.saveOrUpdate(job);
 return new ResponseEntity<Job>(job,HttpStatus.OK); 
}

@GetMapping(value="/job")
public ResponseEntity<List<Job>> listjob(){
 System.out.println("list of job");
 List<Job> job =jobDAO.list();
 return new ResponseEntity<List<Job>>(job,HttpStatus.OK);
}

@DeleteMapping(value="/deletejob/{jobid}")
public ResponseEntity<Job> deletejob(Job job,@PathVariable("jobid") int jobid){
 Job job1=jobDAO.get(jobid);
 jobDAO.delete(job1);
 return new ResponseEntity<Job>(job,HttpStatus.OK);
}
}