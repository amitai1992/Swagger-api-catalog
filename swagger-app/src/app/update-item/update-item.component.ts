import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.css']
})
export class UpdateItemComponent implements OnInit {

  constructor(private service: ItemService) { }

  // withdrawal click function
  withdrawal(data) {
    this.service.withdrawal(data.id, data.quantity).subscribe(res => {
      alert(res.response);
    });
  }

  // desposit click function
  desposit(data) {
    this.service.desposit(data.id, data.quantity).subscribe(res => {
      alert(res.response);
    });
  }

  ngOnInit(): void {
  }

}
