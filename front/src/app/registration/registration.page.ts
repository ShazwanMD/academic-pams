import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {FormBuilder, FormGroup,Validators} from '@angular/forms';
import {Store} from '@ngrx/store';
import {RegistrationModuleState} from './index';
import {RegistrationActions} from './registration.action';
import {UserRegistration} from '../shared/model/registration/user-registration.interface';

@Component({
  selector: 'pams-registration-page',
  templateUrl: './registration.page.html',
})

export class RegistrationPage implements OnInit {

  private registrationForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<RegistrationModuleState>,
              private registrationActions: RegistrationActions,
          ) {
  }

  ngOnInit(): void {
    let emailPattern: string = '^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$';
    this.registrationForm = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', Validators.pattern(emailPattern)],
      identityNo: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  register(registration: UserRegistration, isValid: boolean) {
    this.store.dispatch(this.registrationActions.registerUser(registration));
  }
}
