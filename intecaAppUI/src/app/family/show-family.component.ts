import { Family } from '../models/family.model';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { Father } from '../models/father.model';
import { FamilyService } from './family.service';

@Component({
  templateUrl: './show-family.component.html'
})
export class ShowFamilyComponent implements OnInit {

  family: Family;

  constructor(private route: ActivatedRoute, private router: Router, private familyService: FamilyService) {

  }

  ngOnInit() {
        const familyId = this.route.snapshot.paramMap.get('id');
        this.familyService.getFamilyById(familyId)
        .subscribe((family: Family) => {
          this.family = family;
        });

  }

}
