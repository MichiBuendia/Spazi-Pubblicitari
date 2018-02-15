package org.engim;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.engim.database.CampagnaPubblicitaria;
import org.engim.database.Inserzione;
import org.engim.database.TariffaInserzione;
import org.hibernate.sql.Insert;

public class CampagnaDAO 
{
  public TariffaInserzione 
        getTariffaMigliore(
                CampagnaPubblicitaria cp)
  {
    // Passo 1: trovo tutte le inserzioni di 
    // questa campagna (cp)
    EntityManager db = PM.db();
    try
    {
      CampagnaPubblicitaria reloaded = 
        db.find(CampagnaPubblicitaria.class, cp.getId());
      Collection<Inserzione> ins 
        = reloaded.getInserzioneCollection();
      float areaTotale = 0;
      for (Inserzione i: ins)
      {
        float areaInserzione =
          i.getIdBanner().getArea().floatValue() 
          * i.getNumeroPagine();
        areaTotale += areaInserzione;
      }
      
      Query campq = db.
        createNamedQuery(
           "TariffaInserzione.trovaPerArea");
      
      campq.setParameter("area", new BigDecimal(areaTotale));
      List<TariffaInserzione> tariffe =
        campq.getResultList();
      TariffaInserzione migliore =
        tariffe.get(0);
      
      return migliore;
    }
    finally
    {
      db.close();
    }
  }
}
