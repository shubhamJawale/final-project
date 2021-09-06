package com.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.LabourDto;
import com.project.dto.AssignedWorkDto;
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


	// to get all work by uid
	@GetMapping("/getworkbyuid/{userId}")
	public List<Work> getWorkByUserId(@PathVariable int userId) {

		return this.workService.getworkByUserID(userId);

	}

	// to get all contractor for pincode but this will return list of users
	@GetMapping("/getcontractorsbypincode/{userId}")
	public List<User> getAllcContractorByPincode(@PathVariable int userId) {
		User user = this.userService.getUserById(userId);
		String pincode = user.getPincode();
		List<Contractor> listofContractor = this.contractorService.getAllcContractorByPincode(pincode);
		ArrayList<User> userList = new ArrayList<User>();
		ListIterator<Contractor> pointer = listofContractor.listIterator();
		while (pointer.hasNext())
		{
			Contractor contractor1 = (Contractor) pointer.next();
			User user1 = this.userService.getUserById(contractor1.getUser().getUserId());
			userList.add(user1);
			
		}
		return userList;
	
	}
	
	//this will return only contractors and their proffesional detals
	@GetMapping("/getcontractorsbypincodec/{userId}")
	public List<Contractor> getAllcContractorByPincodec(@PathVariable int userId) {
		User user = this.userService.getUserById(userId);
		String pincode = user.getPincode();
		return this.contractorService.getAllcContractorByPincode(pincode);
	
	}
	// to get all Contractor dor pincode 
		@GetMapping("/getlabourbypincode/{userId}")
		public List<User> getAllLabourByPincode(@PathVariable int userId) {
			User user = this.userService.getUserById(userId);
			String pincode = user.getPincode();
			List<Labour> labourList = this.labourService.getAllLaboursByPincode(pincode);
			ArrayList<User> userList = new ArrayList<User>();
			ListIterator<Labour> pointer = labourList.listIterator();
			while (pointer.hasNext())
			{
				Labour contractor1 = (Labour) pointer.next();
				User user1 = this.userService.getUserById(contractor1.getUser().getUserId());
				userList.add(user1);
				
			}
			return userList;
			
		}
	
	

	// to get all Contractor dor pincode
	@GetMapping("/getlabourbypincodel/{userId}")
	public List<Labour> getAllLabourByPIincode(@PathVariable int userId) {
		User user = this.userService.getUserById(userId);
		String pincode = user.getPincode();
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
		work.setStatus(Status.PENDING);
		this.workService.addwork(work);

		return "Added Succesfully";
	}

	// get bidding by work id
	@GetMapping("/getbiddingsbyworkId/{workId}")
	public List<Bidding> getAllBiddingListForWorkId(@PathVariable int workId) {
		return this.biddingService.getAllbyWorkId(workId);
	}

	
	// to add and update Assigned Work
	@PostMapping("/addtoassignedwork/{biddingid}")
	public String addassignedWork(@RequestBody Work work, @PathVariable int biddingid) {
		/////ith error ahe persistent wala
		
		
		Bidding	bidding = this.biddingService.getBiddingById(biddingid);
		bidding.setStatus(Status.ACCEPTED);
		this.biddingService.AddBidding(bidding);
		
		Work work1 = this.workService.getWorkByWorkId(bidding.getWork().getWorkId());
		
		work1.setStatus(Status.ONGOING);
		this.workService.addwork(work1);
		
		
		AssignedWork aw = new AssignedWork();
		aw.setWork(work1);
		aw.setBidding(bidding);
		aw.setStatus(Status.ONGOING);
		this.AssignedWorkService.addAssignedWork(aw);
		
		return "Added Successfully!!!";
		
		/*
		 * //this.biddingService.updateBidStatus(biddingid); Bidding bidding =
		 * this.biddingService.getBiddingById(biddingid);
		 * work.setStatus(Status.ONGOING); //List<Bidding> biiddinglist =
		 * work.getBiddingList(); //biiddinglist.add(bidding);
		 * //work.setBiddingList(biiddinglist); //this.workService.addwork(work);
		 * AssignedWork assignedWork = new AssignedWork();
		 * bidding.setStatus(Status.ACCEPTED); this.biddingService.AddBidding(bidding);
		 * assignedWork.setBidding(bidding); assignedWork.setWork(work);
		 * assignedWork.setStatus(Status.ONGOING);
		 */
		
		/*
		 * this.AssignedWorkService.addAssignedWork(assignedWork);
		 * 
		 * return "Assigned Work Added";
		 */
		
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
	
	
	///////////////////////////////////////////////////================================
	
	
	
	//getAssignedWorkByUserId()
	
	@GetMapping("/getalldata/AssignedWork/{userId}")
	public List<AssignedWorkDto> getalldataAssignedWorkById(@PathVariable int userId)
	{
		List<AssignedWork> aw = this.AssignedWorkService.getAssignedWorkByUserId(userId);
		List<AssignedWorkDto> asw = new ArrayList<AssignedWorkDto>();
		ListIterator<AssignedWork> pt1 = aw.listIterator();
		while(pt1.hasNext())
		{
			AssignedWork aw1 = (AssignedWork)pt1.next();
			AssignedWorkDto asw1 = new AssignedWorkDto();
			asw1.setAssignedWorkId(aw1.getAssignedWorkId());
			asw1.setAstatus(aw1.getStatus());
			asw1.setBiddingId(aw1.getBidding().getBiddingId());
			asw1.setBamount(aw1.getBidding().getAmount());
			asw1.setBdescription(aw1.getBidding().getDescription());
			asw1.setBfromDate(aw1.getBidding().getFromDate());
			asw1.setBtoDate(aw1.getBidding().getToDate());
			if(aw1.getBidding().getContractor()!=null) {
			asw1.setContractorId(aw1.getBidding().getContractor().getContractorId());}
			if(aw1.getBidding().getLabour()!=null) {
			asw1.setLabourId(aw1.getBidding().getLabour().getLabourId());}
			asw1.setDescription(aw1.getWork().getDescription());
			asw1.setExpectedAmount(aw1.getWork().getExpectedAmount());
			asw1.setFromDate(aw1.getWork().getFromDate());
			asw1.setPinCode(aw1.getWork().getPinCode());
			asw1.setToDate(aw1.getWork().getToDate());
			asw1.setTitle(aw1.getWork().getTitle());
			asw1.setWorkType(aw1.getWork().getWorkType());
			asw1.setWorkId(aw1.getWork().getWorkId());
			asw1.setWorkType(aw1.getWork().getWorkType());
			asw1.setWstatus(aw1.getWork().getStatus());
			asw1.setUid(userId);
			asw.add(asw1);
			
			
		}
		
		return asw;
		
	}
	
	
	@GetMapping("/getAssignedworkByAswId/{awid}")
	public AssignedWork getoneAssignedWork(@PathVariable int awid)
	{
		return this.AssignedWorkService.getAssignedWorkByAssignedWorkId(awid);
	}
	
	@GetMapping("/updateAssigenedWorkByawId/{awid}")
	public void updateStatusawd(@PathVariable int awid) 
	{
		
		AssignedWork aw2 = this.AssignedWorkService.getAssignedWorkByAssignedWorkId(awid);
		aw2.setStatus(Status.COMPLETED);
		this.AssignedWorkService.addAssignedWork(aw2);
		Work work = this.workService.getWorkByWorkId(aw2.getWork().getWorkId());
		work.setStatus(Status.COMPLETED);
		this.workService.addwork(work);
		
	}
	
	
	@GetMapping("/getWorkByWorkId/{workId}")
	public Work getWorkByWorkId(@PathVariable int workId)
	{
		return this.workService.getWorkByWorkId(workId);
	}
	
	@GetMapping("/getContractorByContractorId/{contractorId}")
	public Contractor getcontractorByContractorId(@PathVariable int contractorId)
	{
		
		return this.contractorService.getContractorByContractorId(contractorId);
		
	}	
	
	@GetMapping ("/getContractorByUSerId/{userId}")
	public Contractor getContractorByuserId(@PathVariable int userId) 
	{
		return this.contractorService.getContractorByUserId(userId);
	}
	
	

	@GetMapping ("/getLabourByUSerId/{userId}")
	public LabourDto getlabourByuserIdId(@PathVariable int userId) 
	{
	LabourDto l = new LabourDto();	
	Labour labour =	this.labourService.getLbaourByUserId(userId);
	l.setLabourId(labour.getLabourId());
	if(labour.getContractor()!=null)
	l.setContractorId(labour.getContractor().getContractorId());
	l.setUserId(labour.getUser().getUserId());
	
	return l;
	
	}
	
	
	@GetMapping("/getUserbyUid/{userId}")
	public User getUserbyUid(@PathVariable int userId) 
	{
		return this.userService.getUserById(userId);
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
