import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Father } from '../models/father.model';
import { FatherService } from './father.service';

@Component({
  templateUrl: './add-father.component.html'
})
export class AddFatherComponent {

  father: Father = new Father();

  constructor(private router: Router, private fatherService: FatherService) {

  }

  createFather(): void {
    this.fatherService.createFather(this.father)
        .subscribe( data => {
          alert("User created successfully.");
        });

  };

}
