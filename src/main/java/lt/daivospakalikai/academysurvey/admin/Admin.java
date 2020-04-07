package lt.daivospakalikai.academysurvey.admin;

import java.util.Objects;

public class Admin {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String surname;

    public Admin() {

    }

    public Admin(Integer id, String username, String password, String name, String surname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id) &&
                Objects.equals(username, admin.username) &&
                Objects.equals(password, admin.password) &&
                Objects.equals(name, admin.name) &&
                Objects.equals(surname, admin.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name, surname);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
