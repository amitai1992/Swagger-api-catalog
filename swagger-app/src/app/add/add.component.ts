import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';
import {Item} from '../ItemClass/Item';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  constructor(private service:ItemService) { }

  onSubmit(data) {
    let item = new Item(data);
    let res =  this.service.addItem(item).subscribe(respond =>{
      alert(respond.response);
      return respond;
    });
   
    
   
    
    
  }

  ngOnInit(): void {
  }

}
