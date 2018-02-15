package org.engim.database;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "campagna_pubblicitaria")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "CampagnaPubblicitaria.findAll", query = "SELECT c FROM CampagnaPubblicitaria c")
  , @NamedQuery(name = "CampagnaPubblicitaria.findById", query = "SELECT c FROM CampagnaPubblicitaria c WHERE c.id = :id")
  , @NamedQuery(name = "CampagnaPubblicitaria.findByNome", query = "SELECT c FROM CampagnaPubblicitaria c WHERE c.nome = :nome")
})
public class CampagnaPubblicitaria implements Serializable,
                                              ChiavePrimaria {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Size(max = 20)
  @Column(name = "nome")
  private String nome;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCampagna", fetch = FetchType.EAGER)
  private Collection<Inserzione> inserzioneCollection;

  public CampagnaPubblicitaria()
  {
  }

  public CampagnaPubblicitaria(Integer id)
  {
    this.id = id;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getNome()
  {
    return nome;
  }

  public void setNome(String nome)
  {
    this.nome = nome;
  }

  @XmlTransient
  public Collection<Inserzione> getInserzioneCollection()
  {
    return inserzioneCollection;
  }

  public void setInserzioneCollection(Collection<Inserzione> inserzioneCollection)
  {
    this.inserzioneCollection = inserzioneCollection;
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
    if (!(object instanceof CampagnaPubblicitaria))
    {
      return false;
    }
    CampagnaPubblicitaria other = (CampagnaPubblicitaria) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "org.engim.database.CampagnaPubblicitaria[ id=" + id + " ]";
  }

}
