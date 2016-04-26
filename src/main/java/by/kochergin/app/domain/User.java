package by.kochergin.app.domain;
// Generated 24.04.2016 10:10:15 by Hibernate Tools 3.2.2.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user")
public class User  implements java.io.Serializable {


     private int id;
     private String login;
     private String password;
     private Boolean isActve;
     private Set<Trainer> trainers = new HashSet<Trainer>(0);
     private Set<Parent> parents = new HashSet<Parent>(0);

    public User() {
    }

	
    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }
    public User(int id, String login, String password, Boolean isActve, Set<Trainer> trainers, Set<Parent> parents) {
       this.id = id;
       this.login = login;
       this.password = password;
       this.isActve = isActve;
       this.trainers = trainers;
       this.parents = parents;
    }
   
    @Id
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name="login", nullable=false, length=45)
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    @Column(name="password", nullable=false, length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name="isActve")
    public Boolean getIsActve() {
        return this.isActve;
    }
    
    public void setIsActve(Boolean isActve) {
        this.isActve = isActve;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="user")
    public Set<Trainer> getTrainers() {
        return this.trainers;
    }
    
    public void setTrainers(Set<Trainer> trainers) {
        this.trainers = trainers;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="user")
    public Set<Parent> getParents() {
        return this.parents;
    }
    
    public void setParents(Set<Parent> parents) {
        this.parents = parents;
    }




}


