package com.cg.iter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.iter.questions.entities.Question;
import com.cg.iter.questions.entities.Test;
import com.cg.iter.questions.repository.QuestionsRepository;
import com.cg.iter.questions.repository.TestRepository;
import com.cg.iter.questions.service.QuestionServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
class OnlineExamManagementSystemApplicationTests {

	@Autowired
	private QuestionServiceImpl service;
	@MockBean
	 private QuestionsRepository qrepo;
	@MockBean
	private TestRepository trepo;
	  

	
	String[] values = {"abc","bcd", "def","efg"};
     @org.junit.jupiter.api.Test 	
	public void viewAllTest()
	{
		when(qrepo.findAll()).thenReturn(Stream.of(new Question(1,Arrays.asList(values),"Which one of the following is java", 1, 10)).collect(Collectors.toList()));
		assertEquals(1, service.viewAll().size());
	}
     @org.junit.jupiter.api.Test
     public void deleteQuestionTest()
    {
    	 
     	
     }
     @org.junit.jupiter.api.Test
     public void addQuestionTest()
     
     {
    	 Test test=new Test();
    	 test.setTestDuration(10);
 		test.setTestTitle("MCQ");
 		test.setTestTotalMarks(10);
 		test.setTestQuestions(null);
 		Timestamp startDate=Timestamp.valueOf("2020-09-16 22:46:43");
 		Timestamp endDate=Timestamp.valueOf("2020-09-25 22:46:43");
 		test.setStartDate(startDate);
 		test.setEndDate(endDate);
 		test.setTestTotalMarks(10);
 		test.setTestStatus(1);
 		test.setTestId(1);
 		
 		
 		String[] values = {"abc","bcd", "def","efg"};
 		Question ques=new Question(1,Arrays.asList(values),"Which one of the following is java", 1, 10);

    		String questionAdded=service.addQuestion(1,ques);
    		assertEquals("question added", questionAdded);

     }
	
}
