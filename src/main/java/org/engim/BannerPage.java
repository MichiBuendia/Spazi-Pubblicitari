package org.engim;

import java.util.Date;
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
import org.engim.database.Banner;

public class BannerPage extends WebPage
{
  public BannerPage()
  {
    List<IColumn<Banner, String>> colonne = 
      new LinkedList<>();
    
    IColumn<Banner, String> cod =
      new PropertyColumn<>(Model.of("Codice"), 
                           "codice");
    colonne.add(cod);
    
    IColumn<Banner, String> desc =
      new PropertyColumn<>(Model.of("Descrizione"), 
                           "descrizione");
    colonne.add(desc);

    IColumn<Banner, String> area =
      new PropertyColumn<>(Model.of("Area"), 
                           "area");
    colonne.add(area);
    
    IColumn<Banner, String> calcolato = 
      new AbstractColumn<Banner, String>(
              Model.of("Calcolato"))
    {
      @Override
      public void populateItem(
              Item<ICellPopulator<Banner>> item, 
              String wicket_id, 
              IModel<Banner> model)
      {
        String valoreCalcolato = 
          (new Date()).toString();
        Label campo = new Label(wicket_id, 
                                valoreCalcolato);
        item.add(campo);
      }
    };
    
    colonne.add(calcolato);
    
    SPDataProvider<Banner> dp = 
      new SPDataProvider<>(Banner.class);
    DataTable<Banner, String> tab = 
      new DefaultDataTable<>("banner", colonne, dp, 10);
    
    add(tab);
    
  }
}
