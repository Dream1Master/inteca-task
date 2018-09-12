package com.example.IntecaTaskApp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.IntecaTaskApp.entity.Child;
import com.example.IntecaTaskApp.entity.Family;
import com.example.IntecaTaskApp.entity.Father;
import com.example.IntecaTaskApp.service.IFamilyService;

@Controller
@RequestMapping("/family")
public class FamilyController {
	
	@Autowired
	private IFamilyService familyService;
	
	@GetMapping("/families")
	public ResponseEntity<List<Family>> getAllFamilies() {
		List<Family> list = familyService.getAllFamilies();
		return new ResponseEntity<List<Family>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/family/{id}")
	public ResponseEntity<Family> getFamilyById(@PathVariable("id") Integer id) {
		Family family = familyService.getFamilyById(id);
		return new ResponseEntity<Family>(family, HttpStatus.OK);
	}
	
	@PostMapping("/family")
	public ResponseEntity<Family> addFamily(@RequestBody Family family, UriComponentsBuilder builder) {
		boolean flag = familyService.addFamily(family);
		if (flag == false) {
			return new ResponseEntity<Family>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Family>(family, HttpStatus.CREATED);
	}

}
