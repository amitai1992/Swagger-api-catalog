import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddComponent} from './add/add.component';
import { DeleteComponent } from './delete/delete.component';
import { ReadItemComponent } from './read-item/read-item.component';
import { UpdateItemComponent } from './update-item/update-item.component';

const routes: Routes = [
  {path:'add', component:AddComponent},
  {path:'delete', component:DeleteComponent},
  {path:'read', component:ReadItemComponent},
  {path:'update', component:UpdateItemComponent},
  {path: '', redirectTo: 'add', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
