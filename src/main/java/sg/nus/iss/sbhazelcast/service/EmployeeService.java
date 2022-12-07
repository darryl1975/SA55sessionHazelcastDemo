package sg.nus.iss.sbhazelcast.service;

import java.util.List;
import java.util.Optional;

import sg.nus.iss.sbhazelcast.model.Employee;

public interface EmployeeService {
    Employee insertEmployee(Employee emp);
	Boolean insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	Optional<Employee> getEmployeeById(Long empId);
}
