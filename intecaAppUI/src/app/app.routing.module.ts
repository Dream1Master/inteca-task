import { AddFamilyComponent } from './family/add-family.component';
import { FamilyComponent } from './family/family.component';
import { ShowFamilyComponent } from './family/show-family.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { FatherComponent } from './father/father.component';
import {AddFatherComponent} from './father/add-father.component';
import {FamilyPreviewComponent} from './family/family-preview.component';

const routes: Routes = [
  { path: 'families', component: FamilyComponent },
  { path: 'add-family', component: AddFamilyComponent },
  { path: 'show-family/:id', component: ShowFamilyComponent },
  { path: 'family-preview', component: FamilyPreviewComponent },
  { path: 'add', component: AddFatherComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
