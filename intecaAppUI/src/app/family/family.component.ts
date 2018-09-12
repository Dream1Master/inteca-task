import { Family } from '../models/family.model';
import { FamilyService } from './family.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-family',
  templateUrl: './family.component.html',
  styleUrls: ['./family.component.css']
})
export class FamilyComponent implements OnInit {

  families: Family[];

  constructor(private router: Router, private familyService: FamilyService) { }

  ngOnInit() {
    this.familyService.getAllFamilies()
      .subscribe( data => {
        this.families = data;
      });
  }

  public open(event, item) {
    this.router.navigate(['show-family/' + item]);
  }

}
