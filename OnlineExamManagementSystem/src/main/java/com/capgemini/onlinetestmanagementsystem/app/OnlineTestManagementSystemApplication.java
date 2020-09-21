package com.capgemini.onlinetestmanagementsystem.app;

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

import com.capgemini.onlinetestmanagementsystem.app.entity.QuestionBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.TestBank;
import com.capgemini.onlinetestmanagementsystem.app.entity.User;
import com.capgemini.onlinetestmanagementsystem.app.entity.WorkSpaceData;

@Transactional
@SpringBootApplication
public class OnlineTestManagementSystemApplication implements CommandLineRunner{
	
	@PersistenceContext
	EntityManager myManager;
	public static void main(String[] args) {
		SpringApplication.run(OnlineTestManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		QuestionBank question1= new QuestionBank("The sum of all two digit numbers divisible by 5 is","945,678,439,568",new BigDecimal(4),1,"Aptitude","Easy");
		myManager.persist(question1);
		
		QuestionBank question2= new QuestionBank("Out of 7 consonants and 4 vowels, how many words of 3 consonants and 2 vowels can be formed?","25200,52000,120,24400",new BigDecimal(4),1,"Aptitude","Easy");
		myManager.persist(question2);
		
		Set<QuestionBank> questions = new HashSet<QuestionBank>();
		questions.add(question1);
		questions.add(question2);
		
		
		TestBank test1 = new TestBank("Test1" , LocalDateTime.of(2020,5,4,15,20,00), LocalDateTime.of(2020,5,4,15,20,00).plusMinutes(40), questions);
		myManager.persist(test1);
		
		QuestionBank question3= new QuestionBank("In an election between two candidates, one got 55% of the total valid votes, 20% of the votes were invalid. If the total number of votes was 7500, the number of valid votes that the other candidate got, was :"
				,"2500,2700,2900,3100",new BigDecimal(4),2,"Aptitude","Easy");
		myManager.persist(question3);
		
		QuestionBank question4= new QuestionBank("A problem is given to three students whose chances of solving it are 1/2, 1/3 and 1/4 respectively. What is the probability that the problem will be solved?"
				,"1/4,1/2,3/4,7/12",new BigDecimal(4),3,"Aptitude","Easy");
		myManager.persist(question4);
		
		Set<QuestionBank> questions1 = new HashSet<QuestionBank>();
		questions1.add(question3);
		questions1.add(question4);
		
		TestBank test2 = new TestBank("Test2" , LocalDateTime.of(2020,5,5,15,20,00), LocalDateTime.of(2020,5,5,15,20,00).plusMinutes(40), questions1);
		myManager.persist(test2);
		
		User suraj = new User("Suraj","12345",true);
		myManager.persist(suraj);
		
		User sachin = new User("Sachin","Sachin@123", true);
		myManager.persist(sachin);
		
	    WorkSpaceData data = new WorkSpaceData(Long.parseLong("1"),BigInteger.valueOf(1), 0);
		myManager.persist(data);
	}
}
