package com.wordpress.chhaichivon.ui.panels.users;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;


/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 7/17/2017
 * TIME   : 3:04 PM
 */

public class UserFormPanel extends CustomComponent implements View, Button.ClickListener {

    private final TextField user;

    private final PasswordField password;

    private final Button loginButton;

    private UserFormPanel userFormPanel;

    public UserFormPanel(){
        setSizeFull();
        // Create the user input field
        user = new TextField("User:");
        user.setWidth("300px");
       /* user.setRequired(true);
        user.setInputPrompt("Your username (eg. joe@email.com)");
        user.addValidator(new EmailValidator("Username must be an email address"));
        user.setInvalidAllowed(false);*/

        // Create the password input field
        password = new PasswordField("Password:");
        password.setWidth("300px");
        /*password.addValidator(new PasswordValidator());
        password.setRequired(true);
        password.setValue("");
        password.setNullRepresentation("");*/

        // Create login button
        loginButton = new Button("Login", this);

        // Add both to a panel
        VerticalLayout fields = new VerticalLayout(user, password, loginButton);
        fields.setCaption("Please login to access the application. (test@test.com/passw0rd)");
        fields.setSpacing(true);
        fields.setMargin(new MarginInfo(true, true, true, false));
        fields.setSizeUndefined();

        // The view root layout
        VerticalLayout viewLayout = new VerticalLayout(fields);
        viewLayout.setSizeFull();
        viewLayout.setComponentAlignment(fields, Alignment.MIDDLE_CENTER);
       // viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
        setCompositionRoot(viewLayout);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {

    }

    public UserFormPanel setUserFormPanel(UserFormPanel userFormPanel){
        return this.userFormPanel  = userFormPanel;
    }

}
