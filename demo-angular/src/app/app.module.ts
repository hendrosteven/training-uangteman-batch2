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
import { UserService } from './services/user.service';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';

export const AppRouter: any = [
  {path: "", component: AppComponent},
  {path: "category", component: CategoryComponent},
  {path: "product", component: ProductComponent},
  {path: "register", component: RegisterComponent},
  {path: "login", component: LoginComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HelloComponent,
    CategoryComponent,
    ProductComponent,
    RegisterComponent,
    LoginComponent
  ],
  imports: [
    FormsModule,
    HttpModule,
    BrowserModule,
    RouterModule.forRoot(AppRouter,{useHash: true})
  ],
  providers: [CategoryService, ProductService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
