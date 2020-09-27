import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question, Test} from '../models/question';
import { map } from 'rxjs/operators';
import { $ } from 'protractor';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  
  
private geturl: String ="http://localhost:8082/exam"
  constructor(private _httpClient:HttpClient){}


  
  viewAllQuestions() {
    return this._httpClient.get<Question[]>(this.geturl+"/viewAll");
  }
  addQuestion(id:number,question: Question){
    return this._httpClient.post(this.geturl+"/add/"+id,question,{responseType:'text'});
  }
  // getQuestion(id:number):Observable<Question>{
  //   return this._httpClient.get<Question>('$(this.geturl)/$(get)/$(id)').pipe(map(Response=>Response))
  // }

  getQuestion(id:number) {
    return this._httpClient.get<Question>(this.geturl+"/get/"+id,{responseType:'json'});
  }
  updateQuestion(qid:number,question:Question) {
    return this._httpClient.post(this.geturl+"/update/"+qid,question,{responseType:'text'});
  }
  deleteQuestion(questionId:number){
    return this._httpClient.delete(this.geturl+"/delete/"+questionId,{responseType:'text'})
  }

}

