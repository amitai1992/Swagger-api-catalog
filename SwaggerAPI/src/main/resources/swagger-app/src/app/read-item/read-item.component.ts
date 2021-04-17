import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';
import { Item } from '../ItemClass/Item';

@Component({
  selector: 'app-read-item',
  templateUrl: './read-item.component.html',
  styleUrls: ['./read-item.component.css']
})
export class ReadItemComponent implements OnInit {
  flag: boolean;
  item: Item;
  constructor(private service: ItemService) {
    this.flag = false;
    let data = { amount: -1, inventory_code: -1, item_no: -1, name: "empty" };
    this.item = new Item(data);
  }

  getItem(data) {
    this.service.getItem(data.item_no).subscribe(resItem => {
      if (resItem != null) {
        this.item.set(resItem);
      }
      else {
        alert("item not exist");
      }

    });
    this.flag = true;
  }

  ngOnInit(): void {
  }

}
