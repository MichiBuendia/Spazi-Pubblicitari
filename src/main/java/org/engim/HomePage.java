package org.engim;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		/*
    EntityManager db = PM.db();
    
    EntityManagerFactory fact = 
      Persistence.createEntityManagerFactory("engim-unit");
    EntityManager db2 = fact.createEntityManager();
    */

    BookmarkablePageLink banner = 
      new BookmarkablePageLink("bannerlink", 
              BannerPage.class);
    
    add(banner);
    
    BookmarkablePageLink campagne = 
      new BookmarkablePageLink("campagnelink", 
              CampagnePage.class);
    
    add(campagne);
    }
}
