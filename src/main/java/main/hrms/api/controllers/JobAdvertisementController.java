package main.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import main.hrms.business.abstracts.JobAdvertisementService;
import main.hrms.core.utilities.results.DataResult;
import main.hrms.core.utilities.results.Result;
import main.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementController {
   private JobAdvertisementService jobAdvertisementService;
   @Autowired
   public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
	  super();
	  this.jobAdvertisementService = jobAdvertisementService;
   }
   @GetMapping("/getall")
   public DataResult<List<JobAdvertisement>> getAll(){
	   return this.jobAdvertisementService.getAll();
   }
   @GetMapping("/getbyactivestatus")
   public DataResult<List<JobAdvertisement>> getByActiveStatus(){
	   return this.jobAdvertisementService.getByActiveStatus();
   }
   @GetMapping("/getallsortedbydate")
   public DataResult<List<JobAdvertisement>> getAllSortedByDate(){
	   return this.jobAdvertisementService.getAllSortedByDate();
   }
   @GetMapping("/getbyemployerid/{id}")
   public DataResult<List<JobAdvertisement>> getByEmployerId(@PathVariable(name="id") int id){
	   return this.jobAdvertisementService.getByEmployerId(id);
   }
   @GetMapping("/getbyid/{id}")
   public DataResult<JobAdvertisement> getById(@PathVariable int id){
 	  return this.jobAdvertisementService.getById(id);
   }
   @PostMapping("/add")
   public Result add(@RequestBody JobAdvertisement jobAdv){
 	  return this.jobAdvertisementService.add(jobAdv);
   }
   @PostMapping("/makepassive/{id}")
   public Result makePassive(@PathVariable int id){
 	  return this.jobAdvertisementService.makePassive(id);
   }
   @PostMapping("/update")
   public Result update(@RequestBody JobAdvertisement jobAdv){
 	  return this.jobAdvertisementService.update(jobAdv);
   }
   @PostMapping("/delete/{id}")
   public Result delete(@PathVariable int id){
 	  return this.jobAdvertisementService.delete(id);
   }

  
}
