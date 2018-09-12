import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Father } from '../models/father.model';
import { FatherService } from './father.service';

@Component({
  selector: 'app-father',
  templateUrl: './father.component.html',
  styleUrls: ['./father.component.css']
})

export class FatherComponent implements OnInit {
fathers: Father[];

  constructor(private router: Router, private fatherService: FatherService) {

  }

  ngOnInit() {
    this.fatherService.getFathers()
      .subscribe( data => {
        this.fathers = data;
      });
  };

  deleteFather(father: Father): void {
    this.fatherService.deleteFather(father)
      .subscribe( data => {
        this.fathers = this.fathers.filter(u => u !== father);
      })
  };

}

