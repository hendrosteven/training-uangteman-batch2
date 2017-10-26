import { Component, OnInit } from '@angular/core';
import { Category } from '../classes/category.class';
import { CategoryService } from '../services/category.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-input-category',
  templateUrl: './input-category.component.html',
  styleUrls: ['./input-category.component.css']
})
export class InputCategoryComponent implements OnInit {

  category: Category = new Category();
  
  constructor(private categoryService: CategoryService,
    private router: Router) { }

  ngOnInit() {
  }

  onSaveCategory(){
    this.categoryService.saveCategory(this.category).subscribe(output=>{
       this.router.navigate(['category']);
    },error=>{
      console.log(error);
    });
  }

}
