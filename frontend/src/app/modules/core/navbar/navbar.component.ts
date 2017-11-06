import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { AuthService } from '../../auth/auth.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {
  @Output() sidenavToggle = new EventEmitter<any>();
  returnUrl = '/';

  constructor(private router: Router,
              private route: ActivatedRoute,
              private authService: AuthService) {
  }

  ngOnInit() {
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

  get authenticated(): boolean {
    return this.authService.isAuthenticated();
  }
}
