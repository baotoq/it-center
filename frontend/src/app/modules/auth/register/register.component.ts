import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { CoreService } from '../../core/core.service';
import { Router } from '@angular/router';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import { Role } from '../../../models/role';
import { User } from '../../../models/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  loading = false;

  constructor(private authService: AuthService,
              private coreService: CoreService,
              private formBuilder: FormBuilder,
              private router: Router) {
    this.createForm();
  }

  private createForm() {
    this.registerForm = this.formBuilder.group({
      name: [null, Validators.required],
      username: [null, Validators.required],
      password: [null, Validators.required],
      passwordConfirm: [null, Validators.required],
    });

    this.username.valueChanges.debounceTime(200).distinctUntilChanged()
      .subscribe(value => {
        this.loading = true;
        this.authService.hasUsername(value)
          .finally(() => this.loading = false)
          .subscribe(resp => {
            if (resp === true) this.username.setErrors({'unique': true});
          });
      });

    this.passwordConfirm.valueChanges.debounceTime(200).distinctUntilChanged()
      .subscribe(value => {
        if (value !== this.password.value) this.passwordConfirm.setErrors({'unmatched': true});
      });
  }

  get name() {
    return this.registerForm.get('name');
  }

  get username() {
    return this.registerForm.get('username');
  }

  get password() {
    return this.registerForm.get('password');
  }

  get passwordConfirm() {
    return this.registerForm.get('passwordConfirm');
  }

  ngOnInit() {
  }

  onSubmit() {
    this.loading = true;
    const user = new User({
      name: this.name.value,
      username: this.username.value,
      password: this.password.value,
      role: Role.USER,
    });

    this.authService.create(user)
      .finally(() => this.loading = false)
      .subscribe(() => {
        this.coreService.notifySuccess('Register Success!');
        this.router.navigate(['/login']);
      });
  }
}
