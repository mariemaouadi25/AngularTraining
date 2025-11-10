import { Component, OnInit } from '@angular/core';
import { User } from '../../../models/user';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit {
  user!: User;
  formRegister!: FormGroup;

  private emailPattern = /^[a-z]+@[a-z]+\.[a-z]+$/i;
  private passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,}$/;
  private phonePattern = /^[0-9+()\-\s]{6,20}$/;
  private zipPattern = /^[A-Za-z0-9\-\s]{3,10}$/;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.user = new User();

    this.formRegister = this.fb.group({
      firstName: ['', [Validators.required, Validators.minLength(3)]],
      lastName: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.pattern(this.emailPattern)]],
      password: ['', [Validators.required, Validators.pattern(this.passwordPattern)]],
      address: this.fb.group({
        street: ['', [Validators.required, Validators.minLength(3)]],
        city: ['', [Validators.required, Validators.minLength(2)]],
        state: ['', [Validators.required, Validators.minLength(2)]],
        zip: ['', [Validators.required, Validators.pattern(this.zipPattern)]],
      }),
      phones: this.fb.array([this.createPhoneControl()])
    });
  }

  private createPhoneControl(): FormControl {
    return this.fb.control('', [Validators.required, Validators.pattern(this.phonePattern)]);
  }

  get phonesArray(): FormArray {
    return this.formRegister.get('phones') as FormArray;
  }

  addPhone(): void {
    this.phonesArray.push(this.createPhoneControl());
  }

  removePhone(index: number): void {
    if (this.phonesArray.length > 1) {
      this.phonesArray.removeAt(index);
    }
  }

  save(): void {
    if (this.formRegister.invalid) {
      this.formRegister.markAllAsTouched();
      return;
    }
    this.user = { ...this.user, ...this.formRegister.value };
    console.log(this.user);
  }
}
