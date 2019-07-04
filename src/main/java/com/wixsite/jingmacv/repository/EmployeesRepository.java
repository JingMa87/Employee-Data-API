package com.wixsite.jingmacv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wixsite.jingmacv.model.Employee;

/*
 * This class holds all the data and data manipulation functions.
 */
@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Integer> {

//	private final List<Employee> employees = new ArrayList<>();
//	private final SessionFactory sessionFactory = buildSessionFactory(Employee.class);
//	private final Session session = sessionFactory.openSession();
//	
//	public EmployeesDao() {
//		Transaction transaction = session.beginTransaction();
//		session.save(new Employee("John", "Doe", new Address("Madison St", 821, "Seattle", "USA"), "0198320823"));
//		session.save(new Employee("Yun", "Wu", new Address("Nanhai Ave", 319, "Shenzhen", "China"), "09210132981"));
//		session.save(new Employee("Yifan", "Tao", new Address("Renmin Ave", 2, "Shanghai", "China"), "09291287315"));
//		session.save(new Employee("Maria", "Sanchez", new Address("Jirón Ascope", 6, "Lima", "Peru"), "9128912122"));
//		session.save(new Employee("Anna", "Bakker", new Address("Bloemenweg", 71, "The Hague", "The Netherlands"), null));
//		transaction.commit();
//	}
//	
//	@SuppressWarnings("rawtypes")
//	private SessionFactory buildSessionFactory(Class clazz) {
//		return new Configuration().configure().buildSessionFactory();
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<Employee> getEmployees() {
//		return session.createQuery("from Employee").list();
//	}
	
//	public List<Employee> getEmployees(String country) {
//		return employees.parallelStream().filter(employee -> employee.getAddress().getCountry().equalsIgnoreCase(country)).collect(Collectors.toList());
//	}
//	
//	public Employee getEmployee(String name) {
//		return employees.parallelStream().filter(employee -> (employee.getFirstName() + " " + employee.getLastName()).equals(name)).findFirst().get();
//	}
//	
//	public void addEmployee(Employee employee) throws DuplicateIDException {
//		for (int i = 0; i < employees.size(); i++) {
//			if (employees.get(i).getId() == employee.getId()) {
//				throw new DuplicateIDException("Employee ID is already taken.");
//			}
//		}
//		employees.add(employee);
//	}
//	
//	public void updateEmployee(Employee employee) throws NoSuchEmployeeException {
//		boolean employeeExists = false;
//		for (int i = 0; i < employees.size(); i++) {
//			if (employees.get(i).getId() == employee.getId()) {
//				employeeExists = true;
//				employees.remove(i);
//				employees.add(employee);
//				break;
//			}
//		}
//		if (!employeeExists) {
//			throw new NoSuchEmployeeException("This employee doesn't exist.");
//		}
//	}
//	
//	public List<String> getFirstNames() {
//		return employees.parallelStream().map(employee -> employee.getFirstName()).filter(Objects::nonNull).collect(Collectors.toList());
//	}
//
//	public List<String> getLastNames() {
//		return employees.parallelStream().map(employee -> employee.getLastName()).filter(Objects::nonNull).collect(Collectors.toList());
//	}
//
//	public List<Address> getAddresses() {
//		return employees.parallelStream().map(employee -> employee.getAddress()).filter(Objects::nonNull).collect(Collectors.toList());
//	}
//
//	public List<String> getPhoneNrs() {
//		return employees.parallelStream().map(employee -> employee.getPhoneNr()).filter(Objects::nonNull).collect(Collectors.toList());
//	}
}
