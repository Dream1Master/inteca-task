import {Component, OnInit, ViewEncapsulation, Injector, Inject, PLATFORM_ID, Input} from '@angular/core';
import {Router} from '@angular/router';
import {FamilyService} from './family.service';
import {Father} from '../models/father.model';
import {Child} from '../models/child.model';
import {Family} from '../models/family.model';

@Component({
  templateUrl: './add-family.component.html',
})
export class AddFamilyComponent implements OnInit {

  family: Family;
  father: Father;
  children: Array<Child>

  constructor(private router: Router, private familyService: FamilyService) { }
  
  ngOnInit(): void {
  }

  createFamily(){
    this.familyService.createFamily(new Family())
      .subscribe((family: Family) => {
        this.family = family;
      });
  }

  onFatherEmitted(father: Father){
    this.father = father;
    console.log(this.father);
  }

  onChildrenEmitted(children: Array<Child>){
    this.children = children;
  }

}

