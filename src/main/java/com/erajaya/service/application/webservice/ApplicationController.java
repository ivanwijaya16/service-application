package com.erajaya.service.application.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.erajaya.service.application.entity.Application;
import com.erajaya.service.application.repository.ApplicationRepository;

import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="ApplicationTypeMicroservice", description="Operations pertaining to application type in Application", tags = { "Application Type" })
@RequestMapping("/api/v1")
@RestController
public class ApplicationController {
	@Autowired
	private ApplicationRepository repository;
	
	@ApiOperation(value = "View a list of available application Type", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@GetMapping("/application")
	public List<Application> getallapplication(){
		return repository.findAll();
	}
	
	@GetMapping("/application/{id}")
	public Optional<com.erajaya.service.application.entity.Application> findbyid(String id){
		return repository.findById(id);
	}
	
	@ApiOperation(value = "View a list of available application Type", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@PostMapping("/application")
	public Application newApplication(@RequestBody Application newApplication) {
		return repository.save(newApplication);
	}
	
	@PutMapping("/application/{id}")
	   Application EditApplication(@RequestBody Application newApplication, @PathVariable String id) {

	     return repository.findById(id)
	       .map(Application -> {
	    	   Application.setId(newApplication.getId());
	    	   Application.setName(newApplication.getName());
	    	   Application.setIsdelete(newApplication.isIsdelete());
	    	   Application.setCreatedby(newApplication.getCreatedby());
	    	   Application.setCreateddate(newApplication.getCreateddate());
	    	   Application.setCreatedfrom(newApplication.getCreatedfrom());
	    	   Application.setModifiedby(newApplication.getModifiedby());
	    	   Application.setModifieddate(newApplication.getModifieddate());
	    	   Application.setModifiedfrom(newApplication.getModifiedfrom());
	         return repository.save(Application);
	       })
	       .orElseGet(() -> {
	    	   newApplication.setId(id);
	         return repository.save(newApplication);
	       });
	   }
	 
	  @DeleteMapping("/Application/{id}")
	   void Application(@PathVariable String id) {
	     repository.deleteById(id);
	   }

}
