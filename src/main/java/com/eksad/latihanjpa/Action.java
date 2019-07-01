package com.eksad.latihanjpa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eksad.latihanjpa.dao.EmployeeDAO;
import com.eksad.latihanjpa.model.Employee;

@Configuration
public class Action {
	@Autowired
	EmployeeDAO employeeDAO;

	@Bean
	public List<Employee> getAll() {

		List<Employee> employees = employeeDAO.getAll();
/*
		for (Employee employee : employees) {
			System.out.println("ID : " + employee.getId());
			System.out.println("Name : " + employee.getName());
			System.out.println("Address : " + employee.getAddress());
			System.out.println("DOB : " + employee.getDob());
			System.out.println("====================================");
		}
*/
		return employees;

	}

	@Bean
	public Employee getById() {
		Employee employee = employeeDAO.getById(2);
/*
		System.out.println("Get By Id 2 : ");
		System.out.println("ID : " + employee.getId());
		System.out.println("Name : " + employee.getName());
		System.out.println("Address : " + employee.getAddress());
		System.out.println("DOB : " + employee.getDob());
		System.out.println("====================================");
		*/
		return employee; 
	}

	//@Bean
	public boolean save() {
		try {
			Employee employee = new Employee();

			employee.setName("opop");
			employee.setAddress("wqwq");
			
			String dateString = "2019-07-01";
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
			
			employee.setDob(date);
			
			employeeDAO.save(employee);
			
			System.out.println("Data Berhasil Tersimpan");
			
			return true;
			
		} catch (Exception e) {
			System.out.println("Data Gagal Tersimpan");
			e.printStackTrace();
			return false;
		}

	}
	
	//@Bean
	public boolean update() {
		try {
			Employee employee = new Employee();

			employee.setId(6);
			employee.setName("klkl");
			employee.setAddress("gfgf");
			
			String dateString = "2019-07-01";
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
			
			employee.setDob(date);
			
			employeeDAO.update(employee);
			
			System.out.println("Data Berhasil Tersimpan");
			
			return true;
			
		} catch (Exception e) {
			System.out.println("Data Gagal Tersimpan");
			e.printStackTrace();
			return false;
		}
	}
	
	//@Bean
	public boolean delete() {
		try {
			employeeDAO.delete(28);
			System.out.println("Data Berhasil Dihapus");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Data Gagal Dihapus");
			e.printStackTrace();
			return false;
		}
	}
	
	@Bean
	public List<Employee> getByName(){
		
		List<Employee> employees = employeeDAO.getByName("opop");
		
		for (Employee employee : employees) {
			System.out.println("ID : " + employee.getId());
			System.out.println("Name : " + employee.getName());
			System.out.println("Address : " + employee.getAddress());
			System.out.println("DOB : " + employee.getDob());
			System.out.println("====================================");
		}

		return employees;

	

		
	}
}
