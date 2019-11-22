package com.proj.splitwise;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nested.Group;
import com.nested.GroupRelation;
import com.nested.Purpose;
import com.nested.SplitService;

//import com.nested.Splitt;
//import com.nested.SplittRepository;
import com.nested.Status;
import com.nested.Transaction;
import com.nested.User;
import com.nested.repositories.GroupRelationRepository;
import com.nested.repositories.GroupRepository;
import com.nested.repositories.PurposeRepository;
import com.nested.repositories.TransactionRepository;
import com.nested.repositories.UsersRepository;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("splitpay")
public class AppController {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	UsersRepository userRepository;

	@Autowired
	PurposeRepository purposeRepository;

	@Autowired
	GroupRelationRepository groupRelationRepository;

	@Autowired
	GroupRepository groupRepository;

	// Sign In
	@PostMapping("/signin")
	public User signIn(HttpServletRequest req, @RequestBody User user) {
		User temp = new User();
		System.out.println(user);
		temp = userRepository.findByUserName(user.getUserName());

		if (temp.getId() > 0 && temp.getPassword().equals(user.getPassword())) {
			HttpSession session = req.getSession(true);
			session.setAttribute("userName", temp.getUserName());
		}

		return temp;
	}

	// Sign Up
	@PostMapping("/signup")
	public User signUp(HttpServletRequest req, @RequestBody User user) {

		User result = null;
		try {
			result = userRepository.save(user);

			if (result == null)
				return null;

			HttpSession session = req.getSession(true);
			session.setAttribute("userName", result.getUserName());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Sign Out
	@PostMapping("/signout")
	public Status logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);

		if (session != null && session.getAttribute("userName") != null) {
			session.invalidate();
			return new Status(true);
		}
		return new Status(false);
	}

	// Check if user has signed in already
	public boolean validate(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("userName") == null)
			return false;
		return true;
	}

	// Get All Users
	@GetMapping("/users/all")
	public List<User> findAllUsers(HttpServletRequest req) {
		if (!validate(req))
			return null;

		List<User> users = new ArrayList<User>();
		Iterable<User> iterable = userRepository.findAll();
		for (User user : iterable) {
			users.add(user);
		}
		return users;
	}

	// Transactions
	// view transactions
	@GetMapping("/transactions/all")
	public List<Transaction> gettransactions(HttpServletRequest req) {
		if (!validate(req))
			return null;

		List<Transaction> transactions = new ArrayList<Transaction>();
		Iterable<Transaction> iterable = transactionRepository.findAll();
		for (Transaction transaction : iterable) {
			transactions.add(transaction);
		}
		return transactions;
	}

	@GetMapping("/transactions/search/{id}")
	public List<Transaction> getmytransactions(@PathVariable Integer id, HttpServletRequest req) {
		if (!validate(req))
			return null;
		User user = new User();
		user.setId(id);
		return  transactionRepository.findByUser(user);
	}
	
	
	// Save a transactions
	@PostMapping("/transactions/save")
	public Transaction saveTransaction(@RequestBody Transaction transaction, HttpServletRequest req) {
		if (!validate(req))
			return null;

		transaction.setUser(new User());
		transaction.getUser().setId(transaction.getUfk());
		transaction.setPurpose(new Purpose());
		transaction.getPurpose().setPid(transaction.getPfk());
		return transactionRepository.save(transaction);
	}

	// Delete a transactions
	@DeleteMapping("/transactions/delete/{id}")
	public Status deleteTransaction(@PathVariable Integer id, HttpServletRequest req) {
		if (!validate(req))
			return null;

		transactionRepository.deleteById(id);
		return new Status(true);
	}

	// Edit a transaction
	@PutMapping("/transactions/edit")
	public Transaction editTransaction(@RequestBody Transaction transaction, HttpServletRequest req) {
		if (!validate(req))
			return null;

		transaction = transactionRepository.save(transaction);
		return transaction;
	}

	// Purposes
	// view purpose
	@GetMapping("/purpose/all")
	public List<Purpose> getpurposes(HttpServletRequest req) {
		if (!validate(req))
			return null;

		List<Purpose> purposes = new ArrayList<Purpose>();
		Iterable<Purpose> iterable = purposeRepository.findAll();
		for (Purpose purpose : iterable) {
			purposes.add(purpose);
		}
		return purposes;
	}

	// Save a purpose
	@PostMapping("/purpose/save")
	public Purpose savePurpose(@RequestBody Purpose purpose, HttpServletRequest req) {
		if (!validate(req))
			return null;
		return purposeRepository.save(purpose);
	}

	// Delete a purpose
	@DeleteMapping("/purposes/delete/{id}")
	public Status deletePurposes(@PathVariable Integer id, HttpServletRequest req) {
		if (!validate(req))
			return null;

		purposeRepository.deleteById(id);
		return new Status(true);
	}

	// Edit a purpose
	@PutMapping("/purpose/edit")
	public Purpose editPurpose(@RequestBody Purpose purpose, HttpServletRequest req) {
		if (!validate(req))
			return null;

		purpose = purposeRepository.save(purpose);
		return purpose;
	}

	// Group
	// User exits group
	@DeleteMapping("/group/delete/{gid}/{uid}")
	public Status exitGroup(@PathVariable Integer gid, @PathVariable Integer uid, HttpServletRequest req) {
		if (!validate(req))
			return null;

	
		
		groupRelationRepository.deleteByUserandGroup(gid, uid);
		return new Status(true);
	}

	// create a group
	@PostMapping("/group/save")
	public Group saveGroup(@RequestBody Group group, HttpServletRequest req) {
		if (!validate(req))
			return null;
		return groupRepository.save(group);
	}

	// view group
	@GetMapping("/group/all")
	public List<Group> getgroups(HttpServletRequest req) {
		if (!validate(req))
			return null;

		List<Group> groups = new ArrayList<Group>();
		Iterable<Group> iterable = groupRepository.findAll();
		for (Group group : iterable) {
			groups.add(group);
		}
		return groups;
	}

//		//add a user to group
//		@PostMapping("/group/usergroup/save/{uid}")
//		public Group saveUserGroup(@PathVariable Integer uid, HttpServletRequest req) {
//		if (!validate(req))
//				return null;
//			return groupRepository.savebyUser(uid);
//		}

	// add a user to group
	@PostMapping("/group/user/saved")
	public GroupRelation saveUser(@RequestBody GroupRelation grouprelation, HttpServletRequest req) {
		if (!validate(req))
			return null;
			
	
		grouprelation.setGroupUser(new User());
		grouprelation.getGroupUser().setId(grouprelation.getUfk());
		grouprelation.setGroup(new Group());
		grouprelation.getGroup().setGroupId(grouprelation.getGfk());
	
		return groupRelationRepository.save(grouprelation);
		
	}

	// view grouprelation
	@GetMapping("/grouprelation/all")
	public List<GroupRelation> getgrouprelations(HttpServletRequest req) {
		if (!validate(req))
			return null;

		List<GroupRelation> grouprelations = new ArrayList<GroupRelation>();
		Iterable<GroupRelation> iterable = groupRelationRepository.findAll();
		for (GroupRelation grouprelation : iterable) {
			grouprelations.add(grouprelation);
		}
		return grouprelations;
	}
	
	
}