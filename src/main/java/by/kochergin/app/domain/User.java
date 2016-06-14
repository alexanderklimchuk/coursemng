package by.kochergin.app.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user")
public class User implements java.io.Serializable {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	@Column(name = "login", nullable = false, length = 45)
	private String login;
	@Column(name = "password", nullable = false, length = 45)
	private String password;
	@Column(name = "role", nullable = false, length = 45)
	private String role;
	@Column(name = "isActve")
	private Boolean isActve;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Trainer> trainers = new HashSet<Trainer>(0);
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Parent> parents = new HashSet<Parent>(0);

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActve() {
		return this.isActve;
	}

	public void setIsActve(Boolean isActve) {
		this.isActve = isActve;
	}

	public Set<Trainer> getTrainers() {
		return this.trainers;
	}

	public void setTrainers(Set<Trainer> trainers) {
		this.trainers = trainers;
	}

	public Set<Parent> getParents() {
		return this.parents;
	}

	public void setParents(Set<Parent> parents) {
		this.parents = parents;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
