package com.cms.secretsantabot.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.secretsantabot.model.Employee;
import com.cms.secretsantabot.model.FromGiftTo;
import com.cms.secretsantabot.repository.EmployeeRepository;
import com.cms.secretsantabot.services.SecretNameGeneratingService;

@Slf4j
@Service
public class SecretNameGeneratingServiceImpl implements SecretNameGeneratingService {

@Autowired
	EmployeeRepository employeeRepository;

	public void saveFromGiftTos(){
		//getAllEmployee
		//Imagining I got employee here
		List<Employee> empList = new ArrayList<>();



		generateConnections(empList);
	}

	private List<FromGiftTo> generateConnections(List<Employee> empList){
		log.info("Generation logic : Applied");
		List<Integer> allEmpId = new ArrayList<>();
		for(int iTemp = 0; iTemp <empList.size(); iTemp++) {
			allEmpId.add(empList.get(iTemp).getE_id()); //get all the employee ID, considering empId numeric
		}
		List<Integer> choices = new ArrayList<Integer>();
		List<FromGiftTo> fromGiftToList = new ArrayList<>();
		Integer choice, start, temp;
		Random random = new Random();
		choice = random.nextInt(allEmpId.size());
		choices.add(allEmpId.get(choice));
		start = allEmpId.get(choice);
		allEmpId.remove(choice);
		boolean selfLoop = true;
		boolean pickStart = false;
		while(allEmpId.size() > 2 || pickStart) {
			random = new Random();
			choice = random.nextInt(allEmpId.size());
			choices.add(allEmpId.get(choice));
			temp = allEmpId.get(choice);
			allEmpId.remove(temp);
			if(selfLoop && !pickStart) {
				selfLoop = false;
				allEmpId.add(start);
			}
			else if (!selfLoop && pickStart) {
				start = temp;
				pickStart = false;
				selfLoop = true;
			}
			else {
				if(temp == start) {
					pickStart = true;
				}
			}
		}
		if(selfLoop && allEmpId.size() == 2) {
			choice = random.nextInt(2);
			choices.add(allEmpId.get(choice));
			choices.add(allEmpId.get(1-choice));
			choices.add(start);
		} else {
			if(allEmpId.get(0) == start) {
				choices.add(allEmpId.get(1));
				choices.add(start);
			} else {
				choices.add(allEmpId.get(0));
				choices.add(start);
			}
		}

		pickStart = true;
		start = choices.get(0);
		for(int indexOfChoice = 0; indexOfChoice < choices.size(); indexOfChoice++) {
			if(!pickStart) {
			//	System.out.println(choices.get(indexOfChoice-1) +" is giving to "+choices.get(indexOfChoice));
				log.info("EmpId {}.  is gifting to EmpId  {}.", choices.get(indexOfChoice-1) , choices.get(indexOfChoice));
				fromGiftToList.add(new FromGiftTo(choices.get(indexOfChoice-1),choices.get(indexOfChoice)));
				//Here we can sent to save details in db
				if(choices.get(indexOfChoice).equals(start)) {
					pickStart = true;
				}
			} else {
				start = choices.get(indexOfChoice);
				pickStart = false;
			}
		}
		return fromGiftToList;
	}


}
