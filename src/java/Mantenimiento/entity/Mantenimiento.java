/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mantenimiento.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mario
 */
@Entity
@Table(name = "MANTENIMIENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimiento.findAll", query = "SELECT m FROM Mantenimiento m"),
    @NamedQuery(name = "Mantenimiento.findByIdMantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.idMantenimiento = :idMantenimiento"),
    @NamedQuery(name = "Mantenimiento.findByTipoMantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.tipoMantenimiento = :tipoMantenimiento")})
public class Mantenimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MANTENIMIENTO")
    private Integer idMantenimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TIPO_MANTENIMIENTO")
    private String tipoMantenimiento;
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID_EQUIPO")
    @ManyToOne(optional = false)
    private Equipo idEquipo;

    public Mantenimiento() {
    }

    public Mantenimiento(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public Mantenimiento(Integer idMantenimiento, String tipoMantenimiento) {
        this.idMantenimiento = idMantenimiento;
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public Integer getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public String getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(String tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMantenimiento != null ? idMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimiento)) {
            return false;
        }
        Mantenimiento other = (Mantenimiento) object;
        if ((this.idMantenimiento == null && other.idMantenimiento != null) || (this.idMantenimiento != null && !this.idMantenimiento.equals(other.idMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mantenimiento.entity.Mantenimiento[ idMantenimiento=" + idMantenimiento + " ]";
    }
    
}
