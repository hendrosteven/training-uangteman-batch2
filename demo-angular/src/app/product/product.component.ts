import { Component, OnInit } from '@angular/core';
import { Product } from '../classes/product.class';
import { ProductService } from '../services/product.service';
import { SearchNameForm } from '../classes/search-name-form';
import { Category } from '../classes/category.class';
import { CategoryService } from '../services/category.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products: Product[] = [];
  searchName: SearchNameForm = new SearchNameForm();
  product: Product = new Product();
  categories: Category[] = [];

  constructor(private productService: ProductService,
          private categoryService: CategoryService) { }

  ngOnInit() {
    this.onLoadProduct();
    this.onLoadCategory();
  }

  onLoadCategory(){
    this.categoryService.gatAllCategory().subscribe(output=>{
      this.categories = output;
    },error=>{
      console.log(error);
    })
  }

  onLoadProduct(){
    this.productService.getAllProduct().subscribe(output=>{
      this.products = output;
    },error=>{
      console.log(error);
    })
  }

  onSearchName(){    
    this.productService.getByName(this.searchName).subscribe(output=>{
      this.products = [];
      this.products = output;
    }, error=>{
      console.log(error);
    });
  }

  onSaveProduct(){
    this.productService.saveOrUpdateProduct(this.product)
        .subscribe(output=>{
          this.products.push(output);
          this.product = new Product();
        },error=>{
          console.log(error);
        });
  }

}
