package com.epam.school.entities;

// Generated Oct 17, 2022, 7:20:08 PM by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Student generated by hbm2java
 */
@Entity
@Table(name = "student", catalog = "school_epam_project")
public class Student implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Lesson lesson;
	private Teacher teacher;
	private EpamUser user;
	private String name;
	private String lastname;

	public Student() {
	
	}

	public Student(Lesson lesson, Teacher teacher, EpamUser user, String name, String lastname) {
		this.lesson = lesson;
		this.teacher = teacher;
		this.user = user;
		this.name = name;
		this.lastname = lastname;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idlesson", nullable = false)
	public Lesson getLesson() {
		return this.lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idteacher", nullable = false)
	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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

}

