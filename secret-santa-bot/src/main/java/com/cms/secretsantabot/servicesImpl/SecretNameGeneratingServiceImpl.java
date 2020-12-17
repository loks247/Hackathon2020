package com.cms.secretsantabot.servicesImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.cms.secretsantabot.model.Employee;
import com.cms.secretsantabot.repository.EmployeeRepository;
import com.cms.secretsantabot.services.SecretNameGeneratingService;

@Slf4j
@Service
public class SecretNameGeneratingServiceImpl implements SecretNameGeneratingService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void saveAllMatchedEmployees() {
		List<Employee> empList = employeeRepository.findAll();
		if (!CollectionUtils.isEmpty(empList)) {
			generateConnections(empList).forEach((fromEmpId,toEmpId) ->{
				Employee employee = employeeRepository.getEmployeesById(fromEmpId);
				employee.setToEmpId(toEmpId);
				employeeRepository.save(employee); //updates the employee
			});
		}
		else{
			log.info("No employee found for the game");
		}
	}

	private Map<Integer, Integer> generateConnections(List<Employee> empList) {
		log.info("Secret Name Generation : Started");
		Map<Integer, Integer> fromToMap = new HashMap<>();
		if (empList.size() == 1) {
			fromToMap.put(empList.get(0).getId(), empList.get(0).getId());
			return fromToMap;
		} else if (empList.size() == 2) {
			fromToMap.put(empList.get(0).getId(), empList.get(1).getId());
			fromToMap.put(empList.get(1).getId(), empList.get(0).getId());
			return fromToMap;
		} else {
			List<Integer> allEmpId = new ArrayList<>();
			for (int iTemp = 0; iTemp < empList.size(); iTemp++) {
				allEmpId.add(empList.get(iTemp).getId()); //get all the employee ID, considering empId numeric
			}
			List<Integer> choices = new ArrayList<Integer>();
			Integer choice, start, temp;
			Random random = new Random();
			choice = random.nextInt(allEmpId.size());
			choices.add(allEmpId.get(choice));
			start = allEmpId.get(choice);
			allEmpId.remove(choice);
			boolean selfLoop = true;
			boolean pickStart = false;
			while (allEmpId.size() > 2 || pickStart) {
				random = new Random();
				choice = random.nextInt(allEmpId.size());
				choices.add(allEmpId.get(choice));
				temp = allEmpId.get(choice);
				allEmpId.remove(temp);
				if (selfLoop && !pickStart) {
					selfLoop = false;
					allEmpId.add(start);
				} else if (!selfLoop && pickStart) {
					start = temp;
					pickStart = false;
					selfLoop = true;
				} else {
					if (temp == start) {
						pickStart = true;
					}
				}
			}
			if (selfLoop && allEmpId.size() == 2) {
				choice = random.nextInt(2);
				choices.add(allEmpId.get(choice));
				choices.add(allEmpId.get(1 - choice));
				choices.add(start);
			} else {
				if (allEmpId.get(0) == start) {
					choices.add(allEmpId.get(1));
					choices.add(start);
				} else {
					choices.add(allEmpId.get(0));
					choices.add(start);
				}
			}

			pickStart = true;
			start = choices.get(0);
			for (int indexOfChoice = 0; indexOfChoice < choices.size(); indexOfChoice++) {
				if (!pickStart) {
					//Temporary log, needs to be commented or removed
					log.info("EmpId {}.  is gifting to EmpId  {}.", choices.get(indexOfChoice - 1), choices.get(indexOfChoice));
					fromToMap.put(choices.get(indexOfChoice - 1), choices.get(indexOfChoice));
					if (choices.get(indexOfChoice).equals(start)) {
						pickStart = true;
					}
				} else {
					start = choices.get(indexOfChoice);
					pickStart = false;
				}
			}
			return fromToMap;
		}
	}

}
