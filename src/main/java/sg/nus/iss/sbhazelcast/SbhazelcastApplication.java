package sg.nus.iss.sbhazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sg.nus.iss.sbhazelcast.model.Employee;
import sg.nus.iss.sbhazelcast.service.EmployeeService;

@SpringBootApplication
@EnableCaching
public class SbhazelcastApplication {

	@Autowired
	static EmployeeService employeeService;
	
	public static void main(String[] args) {
		// SpringApplication.run(SbhazelcastApplication.class, args);

		ApplicationContext context = SpringApplication.run(SbhazelcastApplication.class, args);

		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		// Insert Employees in the Table
		Employee emp= new Employee();
		emp.setEmpName("John");

		Employee emp1= new Employee();
		emp1.setEmpName("Miler");

		Employee emp2= new Employee();
		emp2.setEmpName("Nick");

		employeeService.insertEmployee(emp);

		List<Employee> employees = new ArrayList<>();
		employees.add(emp1);
		employees.add(emp2);
		employeeService.insertEmployees(employees);

		System.out.println("Main Class - First Time retrieving Employee Record from Service Class");
		employeeService.getAllEmployees().forEach(employee-> System.out.println(employee.toString()));

		System.out.println("Main Class - Second Time onwards retrieving Employee Record from Hazelcast");
		employeeService.getAllEmployees().forEach(employee-> System.out.println(employee.toString()));

	}

}
