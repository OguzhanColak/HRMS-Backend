package main.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import main.hrms.business.abstracts.JobSeekerService;
import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("api/jobseekers")
@CrossOrigin
public class JobSeekerController {
	
	private JobSeekerService jobSeekerService;

	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll(){
		
		return jobSeekerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker){
		  return this.jobSeekerService.add(jobSeeker);
	}
}
