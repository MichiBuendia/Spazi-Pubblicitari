package org.engim;

import java.util.LinkedList;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.engim.database.CampagnaPubblicitaria;
import org.engim.database.TariffaInserzione;

public class CampagnePage extends WebPage
{
  public CampagnePage()
  {
    List<IColumn<CampagnaPubblicitaria, String>>
            colonne = new LinkedList<>();
    
    IColumn<CampagnaPubblicitaria, String>
       nome = new PropertyColumn<>(
               Model.of("Nome"), "nome");
    
    colonne.add(nome);
    
    IColumn<CampagnaPubblicitaria, String>
      tariffa = 
       new AbstractColumn<CampagnaPubblicitaria, String>(
              Model.of("Tariffa migliore"))
      {
        @Override
        public void populateItem(
          Item<ICellPopulator<CampagnaPubblicitaria>> item,
          String wicket_id, 
          IModel<CampagnaPubblicitaria> model)
        {
           CampagnaPubblicitaria bean = 
                     model.getObject();
           TariffaInserzione migliore =
             new CampagnaDAO().
                     getTariffaMigliore(bean);
           String daVisualizzare =
             migliore.getNomeTariffa() +
             " " + migliore.getCosto() +
             " " + migliore.getNomeTestata();
           Label l = new Label(wicket_id,
                               daVisualizzare);
           item.add(l);
        }        
      };
    
    colonne.add(tariffa);
    
    SPDataProvider<CampagnaPubblicitaria>
      cdp = new SPDataProvider<>
            (CampagnaPubblicitaria.class);
    
    DataTable<CampagnaPubblicitaria, String>
      cp = new DefaultDataTable<>("campagne",
                                  colonne,
                                  cdp, 10);
    add(cp);
    
  }
}
