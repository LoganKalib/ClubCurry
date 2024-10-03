package za.ac.cput.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long unId;

    private String id;

    private String model, color, make;

    protected Vehicle(){}

    public Vehicle(Builder obj) {
        this.unId = obj.unId;
        this.id = obj.id;
        this.model = obj.model;
        this.color = obj.color;
        this.make = obj.make;
    }

    public long getUnId() {
        return unId;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getMake() {
        return make;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) && Objects.equals(model, vehicle.model) && Objects.equals(color, vehicle.color) && Objects.equals(make, vehicle.make);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, color, make);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", make='" + make + '\'' +
                '}';
    }

    public static class Builder{
        private String id;
        private long unId;
        private String model, color, make;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setUnId(long unId) {
            this.unId = unId;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setMake(String make) {
            this.make = make;
            return this;
        }

        public Builder copy(Vehicle obj){
            this.unId = obj.unId;
            this.id = obj.id;
            this.model = obj.model;
            this.color = obj.color;
            this.make = obj.make;
            return this;
        }

        public Vehicle build(){
            return new Vehicle(this);
        }
    }
}
