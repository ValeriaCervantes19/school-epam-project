package com.epam.school.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Teacher generated by hbm2java
 */
@Entity
@Table(name = "teacher", catalog = "school_epam_project")
public class Teacher implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private EpamUser user;
	private String name;
	private String lastname;
	private Set<Student> students = new HashSet<Student>(0);

	public Teacher() {
	}

	public Teacher(EpamUser user, String name, String lastname) {
		this.user = user;
		this.name = name;
		this.lastname = lastname;
	}

	public Teacher(EpamUser user, String name, String lastname, Set<Student> students) {
		this.user = user;
		this.name = name;
		this.lastname = lastname;
		this.students = students;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	public EpamUser getUser() {
		return this.user;
	}

	public void setUser(EpamUser user) {
		this.user = user;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "lastname", nullable = false, length = 45)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}