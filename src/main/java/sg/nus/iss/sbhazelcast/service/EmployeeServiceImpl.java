package sg.nus.iss.sbhazelcast.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import sg.nus.iss.sbhazelcast.model.Employee;
import sg.nus.iss.sbhazelcast.repository.EmployeeRepository;

@Service
@CacheConfig(cacheNames = "employees")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    // private final EmployeeRepository employeeRepository;

    // public EmployeeServiceImpl(EmployeeRepository repository) {
    //     this.employeeRepository = repository;
    // }

    @Override
    public Employee insertEmployee(Employee emp) {
        
        return employeeRepository.save(emp);
    }

    @Override
    public Boolean insertEmployees(List<Employee> employees) {
        try {
            employeeRepository.saveAll(employees);

            return true;
        } catch (Exception ex) {
            return false;
        }
        
    }

    @Override
    @Cacheable()
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long empId) {
        return employeeRepository.findById(empId);
        
    }
    
}
