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
  item: any;
  constructor(private service: ItemService) {
    this.flag = false;
    this.item = undefined;
  }

  async getItem(data) {
    await this.service.getItem(data.id).subscribe(resItem => {
      this.item = new Item(resItem);
    });
    this.flag = true;
  }

  ngOnInit(): void {
  }

}
