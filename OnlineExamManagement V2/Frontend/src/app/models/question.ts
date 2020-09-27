import { Time } from '@angular/common';

export class Question {

    questionId:number;
    questionOptions:String[];
    
    questionTitle:string;
    questionAnswer:number;
    questionMarks:number;
    

}
export class Test{

testId:number;
testTitle:String;
testDuration:number;
testStatus:number;
testTotalMarks:number;
startDate:Time;
endDate:Time;
testQuestions:Question[];


}
