package com.eksad.latihanjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.eksad.latihanjpa.model.Employee;

@Repository //tidak perlu meninisiasi lagi seperti employee employee = new enmployee
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		
		return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
		
	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Employee.class, id);
	}

	@Transactional
	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
		entityManager.persist(employee);
		
	}

	@Transactional
	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.merge(employee);
	}

	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Employee employee = getById(id);
		entityManager.remove(employee);
		
	}

	@Override
	public List<Employee> getByName(String name) {
		return entityManager.createNativeQuery("select * from employee where name like '%?0%'", Employee.class)

		//return entityManager.createQuery("select e from Employee e where e.name like ?0 ", Employee.class)
		.setParameter(0, "%" + name + "%")
		.getResultList();
	}

}
