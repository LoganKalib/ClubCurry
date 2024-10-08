package za.ac.cput.domain;

import jakarta.persistence.Entity;
import za.ac.cput.domain.enums.ExpertLevel;

import java.util.Objects;

@Entity
public class GeneralStaff extends Employee{

    protected GeneralStaff(){}

    public GeneralStaff(Builder obj){
        this.id = obj.id;
        this.name = obj.name;
        this.surname = obj.surname;
        this.password = obj.password;
        this.username = obj.username;
    }

    @Override
    public String toString() {
        return "GeneralStaff{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private String id;

        private String name, surname, username, password;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(GeneralStaff obj){
            this.id = obj.id;
            this.name = obj.name;
            this.surname = obj.surname;
            this.password = obj.password;
            this.username = obj.username;
            return this;
        }

        public GeneralStaff build(){
            return new GeneralStaff(this);
        }
    }
}
