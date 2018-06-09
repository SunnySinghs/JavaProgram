package treeMapPrograms.treeMapDemo2;

public class Employee{

	private String name;
	private Double salary;
	private Integer eId;
	private String email;
	public Employee(String name, Double salary, Integer eId, String email) {
		super();
		this.name = name;
		this.salary = salary;
		this.eId = eId;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", eId=" + eId + ", email=" + email + "]";
	}

}
