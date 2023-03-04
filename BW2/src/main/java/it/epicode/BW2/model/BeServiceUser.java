package it.epicode.BW2.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the be_service_users database table.
 * 
 */
@Entity
@Table(name="be_service_users")
@NamedQuery(name="BeServiceUser.findAll", query="SELECT b FROM BeServiceUser b")
public class BeServiceUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=50)
	private String cognome;

	@Column(length=50)
	private String email;

	@Column(length=50)
	private String nome;

	@Column(length=120)
	private String password;

	@Column(length=20)
	private String username;

	//bi-directional many-to-many association to BeServiceRole
	@ManyToMany
	@JoinTable(
		name="be_service_user_roles"
		, joinColumns={
			@JoinColumn(name="user_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="role_id", nullable=false)
			}
		)
	private List<BeServiceRole> beServiceRoles;

	public BeServiceUser() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<BeServiceRole> getBeServiceRoles() {
		return this.beServiceRoles;
	}

	public void setBeServiceRoles(List<BeServiceRole> beServiceRoles) {
		this.beServiceRoles = beServiceRoles;
	}

}