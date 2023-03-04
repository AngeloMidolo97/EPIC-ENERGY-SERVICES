package it.epicode.BW2.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the be_service_roles database table.
 * 
 */
@Entity
@Table(name="be_service_roles")
@NamedQuery(name="BeServiceRole.findAll", query="SELECT b FROM BeServiceRole b")
public class BeServiceRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="role_name", length=20)
	private String roleName;

	//bi-directional many-to-many association to BeServiceUser
	@ManyToMany(mappedBy="beServiceRoles")
	private List<BeServiceUser> beServiceUsers;

	public BeServiceRole() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<BeServiceUser> getBeServiceUsers() {
		return this.beServiceUsers;
	}

	public void setBeServiceUsers(List<BeServiceUser> beServiceUsers) {
		this.beServiceUsers = beServiceUsers;
	}

}