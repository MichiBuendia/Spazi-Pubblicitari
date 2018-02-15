package org.engim.database;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tariffa_inserzione")
@XmlRootElement
@NamedQueries(
{
  @NamedQuery(name = "TariffaInserzione.findAll", query = "SELECT t FROM TariffaInserzione t")
  , @NamedQuery(name = "TariffaInserzione.findById", query = "SELECT t FROM TariffaInserzione t WHERE t.id = :id")
  , @NamedQuery(name = "TariffaInserzione.findByNomeTestata", query = "SELECT t FROM TariffaInserzione t WHERE t.nomeTestata = :nomeTestata")
  , @NamedQuery(name = "TariffaInserzione.findByNomeTariffa", query = "SELECT t FROM TariffaInserzione t WHERE t.nomeTariffa = :nomeTariffa")
  , @NamedQuery(name = "TariffaInserzione.findByAreaMax", query = "SELECT t FROM TariffaInserzione t WHERE t.areaMax = :areaMax")
  , @NamedQuery(name = "TariffaInserzione.findByCosto", query = "SELECT t FROM TariffaInserzione t WHERE t.costo = :costo")
  , @NamedQuery(name = "TariffaInserzione.trovaPerArea", query = "SELECT t FROM TariffaInserzione t WHERE t.areaMax >= :area ORDER BY t.costo")
})
public class TariffaInserzione implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Size(max = 20)
  @Column(name = "nome_testata")
  private String nomeTestata;
  @Size(max = 20)
  @Column(name = "nome_tariffa")
  private String nomeTariffa;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "area_max")
  private BigDecimal areaMax;
  @Column(name = "costo")
  private BigDecimal costo;

  public TariffaInserzione()
  {
  }

  public TariffaInserzione(Integer id)
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

  public String getNomeTestata()
  {
    return nomeTestata;
  }

  public void setNomeTestata(String nomeTestata)
  {
    this.nomeTestata = nomeTestata;
  }

  public String getNomeTariffa()
  {
    return nomeTariffa;
  }

  public void setNomeTariffa(String nomeTariffa)
  {
    this.nomeTariffa = nomeTariffa;
  }

  public BigDecimal getAreaMax()
  {
    return areaMax;
  }

  public void setAreaMax(BigDecimal areaMax)
  {
    this.areaMax = areaMax;
  }

  public BigDecimal getCosto()
  {
    return costo;
  }

  public void setCosto(BigDecimal costo)
  {
    this.costo = costo;
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
    if (!(object instanceof TariffaInserzione))
    {
      return false;
    }
    TariffaInserzione other = (TariffaInserzione) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "org.engim.database.TariffaInserzione[ id=" + id + " ]";
  }

}
