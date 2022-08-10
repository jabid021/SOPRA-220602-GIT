import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AscBoldElementComponent } from './asc-bold-element/asc-bold-element.component';
import { AscBoldComponent } from './asc-bold/asc-bold.component';
import { AscTooltipComponent } from './asc-tooltip/asc-tooltip.component';
import { MonComposantComponent } from './mon-composant/mon-composant.component';
import { BgBlackDirective } from './bg-black.directive';
import { ClientsComponent } from './clients/clients.component';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ClientDetailComponent } from './client-detail/client-detail.component';
import { CapitalisationPipe } from './capitalisation.pipe';
import { ClientCategoryPipe } from './client-category.pipe';


const routes: Routes = [
  {path:"home", component:HomeComponent},
  {path:"client", component:ClientsComponent},
  {path:"client/:nom", component:ClientDetailComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    MonComposantComponent,
    AscBoldComponent,
    AscBoldElementComponent,
    AscTooltipComponent,
    BgBlackDirective,
    ClientsComponent,
    HomeComponent,
    ClientDetailComponent,
    CapitalisationPipe,
    ClientCategoryPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
