package com.wordpress.chhaichivon.ui.panels.products;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.wordpress.chhaichivon.ui.panels.users.UserPanel;

import javax.annotation.PostConstruct;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 7/17/2017
 * TIME   : 2:32 PM
 */
@UIScope
@SpringView(name = ProductsPanel.NAME)
public class ProductsPanel extends VerticalLayout implements View {
    public static final String NAME = "products.panel";

    @PostConstruct
    void init() {
        setMargin(true);
        setSpacing(true);
        addComponent(new Label("Product Panels"));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
