import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { HelloComponent } from './hello/hello.component';
import { CategoryComponent } from './category/category.component';
import { CategoryService } from './services/category.service';
import { ProductComponent } from './product/product.component';
import { ProductService } from './services/product.service';
import { RouterModule } from '@angular/router';

export const AppRouter: any = [
  {path: "", component: AppComponent},
  {path: "category", component: CategoryComponent},
  {path: "product", component: ProductComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HelloComponent,
    CategoryComponent,
    ProductComponent
  ],
  imports: [
    FormsModule,
    HttpModule,
    BrowserModule,
    RouterModule.forRoot(AppRouter,{useHash: true})
  ],
  providers: [CategoryService, ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
