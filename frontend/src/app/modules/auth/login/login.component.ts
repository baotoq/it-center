import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { CoreService } from '../../core/core.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;

  constructor(private formBuilder: FormBuilder,
              private authService: AuthService,
              private coreService: CoreService,
              private router: Router,
              private route: ActivatedRoute) {
    this.createForm();
  }

  private createForm() {
    this.loginForm = this.formBuilder.group({
      username: ['admin', [Validators.required]],
      password: ['1', Validators.required],
    });
  }

  get username() {
    return this.loginForm.get('username');
  }

  get password() {
    return this.loginForm.get('password');
  }

  ngOnInit() {
  }

  onSubmit() {
    this.loading = true;
    this.authService.login(this.username.value, this.password.value)
      .finally(() => this.loading = false)
      .subscribe(resp => {
        this.authService.setToken(resp);
        this.coreService.notifySuccess('Login successful!');
        this.router.navigateByUrl(this.route.snapshot.queryParams['returnUrl'] || '/');
      }, error => {
        if (error.status === 401) {
          this.coreService.notifyError('Invalid email or password!');
        }
      });
  }
}
