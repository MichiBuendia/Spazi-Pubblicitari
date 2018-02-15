package org.engim.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "banner")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "Banner.findAll", query = "SELECT b FROM Banner b")
  , @NamedQuery(name = "Banner.findById", query = "SELECT b FROM Banner b WHERE b.id = :id")
  , @NamedQuery(name = "Banner.findByCodice", query = "SELECT b FROM Banner b WHERE b.codice = :codice")
  , @NamedQuery(name = "Banner.findByDescrizione", query = "SELECT b FROM Banner b WHERE b.descrizione = :descrizione")
  , @NamedQuery(name = "Banner.findByArea", query = "SELECT b FROM Banner b WHERE b.area = :area")
})
public class Banner implements Serializable,
                               ChiavePrimaria {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Size(max = 20)
  @Column(name = "codice")
  private String codice;
  @Size(max = 200)
  @Column(name = "descrizione")
  private String descrizione;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "area")
  private BigDecimal area;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBanner")
  private Collection<Inserzione> inserzioneCollection;

  public Banner()
  {
  }

  public Banner(Integer id)
  {
    this.id = id;
  }

  @Override
  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getCodice()
  {
    return codice;
  }

  public void setCodice(String codice)
  {
    this.codice = codice;
  }

  public String getDescrizione()
  {
    return descrizione;
  }

  public void setDescrizione(String descrizione)
  {
    this.descrizione = descrizione;
  }

  public BigDecimal getArea()
  {
    return area;
  }

  public void setArea(BigDecimal area)
  {
    this.area = area;
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
    if (!(object instanceof Banner))
    {
      return false;
    }
    Banner other = (Banner) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "org.engim.database.Banner[ id=" + id + " ]";
  }

}
