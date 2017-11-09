package com.phuong.entities;
// Generated Nov 9, 2017 9:42:06 AM by Hibernate Tools 5.2.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PhuongPersonalProjectRoleId generated by hbm2java
 */
@Embeddable
public class PhuongPersonalProjectRoleId implements java.io.Serializable {

	private int idPersonal;
	private int idProjectRole;

	public PhuongPersonalProjectRoleId() {
	}

	public PhuongPersonalProjectRoleId(int idPersonal, int idProjectRole) {
		this.idPersonal = idPersonal;
		this.idProjectRole = idProjectRole;
	}

	@Column(name = "id_personal", nullable = false)
	public int getIdPersonal() {
		return this.idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}

	@Column(name = "id_project_role", nullable = false)
	public int getIdProjectRole() {
		return this.idProjectRole;
	}

	public void setIdProjectRole(int idProjectRole) {
		this.idProjectRole = idProjectRole;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PhuongPersonalProjectRoleId))
			return false;
		PhuongPersonalProjectRoleId castOther = (PhuongPersonalProjectRoleId) other;

		return (this.getIdPersonal() == castOther.getIdPersonal())
				&& (this.getIdProjectRole() == castOther.getIdProjectRole());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdPersonal();
		result = 37 * result + this.getIdProjectRole();
		return result;
	}

}
