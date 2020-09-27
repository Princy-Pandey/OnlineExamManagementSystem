import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import { CommonModule } from "@angular/common";
import {RouterModule,Routes} from "@angular/router";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ViewAllQuestionsComponent } from './components/view-all-questions/view-all-questions.component';
import { AddQuestionComponent } from './components/add-question/add-question.component';
import { from } from 'rxjs';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import { UpdateQuestionComponent } from './components/update-question/update-question.component';
import { HomeComponent } from './components/home/home.component';

const routers: Routes=[
  

{path:"viewAll",component: ViewAllQuestionsComponent },
{path:"add/:id",component: AddQuestionComponent  },
//{path:"update/:qid",component: UpdateQuestionComponent },
{path:"update/:qid",component: UpdateQuestionComponent },
{path:"home",component: HomeComponent },
{path:"",redirectTo:"home",pathMatch:"full" }
]


@NgModule({
  declarations: [
    AppComponent,
    ViewAllQuestionsComponent,
    AddQuestionComponent,
    UpdateQuestionComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    FormsModule,
    RouterModule.forRoot(routers),
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
