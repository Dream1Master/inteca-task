import {Component, OnInit, ViewEncapsulation, Injector, Inject, PLATFORM_ID, Input} from '@angular/core';
import {Router} from '@angular/router';
import {FamilyService} from './family.service';
import {Family} from '../models/family.model';
import {CollectFatherComponent} from './modals/collect-father.component';
import {Father} from '../models/father.model';
import {Child} from '../models/child.model';
import {FatherService} from '../father/father.service';

@Component({
  selector: 'family-preview',
  templateUrl: './family-preview.component.html'
})
export class FamilyPreviewComponent implements OnInit {

  @Input() family: Family;
  @Input() father: Father;
  @Input() children: Array<Child>;

  constructor(private router: Router, private familyService: FamilyService, private fatherService: FatherService) { }

  ngOnInit(): void {
  }

  createFather(){
    this.father.familyId = this.family.id;
    console.log(this.family.id);
    this.fatherService.createFather(this.father)
      .subscribe( data => {
        alert("Father created successfully.");
      });
  }

  createChild(child: Child){
    child.familyId = this.family.id;
    this.familyService.createChild(child)
      .subscribe( data => {
        alert("Child created successfully.");
      });
  }

}
