package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Objects;


@Getter
@Setter
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column

    private String name;
    @Column

    private String surname;
    @Column

    @Enumerated(EnumType.STRING)
    private UserStatus status;
    @Column

    private String email;
    @Column

    private Integer phone;
    @Column
    private LocalDate creationdate;

    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public User() {

    }

    public User(String name, String surname, UserStatus status, String email, int phoneNumber, LocalDate creationdate) {
        this.name = name;
        this.surname = surname;
        this.status = status;
        this.email = email;
        this.phone = phoneNumber;
        this.creationdate = creationdate;
    }

    public User(int id,String name, String surname, UserStatus status, String email, int phoneNumber, LocalDate creationdate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.status = status;
        this.email = email;
        this.phone = phoneNumber;
        this.creationdate = creationdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                status == user.status &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(creationdate, user.creationdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, status, email, phone, creationdate);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", status=" + status +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", creationdate='" + creationdate + '\'' +
                '}';
    }

}
