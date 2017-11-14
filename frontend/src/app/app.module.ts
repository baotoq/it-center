import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { SnotifyModule, SnotifyService, ToastDefaults } from 'ng-snotify';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { LoadingService } from './components/loading/loading.service';
import { AuthConfig, AuthHttp } from 'angular2-jwt';
import { Http, HttpModule, RequestOptions } from '@angular/http';
import { AuthModule } from './modules/auth/auth.module';
import { CoreModule } from './modules/core/core.module';
import { SharedModule } from './modules/shared/shared.module';
import { SpinnerComponent } from './components/loading/spinner/spinner.component';
import { ProgressBarComponent } from './components/loading/progress-bar/progress-bar.component';
import { AuthGuard } from './guards/auth.guard';
import { AdminGuard } from './guards/admin.guard';
import { ClassModule } from './modules/class/class.module';
import { RoomModule } from './modules/room/room.module';
import { SubjectModule } from './modules/subject/subject.module';

export function authHttpServiceFactory(http: Http, options: RequestOptions) {
  return new AuthHttp(new AuthConfig(), http, options);
}

@NgModule({
  declarations: [
    AppComponent,
    SpinnerComponent,
    ProgressBarComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpModule,
    SnotifyModule.forRoot(),
    NgbModule.forRoot(),
    AppRoutingModule,
    AuthModule,
    CoreModule,
    ClassModule,
    RoomModule,
    SubjectModule,
    SharedModule,
  ],
  providers: [
    {
      provide: AuthHttp,
      useFactory: authHttpServiceFactory,
      deps: [Http, RequestOptions],
    },
    {provide: 'SnotifyToastConfig', useValue: ToastDefaults},
    SnotifyService,
    LoadingService,
    AuthGuard,
    AdminGuard,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {
}
