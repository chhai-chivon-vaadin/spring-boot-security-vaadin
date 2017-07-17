package com.wordpress.chhaichivon.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import com.wordpress.chhaichivon.ui.panels.login.UserLoginPanel;
import com.wordpress.chhaichivon.ui.panels.products.ProductsPanel;
import com.wordpress.chhaichivon.ui.panels.users.UserPanel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 7/16/2017
 * TIME   : 10:43 PM
 */
@Theme("mytheme")
@SpringUI
public class MainUI extends UI{

	// we can use either constructor autowiring or field autowiring
	@Autowired
	private SpringViewProvider viewProvider;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout root = new VerticalLayout();
			root.setSizeFull();
			root.setMargin(true);
			root.setSpacing(true);
			this.setContent(root);

		final CssLayout navigationBar = new CssLayout();
			navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
			navigationBar.addComponent(createNavigationButton("Login", UserLoginPanel.NAME));
			navigationBar.addComponent(createNavigationButton("User", UserPanel.NAME));
			navigationBar.addComponent(createNavigationButton("Products", ProductsPanel.NAME));
			root.addComponent(navigationBar);


		final Panel viewContainer = new Panel();
			viewContainer.setSizeFull();
			root.addComponent(viewContainer);
			root.setExpandRatio(viewContainer,1.0f);

		Navigator  navigator = new Navigator(this, viewContainer);
		navigator.addProvider(viewProvider);
	}
	private Button createNavigationButton(String caption, final String viewName) {
		Button button = new Button(caption);
		button.addStyleName(ValoTheme.BUTTON_LARGE);
		// If you didn't choose Java 8 when creating the project, convert this to an anonymous listener class
		button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
		return button;
	}
}
