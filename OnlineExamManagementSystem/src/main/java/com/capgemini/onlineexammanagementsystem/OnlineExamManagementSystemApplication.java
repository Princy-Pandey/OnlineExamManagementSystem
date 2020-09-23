package com.capgemini.onlineexammanagementsystem;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.capgemini.onlineexammanagementsystem.entities.QuestionBank;
import com.capgemini.onlineexammanagementsystem.entities.TestBank;
import com.capgemini.onlineexammanagementsystem.entities.User;
import com.capgemini.onlineexammanagementsystem.entities.WorkSpaceData;


@Transactional
@SpringBootApplication
public class OnlineExamManagementSystemApplication implements CommandLineRunner{

	@PersistenceContext
	EntityManager myManager;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineExamManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		QuestionBank question1= new QuestionBank("The sum of all two digit numbers divisible by 5 is","945,678,439,568",new BigDecimal(40),1,"Aptitude","Easy");
		myManager.persist(question1);
		
		QuestionBank question2= new QuestionBank("Out of 7 consonants and 4 vowels, how many words of 3 consonants and 2 vowels can be formed?","25200,52000,120,24400",new BigDecimal(4),1,"Aptitude","Easy");
		myManager.persist(question2);
		
		QuestionBank question3= new QuestionBank("TempQuestionA","A,B,C,D",new BigDecimal(4),1,"temp","Easy");
		myManager.persist(question3);
		
		QuestionBank question4= new QuestionBank("TempQuestionB","A,B,C,D",new BigDecimal(4),1,"temp","Easy");
		myManager.persist(question4);
		
		Set<QuestionBank> questions = new HashSet<QuestionBank>();
		questions.add(question1);
		questions.add(question2);
		
		Set<QuestionBank> tempQue = new HashSet<QuestionBank>();
		tempQue.add(question3);
		tempQue.add(question4);
		
		
		TestBank generalAptitude = new TestBank("Aptitude" , LocalDateTime.now(),LocalDateTime.now().plusMinutes(40), questions);
		myManager.persist(generalAptitude);
		
		TestBank testingTest = new TestBank("Testing Test" , LocalDateTime.now(),LocalDateTime.now().plusMinutes(40), tempQue);
		myManager.persist(testingTest);
		
		User suraj = new User("Princy","12345",true);
		myManager.persist(suraj);
		
		User danish = new User("Maneesh","12345",true);
		myManager.persist(danish);
		
		User sachin = new User("Umesh","12345",true);
		myManager.persist(sachin);
		
	    WorkSpaceData dataA = new WorkSpaceData(Long.parseLong("1"),BigInteger.valueOf(1),Integer.valueOf(0));
		myManager.persist(dataA);
		
		WorkSpaceData dataB = new WorkSpaceData(Long.parseLong("10"),BigInteger.valueOf(10),Integer.valueOf(0));
		myManager.persist(dataB);
	}
}
