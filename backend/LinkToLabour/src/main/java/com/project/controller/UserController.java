package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pojos.AssignedWork;
import com.project.pojos.Bidding;
import com.project.pojos.Contractor;
import com.project.pojos.Labour;
import com.project.pojos.Review;
import com.project.pojos.Role;
import com.project.pojos.Status;
import com.project.pojos.User;
import com.project.pojos.Work;
import com.project.service.AssignedWorkService;
import com.project.service.BiddingService;
import com.project.service.ContractorService;
import com.project.service.LabourService;
import com.project.service.ReviewService;
import com.project.service.UserService;
import com.project.service.WorkService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	LabourService labourService;
	@Autowired
	ContractorService contractorService;
	@Autowired
	WorkService workService;
	@Autowired
	AssignedWorkService AssignedWorkService;
	@Autowired
	BiddingService biddingService;
	@Autowired
	ReviewService reviewService;

	@PostMapping(path = "/register", consumes = "application/json")
	public ResponseEntity<HttpStatus> registerUser(@RequestBody User user) {
		try {

			Role role = user.getRole();

			if (role == Role.LABOUR) {

				Labour labour = new Labour();
				this.userService.addUser(user);
				labour.setUser(user);
				this.labourService.addLabour(labour);

			} else if (role == Role.CONTRACTOR) {
				Contractor contractor = new Contractor();
				this.userService.addUser(user);
				contractor.setUser(user);
				this.contractorService.addContractor(contractor);
			} else {
				this.userService.addUser(user);
			}

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// to get all work by uid
	@GetMapping("/getworkbyuid/{userId}")
	public List<Work> getWorkByUserId(@PathVariable int userId) {

		return this.workService.getworkByUserID(userId);

	}

	// to get all contractor for pincode
	@GetMapping("/getcontractorsbypincode/{pincode}")
	public List<Contractor> getAllcContractorByPincode(@PathVariable String pincode) {
		return this.contractorService.getAllcContractorByPincode(pincode);
	}

	// to get all Contractor dor pincode
	@GetMapping("/getlabourbypincode/{pincode}")
	public List<Labour> getAllLabourByPIincode(@PathVariable String pincode) {
		return this.labourService.getAllLaboursByPincode(pincode);
	}

	// update profile
	@PostMapping("/updateuserprofile")
	public String UpdateUserProfile(@RequestBody User user) {
		this.userService.addUser(user);
		return "Updated Succefully";
	}

	// user profiledeletion
	@DeleteMapping("/deleteuser/{userid}")
	public String deleteUser(@PathVariable int userid) {
		this.userService.deleteUser(userid);
		return "Deleted Succefully";
	}

	// AddWork by UserId
	@PostMapping("/addworkbyuser/{userId}")
	public String addWorkByUserId(@RequestBody Work work, @PathVariable int userId) {
		User user = this.userService.getUserById(userId);
		work.setUser(user);
		this.workService.addwork(work);

		return "Added Succesfully";
	}

	// get bidding by work id
	@GetMapping("/getbiddingsbyworkId/{workId}")
	public List<Bidding> getAllBiddingListForWorkId(@PathVariable int workId) {
		return this.biddingService.getAllbyWorkId(workId);
	}

	
	// to add and update Assigned Work
	@GetMapping("/addtoassignedwork/{biddingid}")
	public String addassignedWork(@RequestBody Work work, @PathVariable int biddingid) {

		this.biddingService.updateBidStatus(biddingid);
		Bidding bidding = this.biddingService.getBiddingById(biddingid);
		
		AssignedWork assignedWork = new AssignedWork();
		
		assignedWork.setBidding(bidding);
		assignedWork.setWork(work);
		assignedWork.setStatus(Status.ONGOING);
		return "Assigned Work Added";
		
	}
	
	//Get allAssigned Work
	@GetMapping("/getallAssignedWork")
	public List<AssignedWork> get()
	{
		return this.AssignedWorkService.getAllAssignedWork();
	}

	//get assigned work with userID
	@GetMapping("/getassignedworkbyuserid/{userId}")
	public List<AssignedWork> getAssignedWorkByUserId(@PathVariable int userId)
	{
		
		
		return this.AssignedWorkService.getAssignedWorkByUserId(userId);
	}
	
	
	
	//get assigned work with work id
	@GetMapping("/getassignedworkbyworkid/{workId}")
	public AssignedWork getAssignedWorkByWorkId(@PathVariable int workId) 
	{
		return this.AssignedWorkService.getAssignedWorkByWorkId(workId);
	}
	
	
	//add review for labour
	@PostMapping("/addreviewforlabour/{userId}/{labourId}")
	public String addReviewlabour(@RequestBody Review review, @PathVariable int userId, @PathVariable int labourId)
	{
		User user = this.userService.getUserById(userId);
		Labour labour  =this.labourService.getLabourById(labourId);
		review.setUser(user);
		review.setLabour(labour);
	
		this.reviewService.addReview(review);
		return "Review Added Successfully";
	}
	
	//add review for contrctor
	@PostMapping("/addreviewforcontractor/{userId}/{contractorId}")
	public String addReviewcontractor(@RequestBody Review review, @PathVariable int userId, @PathVariable int contractorId)
	{
		User user = this.userService.getUserById(userId);
		Contractor contractor  =this.contractorService.getContractorByContractorId(contractorId);
		review.setUser(user);
		review.setContractor(contractor);
	
		this.reviewService.addReview(review);
		return "Review Added Successfully";
	}
	
	//get all reviews of user
	@GetMapping("/getreviewbyuserid/{userid}")
	public List<Review> getAllReviewByUserId(@PathVariable int userid)
	{
		
		return this.reviewService.getReviewsByUserId(userid);
	}
	
	
	
}


















/*
 * @PostMapping("/assignwork") public String AddToAssignedWork(@RequestBody
 * AssignedWork)
 */

//demo trial code
/*
 * @GetMapping("/getwork") public List<Work> getWorkByUser() {
 * 
 * 
 * return this.workService.getAllWork();
 * 
 * 
 * }
 */

/*
 * //Demo Method
 * 
 * @GetMapping("/listwork/{userId}") public List<Work> DemoMethod(@PathVariable
 * int userId) {
 * 
 * return this.workService.getworkByUserID(userId);
 * 
 * }
 */
