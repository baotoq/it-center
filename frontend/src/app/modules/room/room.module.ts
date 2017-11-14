import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RoomRoutingModule } from './room-routing.module';
import { RoomService } from './room.service';

@NgModule({
  imports: [
    CommonModule,
    RoomRoutingModule,
  ],
  declarations: [],
  providers: [RoomService],
})
export class RoomModule {
}
