package com.example.IntecaTaskApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.IntecaTaskApp.entity.Child;
import com.example.IntecaTaskApp.entity.Father;
import com.example.IntecaTaskApp.service.IChildService;
import com.example.IntecaTaskApp.service.IFatherService;

@Controller
@RequestMapping("/child")
public class ChildController {
	
	@Autowired
	private IChildService childService;
	
	@GetMapping("child/{id}")
	public ResponseEntity<Child> getChildById(@PathVariable("id") Integer id) {
		Child child = childService.getChildById(id);
		return new ResponseEntity<Child>(child, HttpStatus.OK);
	}

	@GetMapping("children")
	public ResponseEntity<List<Child>> getAllChildren() {
		List<Child> list = childService.getAllChildren();
		return new ResponseEntity<List<Child>>(list, HttpStatus.OK);
	}

	@PostMapping("child")
	public ResponseEntity<Void> addChild(@RequestBody Child child, UriComponentsBuilder builder) {
		System.out.println(
				"Id:" + child.getID() + ", PESEL:" + child.getPesel() + ", First Name:" + child.getFirstName()
						+ ", Second Name:" + child.getSecondName() + ", Birth Day:" + child.getBirthDay());
		boolean flag = childService.addChild(child);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("api/child/{id}").buildAndExpand(child.getID()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("child")
	public ResponseEntity<Child> updateChild(@RequestBody Child child) {
		childService.updateChild(child);
		return new ResponseEntity<Child>(child, HttpStatus.OK);
	}

	@DeleteMapping("child/{id}")
	public ResponseEntity<Void> deleteChild(@PathVariable("id") Integer id) {
		childService.deleteChild(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
