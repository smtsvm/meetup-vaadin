package com.lbs.meetup;

import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = "user")
public class UserUI extends UI {

    @Autowired
    private UserService userService;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        FormLayout formLayout = new FormLayout();
        TextField usernameField = new TextField("Username");
        DateField birthDateField = new DateField("Birth Date");
        Button saveButton = new Button("Save");

        formLayout.addComponents(usernameField, birthDateField, saveButton);
        VerticalLayout contentLayout = new VerticalLayout();
        contentLayout.setSizeFull();
        formLayout.setWidth(500,Unit.PIXELS);
        contentLayout.addComponent(formLayout);
        contentLayout.setComponentAlignment(formLayout, Alignment.MIDDLE_CENTER);
        setContent(contentLayout);

        Grid<User> userGrid = new Grid<>();
        System.out.println(userService.getUserList());
        userGrid.setDataProvider(new ListDataProvider<>(userService.getUserList()));
        userGrid.addColumn(User::getUsername).setCaption("Username");
        userGrid.addColumn(User::getBirthDate).setCaption("Birth Date");
        contentLayout.addComponent(userGrid);
        userGrid.setSizeFull();
        saveButton.addClickListener(e-> {
            userService.addUser(usernameField.getValue(), birthDateField.getValue());
            userGrid.setDataProvider(new ListDataProvider<>(userService.getUserList()));
            usernameField.setValue("");
            birthDateField.setValue(null);
        });
    }


}
