import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/Rx';
import {User} from '../classes/user.class';
import {LoginForm} from '../classes/login-form';
import {Md5} from 'ts-md5/dist/md5';

@Injectable()
export class UserService {

    url : string = 'http://localhost:8080/user';
    headers : any;
    options : any;

    constructor(private http : Http) {
        this.headers = new Headers({'Content-Type': 'application/json', 'Cache-Control': 'no-cache'});
        this.options = new RequestOptions({headers: this.headers});
    }

    register(user : User) {
        let userTmp = Object.assign({}, user);
        userTmp.password = Md5.hashStr(userTmp.password).toString();
        return this
            .http
            .post(this.url + '/register', userTmp, this.options)
            .map(res => res.json())
            .catch(this.handleError);
    }

    login(form : LoginForm) {
        let tmpForm = Object.assign({}, form);
        tmpForm.password = Md5.hashStr(tmpForm.password).toString();
        return this
            .http
            .post(this.url + '/login', tmpForm, this.options)
            .map(res => res.json())
            .catch(this.handleError);
    }

    handleError(error) {
        return Observable.throw(error.json() || 'Server error');
    }
}