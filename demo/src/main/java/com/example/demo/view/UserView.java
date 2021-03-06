package com.example.demo.view;

import com.example.demo.entity.User;
import com.example.demo.entity.UserStatus;
import com.example.demo.service.UserService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.primefaces.PrimeFaces;
import org.primefaces.model.FilterMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@ManagedBean
@ViewScoped
@Component
@Getter
@Setter
public class UserView implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean active;

    private final UserService userService;

    private List<User> users;
    private List<User> filteredUsers;
    private User user = new User();

    private List<FilterMeta> filterBy;
    private User selectedUser;

    @Autowired
    public UserView(UserService userService) {
        this.userService = userService;
    }


    @PostConstruct
    public void loadUsers() {
       filteredUsers=new ArrayList<>();
        users = userService.findAllUser();


    }


    public List<User> getUsers() {
        return userService.findAllUser();
    }


    public void deleteUser() {
        User u = userService.findUser(selectedUser.getId());
        userService.deleteUser(u);
        users = userService.findAllUser();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User remove"));
        PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-users");
    }

    public void change() {
        User u = userService.findUser(selectedUser.getId());
        UserStatus userStatus = this.selectedUser.getStatus();
        if (userStatus.name() == "ACTIVE") {
            u.setStatus(UserStatus.DEACTIVE);
        } else {
            u.setStatus(UserStatus.ACTIVE);
        }
        userService.editUser(u);
        users = userService.findAllUser();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Status changed"));
        PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-users");
    }


    public void saveUser() {
        User u = userService.findUser(selectedUser.getId());
        u.setName(selectedUser.getName());
        u.setSurname(selectedUser.getSurname());
        u.setEmail(selectedUser.getEmail());
        u.setPhone(selectedUser.getPhone());
        userService.editUser(u);
        users = userService.findAllUser();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User Updated"));
        PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-users");
    }




}
