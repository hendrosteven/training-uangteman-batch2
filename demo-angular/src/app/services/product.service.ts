import { Injectable } from "@angular/core";
import { Http, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import { SearchPriceForm } from "../classes/search-price-form.class";
import { SearchNameForm } from "../classes/search-name-form";
import { Category } from "../classes/category.class";


@Injectable()
export class ProductService{

    url: string = 'http://localhost:8080/product';
    headers: any;
    options: any;

    constructor(private http: Http){
        this.headers = new Headers({
            'Content-Type': 'application/json',
            'Cache-Control': 'no-cache'                     
        });
        this.options = new RequestOptions({headers: this.headers});
    }

    getAllProduct(){
        return this.http.get(this.url, this.options)
            .map(res => res.json())
            .catch(this.handleError);
    }

    saveOrUpdateProduct(product){
        return this.http.post(this.url, product,this.options)
            .map(res => res.json())
            .catch(this.handleError);
    }

    getByPriceRange(priceRange: SearchPriceForm){
        return this
            .http
            .post(this.url+'/byprice', priceRange,this.options)
            .map(res => res.json())
            .catch(this.handleError);
    }

    getByName(name: SearchNameForm){
        return this
        .http
        .post(this.url+'/byname', name,this.options)
        .map(res => res.json())
        .catch(this.handleError);
    }

    getByCategory(category: Category){
        return this
        .http
        .post(this.url+'/bycategory', category,this.options)
        .map(res => res.json())
        .catch(this.handleError);
    }

    handleError(error){
        return Observable.throw(error.json() || 'Server error');
    }
    
}