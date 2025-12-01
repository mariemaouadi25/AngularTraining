import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './layout/header/header.component';
import { FooterComponent } from './layout/footer/footer.component';
import { HomeComponent } from './layout/home/home.component';
import { NotFoundComponent } from './layout/not-found/not-found.component';
import {ListEventComponent} from './features/events/list-event/list-event.component';
import {FormsModule} from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; // ✅ IMPORTANT

import {HttpClientModule} from '@angular/common/http';
import { CardComponent } from './layout/Card/card.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NotFoundComponent,



  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,  // ✅ OBLIGATOIRE pour les animations

    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    HomeComponent,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
