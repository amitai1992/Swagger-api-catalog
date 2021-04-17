import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Item } from './ItemClass/Item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  private url = 'http://localhost:8080/api/';

  constructor(private http:HttpClient) { }

  addItem(data:Item): Observable<any> {
    let target = `${this.url}addItem`;
    return this.http.post(`${this.url}addItem`, data);
  }

  deleteItem(item_no:number): Observable<any> {
    return this.http.delete(`${this.url}deleteItem?item_no=` + item_no);
  }

  getItem(id:number): Observable<any> {
    return this.http.get(`${this.url}getItem?item_no=` + id);
  }

  desposit(id:number, quantity:number): Observable<any> {
    
    return this.http.post(`${this.url}despositQuantity?quantity=${quantity}`, id);
  }

  withdrawal(id:number, quantity:number): Observable<any> {
    return this.http.post(`${this.url}withdrawalquantity?quantity=${quantity}`, id);
  }

}
