package com.wordpress.chhaichivon.ui.panels.login;

import com.vaadin.annotations.Title;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.UserError;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;


import javax.annotation.PostConstruct;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 7/17/2017
 * TIME   : 3:32 PM
 */
@UIScope
@SpringView(name = UserLoginPanel.NAME)
@Title("Login")
public class UserLoginPanel extends VerticalLayout implements View{
    public static final String NAME  = "login";

    private TextField ftUserName;
    private TextField ftPassword;
    private FormLayout formLayout;

    TextField user;
    PasswordField password;
    //Button loginButton = new Button("Login", this::loginButtonClick);
    Button loginButton = new Button("Login");
    private static final String username = "username";
    private static final String passwordValue = "test123";


    @PostConstruct
    void init() {
        setMargin(true);
        setSpacing(true);

        ftUserName = new TextField("Username");
        ftPassword = new TextField("Password");
        formLayout  = new FormLayout();
        formLayout.addComponent(ftUserName);
        formLayout.addComponent(ftPassword);




        FormLayout form = new FormLayout();
        TextField tf1 = new TextField("Name");
        tf1.setIcon(VaadinIcons.USER);
        tf1.setRequiredIndicatorVisible(true);
        form.addComponent(tf1);

        TextField tf2 = new TextField("Street address");
        tf2.setIcon(VaadinIcons.ROAD);
        form.addComponent(tf2);

        TextField tf3 = new TextField("Postal code");
        tf3.setIcon(VaadinIcons.ENVELOPE);
        form.addComponent(tf3);
        // normally comes from validation by Binder
        tf3.setComponentError(new UserError("Doh!"));

        TextField name = new TextField("Name");
        name.setIcon(VaadinIcons.USER);
        form.addComponent(name);

        // Button allows specifying icon resource in constructor
        Button ok = new Button("OK", VaadinIcons.CHECK);
        form.addComponent(ok);



        setSizeFull();

        user = new TextField("User:");
        user.setWidth("300px");
        user.setRequiredIndicatorVisible(true);

        password = new PasswordField("Password:");
        password.setWidth("300px");
        user.setRequiredIndicatorVisible(true);
        password.setValue("");

        VerticalLayout fields = new VerticalLayout(user, password, loginButton);
        VerticalLayout uiLayout = new VerticalLayout(fields);
        uiLayout.setSizeFull();
        uiLayout.setComponentAlignment(fields, Alignment.MIDDLE_CENTER);

       // setFocusedComponent(user);

        //setContent(uiLayout);

        addComponent(uiLayout);
        addComponent(form);
    }
    /*public void loginButtonClick(Button.ClickEvent e) {
        //authorize/authenticate user
        //tell spring that my user is authenticated and dispatch to my mainUI
        iSecurity.autoLogin(user.getValue(), password.getValue());
    }*/
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
