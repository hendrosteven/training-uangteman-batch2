import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { HelloComponent } from './hello/hello.component';
import { CategoryComponent } from './category/category.component';
import { CategoryService } from './services/category.service';

@NgModule({
  declarations: [
    AppComponent,
    HelloComponent,
    CategoryComponent
  ],
  imports: [
    FormsModule,
    HttpModule,
    BrowserModule
  ],
  providers: [CategoryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
