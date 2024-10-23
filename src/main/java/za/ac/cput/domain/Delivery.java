package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.domain.enums.DeliveryStatus;

import java.sql.Date;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean delivered;

    private Date completed;

    public LocalTime timeOfDelivery;

    private LocalTime estimatedDeliveryTime;

    private DeliveryStatus status;

    @ManyToOne
    private Driver driver;

    @OneToOne(cascade = CascadeType.ALL)
    private Orders order;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    protected Delivery(){}

    public Delivery(Builder obj) {
        this.id = obj.id;
        this.delivered = obj.delivered;
        this.completed = obj.completed;
        this.driver = obj.driver;
        this.order = obj.order;
        this.address = obj.address;
        this.estimatedDeliveryTime = obj.estimatedDeliveryTime;
        this.status = obj.status;
        this.timeOfDelivery = obj.timeOfDelivery;
    }

    public Address getAddress() {
        return address;
    }

    public long getId() {
        return id;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public Date getCompleted() {
        return completed;
    }

    public Driver getDriver() {
        return driver;
    }

    public Orders getOrder() {
        return order;
    }

    public LocalTime getTimeOfDelivery() {
        return timeOfDelivery;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return id == delivery.id && delivered == delivery.delivered && Objects.equals(completed, delivery.completed) && Objects.equals(driver, delivery.driver) && Objects.equals(order, delivery.order) && Objects.equals(address, delivery.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, delivered, completed, driver, order, address);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", delivered=" + delivered +
                ", completed=" + completed +
                ", driver=" + driver +
                ", order=" + order +
                ", address=" + address +
                '}';
    }

    public LocalTime getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public static class Builder{
        private long id;

        private boolean delivered;

        private Date completed;

        private Driver driver;

        private DeliveryStatus status;

        private LocalTime timeOfDelivery;

        private Orders order;

        private Address address;
        
        private LocalTime estimatedDeliveryTime;

        public Builder setTimeOfDelivery(LocalTime timeOfDelivery) {
            this.timeOfDelivery = timeOfDelivery;
            return this;
        }

        public Builder setStatus(DeliveryStatus status) {
            this.status = status;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setDelivered(boolean delivered) {
            this.delivered = delivered;
            return this;
        }

        public Builder setCompleted(Date completed) {
            this.completed = completed;
            return this;
        }

        public Builder setDriver(Driver driver) {
            this.driver = driver;
            return this;
        }

        public Builder setOrder(Orders order) {
            this.order = order;
            return this;
        }

        public Builder setEstimatedDeliveryTime(LocalTime estimatedDeliveryTime) {
            this.estimatedDeliveryTime = estimatedDeliveryTime;
            return this;
        }

        public Builder copy(Delivery obj){
            this.id = obj.id;
            this.delivered = obj.delivered;
            this.completed = obj.completed;
            this.driver = obj.driver;
            this.order = obj.order;
            this.address = obj.address;
            this.estimatedDeliveryTime= obj.estimatedDeliveryTime;
            this.status = obj.status;
            this.timeOfDelivery = obj.timeOfDelivery;
            return this;
        }

        public Delivery build(){
            return new Delivery(this);
        }
    }
}
