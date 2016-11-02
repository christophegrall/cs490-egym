package com.cs490.egym.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.cs490.egym.enums.AuthorityName;

@Entity
@Table(name="AUTHORITY")
public class Authority {
	@Id
	@Column(name="AUTHORITY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="NAME")
	@Enumerated(EnumType.STRING)
	@NotNull
	private AuthorityName name;
	
	@ManyToMany(mappedBy="authorities", fetch=FetchType.LAZY)
	private List<User> users;
	
	protected Authority() {}

	public Authority(Integer id, AuthorityName name, List<User> users) {
		this.id = id;
		this.name = name;
		this.users = users;
	}

	public Authority(AuthorityName name, List<User> users) {
		this.name = name;
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AuthorityName getName() {
		return name;
	}

	public void setName(AuthorityName name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return String.format("Authority [id=%s, name=%s, users=%s]", id, name, users);
	}
}
