package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.domain.enums.CollectionType;
import za.ac.cput.domain.enums.OrderStatus;
import za.ac.cput.domain.enums.PaymentMethod;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date ordered;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Cart cart;

    private double total;

    private Time time;

    private PaymentMethod paymentMethod;

    private CollectionType collectionType;

    private OrderStatus orderStatus;

    @OneToOne(cascade = CascadeType.ALL)
    private GeneralStaff preparedBy;

    protected Orders(){}

    public Orders(Builder obj) {
        this.id = obj.id;
        this.ordered = obj.ordered;
        this.cart = obj.cart;
        this.total = obj.total;
        this.paymentMethod = obj.paymentMethod;
        this.collectionType = obj.collectionType;
        this.preparedBy = obj.preparedBy;
        this.time = obj.time;
        this.orderStatus = obj.orderStatus;
    }

    public long getId() {
        return id;
    }

    public Date getOrdered() {
        return ordered;
    }

    public Cart getCart() {
        return cart;
    }

    public double getTotal() {
        return total;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public CollectionType getCollectionType() {
        return collectionType;
    }

    public GeneralStaff getPreparedBy() {
        return preparedBy;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Orders orders = (Orders) object;
        return id == orders.id && Double.compare(total, orders.total) == 0 && Objects.equals(ordered, orders.ordered) && Objects.equals(cart, orders.cart) && Objects.equals(time, orders.time) && paymentMethod == orders.paymentMethod && collectionType == orders.collectionType && orderStatus == orders.orderStatus && Objects.equals(preparedBy, orders.preparedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ordered, cart, total, time, paymentMethod, collectionType, orderStatus, preparedBy);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", ordered=" + ordered +
                ", cart=" + cart +
                ", total=" + total +
                ", time=" + time +
                ", paymentMethod=" + paymentMethod +
                ", collectionType=" + collectionType +
                ", orderStatus=" + orderStatus +
                ", preparedBy=" + preparedBy +
                '}';
    }

    public static class Builder{
        private long id;

        private Date ordered;

        private Cart cart;

        private double total;

        private Time time;

        private PaymentMethod paymentMethod;

        private CollectionType collectionType;

        private GeneralStaff preparedBy;

        private OrderStatus orderStatus;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setOrdered(Date ordered) {
            this.ordered = ordered;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder setTotal(double total) {
            this.total = total;
            return this;
        }

        public Builder setPaymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setCollectionType(CollectionType collectionType) {
            this.collectionType = collectionType;
            return this;
        }

        public Builder setPreparedBy(GeneralStaff preparedBy) {
            this.preparedBy = preparedBy;
            return this;
        }

        public Builder setTime(Time time) {
            this.time = time;
            return this;
        }

        public Builder setOrderStatus(OrderStatus orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder copy(Orders obj){
            this.id = obj.id;
            this.ordered = obj.ordered;
            this.cart = obj.cart;
            this.total = obj.total;
            this.paymentMethod = obj.paymentMethod;
            this.collectionType = obj.collectionType;
            this.preparedBy = obj.preparedBy;
            this.time = obj.time;
            this.orderStatus = obj.orderStatus;
            return this;
        }

        public Orders build(){
            return new Orders(this);
        }
    }
}
