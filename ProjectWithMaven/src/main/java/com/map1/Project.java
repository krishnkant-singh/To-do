package com.map1;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int pid;
	@Column(name="project_name")
	private String projectname;
	@ManyToMany(mappedBy="projects")
//	@ManyToMany
//	@JoinTable(name="emp_learn",
//			joinColumns= {@JoinColumn(name="eid")},
//			inverseJoinColumns = {@JoinColumn(name="pid")})
	private List<Emp> employee;
	
	
	public Project(int pid, String projectname, List<Emp> employee) {
		super();
		this.pid = pid;
		this.projectname = projectname;
		this.employee = employee;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public List<Emp> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Emp> employee) {
		this.employee = employee;
	}

}
