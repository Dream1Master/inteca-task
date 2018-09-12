import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {
  MatToolbarModule,
  MatButtonModule,
  MatSidenavModule,
  MatIconModule,
  MatListModule,
  MatCardModule,
  MatNativeDateModule,
  MatDatepickerModule
} from '@angular/material';
import { AppComponent } from './app.component';
import { FatherComponent } from './father/father.component';
import { AppRoutingModule } from './app.routing.module';
import { AddFamilyComponent } from './family/add-family.component';
import {FatherService} from './father/father.service';
import {HttpClientModule} from '@angular/common/http';
import {AddFatherComponent} from './father/add-father.component';
import { FamilyComponent } from './family/family.component';
import { FamilyService } from './family/family.service';
import { ShowFamilyComponent } from './family/show-family.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {CollectFatherComponent} from './family/modals/collect-father.component';
import {NavbarComponent} from './navbar/navbar.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CollectChildComponent} from './family/modals/collect-child.component';
import {FamilyPreviewComponent} from './family/family-preview.component';
// @ts-ignore
@NgModule({
  declarations: [
    AppComponent,
    FatherComponent,
    AddFatherComponent,
    AddFamilyComponent,
    ShowFamilyComponent,
    FamilyComponent,
    CollectFatherComponent,
    CollectChildComponent,
    FamilyPreviewComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule.forRoot(),
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatCardModule
  ],
  providers: [FamilyService, FatherService],
  bootstrap: [AppComponent],
  exports: [ AddFamilyComponent ]
})
export class AppModule { }
