import {Component, ViewEncapsulation, Injector, Inject, PLATFORM_ID, OnInit, Output, EventEmitter} from '@angular/core';
import {isPlatformBrowser} from '@angular/common';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Father} from 'src/app/models/father.model';
import {FormBuilder, FormGroup, Validators, FormControl} from '@angular/forms';

@Component({
  selector: 'ngbd-modal-collect-father',
  templateUrl: './collect-father.component.html',
  styles: [`
    .dark-modal .modal-content {
      background-color: #292b2c;
      color: white;
    }

    .dark-modal .close {
      color: white;
    }

    .light-blue-backdrop {
      background-color: #5cb3fd;
    }
  `]
})
export class CollectFatherComponent implements OnInit {

  modalService: NgbModal;
  fatherForm: FormGroup;
  submitted = false;
  father: Father = new Father();
  @Output() fatherEmitter = new EventEmitter<Father>();

  constructor(@Inject(PLATFORM_ID) private platformId: Object,
              private injetor: Injector,
              private formBuilder: FormBuilder
  ) {
    if (isPlatformBrowser(this.platformId)) {
      this.modalService = this.injetor.get(NgbModal);
    }
  }

  ngOnInit(): void {
    this.fatherForm = this.formBuilder.group({
      firstName: [this.father.firstName, Validators.required],
      secondName: [this.father.secondName, Validators.required],
      pesel: [this.father.pesel,
        [
          Validators.required,
          Validators.minLength(11),
          Validators.maxLength(11),
          Validators.pattern('[0-9]{11}')
        ]
      ],
      birthDay: [this.father.birthDay, [Validators.required]]
    });
  }

  get fForm() {
    return this.fatherForm.controls;
  }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.fatherForm.invalid) {
      return;
    }

    alert('SUCCESS!! :-)');
  }

  extractDataFromForm(){
    this.father.pesel = this.fatherForm.get('pesel').value;
    this.father.firstName = this.fatherForm.get('firstName').value;
    this.father.secondName = this.fatherForm.get('secondName').value;
    let date = this.fatherForm.get('birthDay').value
    this.father.birthDay = new Date(date.year + '-' + date.month + '-' +date.day);
  }

  createFather(modal): void {
    if (this.fatherForm.invalid) {
      return;
    }
    this.extractDataFromForm();
    this.fatherEmitter.emit(this.father);
    modal.close();
  };

  openWindowCustomClass(content) {
    this.modalService.open(content, {windowClass: 'dark-modal'});
  }

}
