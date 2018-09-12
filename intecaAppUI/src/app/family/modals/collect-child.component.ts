import {Component, ViewEncapsulation, Injector, Inject, PLATFORM_ID, OnInit, Output, EventEmitter} from '@angular/core';
import {isPlatformBrowser} from '@angular/common';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Father} from 'src/app/models/father.model';
import {Child} from 'src/app/models/child.model';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'ngbd-modal-collect-child',
  templateUrl: './collect-child.component.html',
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
export class CollectChildComponent implements OnInit {

  closeResult: string;
  count: number = 0;
  modalService: NgbModal;
  children: Array<Child> = [];
  child: Child = new Child();
  childForm: FormGroup;
  submitted = false;
  @Output() childrenEmitter = new EventEmitter<Array<Child>>();

  constructor(@Inject(PLATFORM_ID) private platformId: Object,
              private injetor: Injector,
              private formBuilder: FormBuilder
  ) {
    if (isPlatformBrowser(this.platformId)) {
      this.modalService = this.injetor.get(NgbModal);
    }
  }

  ngOnInit(): void {
    this.initilizeChildForm();
  }

  initilizeChildForm(){
    this.childForm = this.formBuilder.group({
      firstName: [this.child.firstName, [Validators.required]],
      secondName: [this.child.secondName, [Validators.required]],
      pesel: [this.child.pesel,
        [
          Validators.required,
          Validators.minLength(11),
          Validators.maxLength(11),
          Validators.pattern('[0-9]{11}')
        ]
      ],
      birthDay: [this.child.birthDay, [Validators.required]],
      sex: [this.child.sex, Validators.required],
    });
  }

  get cForm() {
    return this.childForm.controls;
  }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.childForm.invalid) {
      return;
    }

    alert('SUCCESS!! :-)');
  }

  extractDataFromForm(){
    let c = new Child();
    c.pesel = this.childForm.get('pesel').value;
    c.firstName = this.childForm.get('firstName').value;
    c.secondName = this.childForm.get('secondName').value;
    let date = this.childForm.get('birthDay').value
    c.birthDay = new Date(date.year + '-' + date.month + '-' +date.day);
    c.sex = this.childForm.get('sex').value;
    this.children.push(c);
  }

  createChild(modal): void {
    if (this.childForm.invalid) {
      return;
    }
    this.extractDataFromForm();
    this.childrenEmitter.emit(this.children);
    modal.close();
  };

  addAnotherChild(): void {
    if (this.childForm.invalid) {
      return;
    }
    this.extractDataFromForm();
    this.initilizeChildForm();
    this.count = this.count + 1;
  };

  collectChildData(content) {
    this.modalService.open(content, {backdropClass: 'light-blue-backdrop'});
  }

}
