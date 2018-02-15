package org.engim.database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "inserzione")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Inserzione.findAll", query = "SELECT i FROM Inserzione i")
  , @NamedQuery(name = "Inserzione.findById", query = "SELECT i FROM Inserzione i WHERE i.id = :id")
  , @NamedQuery(name = "Inserzione.findByNumeroPagine", query = "SELECT i FROM Inserzione i WHERE i.numeroPagine = :numeroPagine")
})
public class Inserzione implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "numero_pagine")
  private int numeroPagine;
  @JoinColumn(name = "id_campagna", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private CampagnaPubblicitaria idCampagna;
  @JoinColumn(name = "id_banner", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Banner idBanner;

  public Inserzione()
  {
  }

  public Inserzione(Integer id)
  {
    this.id = id;
  }

  public Inserzione(Integer id, int numeroPagine)
  {
    this.id = id;
    this.numeroPagine = numeroPagine;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public int getNumeroPagine()
  {
    return numeroPagine;
  }

  public void setNumeroPagine(int numeroPagine)
  {
    this.numeroPagine = numeroPagine;
  }

  public CampagnaPubblicitaria getIdCampagna()
  {
    return idCampagna;
  }

  public void setIdCampagna(CampagnaPubblicitaria idCampagna)
  {
    this.idCampagna = idCampagna;
  }

  public Banner getIdBanner()
  {
    return idBanner;
  }

  public void setIdBanner(Banner idBanner)
  {
    this.idBanner = idBanner;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Inserzione))
    {
      return false;
    }
    Inserzione other = (Inserzione) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "org.engim.database.Inserzione[ id=" + id + " ]";
  }

}
