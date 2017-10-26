import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Product } from '../classes/product.class';
import { Router } from '@angular/router';
import { Category } from '../classes/category.class';
import { CategoryService } from '../services/category.service';

@Component({
  selector: 'app-input-product',
  templateUrl: './input-product.component.html',
  styleUrls: ['./input-product.component.css']
})
export class InputProductComponent implements OnInit {

  product: Product = new Product();
  categories: Category[] = [];

  constructor(private productService: ProductService, 
    private categoryService: CategoryService,
    private router: Router) { }

  ngOnInit() {
    this.onLoadCategory();
  }

  onSaveProduct(){
    this.productService.saveOrUpdateProduct(this.product)
        .subscribe(output=>{         
           this.router.navigate(['product'])
        },error=>{
          console.log(error);
        });
  }

  onLoadCategory(){
    this.categoryService.gatAllCategory().subscribe(output=>{
      this.categories = output;
    },error=>{
      console.log(error);
    })
  }


}
