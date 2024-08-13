package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	
 @Transactional
	public int insert(Student std) {
		Integer i=(Integer)this.hibernateTemplate.save(std);
		return i;
	}
	
	public Student getStudent(int S_id) {
		Student std=this.hibernateTemplate.get(Student.class, S_id);
		return std;
	}
	
	public List<Student> getAllStudent(){
		List<Student> std=this.hibernateTemplate.loadAll(Student.class);
		return std;
	}
	@Transactional
	public void deletstudent(int id) {
		Student std=this.hibernateTemplate.get(Student.class,id);
		this.hibernateTemplate.delete(std);
	}
	@Transactional
	public void updatestudent(Student std) {
		this.hibernateTemplate.update(std);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
