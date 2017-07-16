package com.wordpress.chhaichivon.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.VaadinNavigatorConfiguration;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 7/16/2017
 * TIME   : 10:43 PM
 */
@Theme("valo")
@SpringUI
@SpringViewDisplay
public class MainUI extends UI implements ViewDisplay{

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		setContent(new Label("Home page"));
	}

	@Override
	public void showView(View view) {

	}
}
