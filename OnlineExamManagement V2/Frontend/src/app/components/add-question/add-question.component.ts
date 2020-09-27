import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
//import { Question, Category } from 'src/app/models/user.model';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Question } from 'src/app/models/question';
import { QuestionService } from 'src/app/services/question.service';
//import { CreateExamService } from 'src/app/services/create-exam.service';
//import { LoggingService } from '../../../models/loggingService';

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit {
  addQueForm: FormGroup;
  submitted: boolean = false;
  baseUrl: string = "http://localhost:8082/exam";
  options:String[];
  question:Question;
  //categoryName:string="";
 // categories:Category[];
  //selectedCategory:number=-2;
  option:boolean=false;
  //newCategory:Category;
  option1:string="";
  option2:string="";
  option3:string="";
  option4:string="";
  id: number=11;
  //categoryNameError:boolean=false;
  //categoryBlock:boolean=false;
  constructor(private formBuilder: FormBuilder,private router: Router,private http: HttpClient,private service:QuestionService) {
  }

  ngOnInit() {

    

      //form validations
      this.addQueForm = this.formBuilder.group({
        questionTitle: ['',Validators.required],
        questionAnswer: ['',[Validators.required,Validators.min(1),Validators.max(4)]],
        questionMarks: ['',[Validators.required,Validators.min(1)]],
        // questionOptions: ['',Validators.required],
      });
      this.router.navigate(['/addQueForm']);
    
    }
     //if no user exists in the session storage, navigate to login
    
      
    
  

  


  

  
  // adding a question function
  addQuestion() {
    this.option=false;
    this.submitted = true;
    this.option=false;
    
    if(this.option1=="" ||this.option2=="" ||this.option3=="" ||this.option4=="" ){
      console.log("option null")
      this.option=true;
    }
    //console.log(this.selectedCategory)
    
    if (this.addQueForm.invalid ) {
      return;
    }
    if(this.option==false ){
      this.options=[this.option1,this.option2,this.option3,this.option4]

    
    this.question=this.addQueForm.getRawValue();
    this.question.questionOptions=this.options;
    console.log(this.question)

    //calling service to add a question
    this.service.addQuestion(this.id,this.question).subscribe(data => {

     // this.logger.logStatus("Added a new question");
      alert("Question is added Successfully..!")
      //if question is added successfully go to question List
      this.router.navigate(['viewAll']);
      console.log(data)
    },
      err => {
        this.option=true;
      });
    }
  }
}