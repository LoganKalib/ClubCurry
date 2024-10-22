package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.domain.enums.RatingStars;

import java.util.Objects;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private RatingStars foodQuality;

    private RatingStars serviceQuality;

    private RatingStars atmosphereQuality;

    private RatingStars deliveryQuality;

    protected Rating(){}

    public RatingStars getServiceQuality() {
        return serviceQuality;
    }

    public RatingStars getAtmosphereQuality() {
        return atmosphereQuality;
    }

    public Rating(Builder obj) {
        this.id = obj.id;
        this.foodQuality = obj.foodQuality;
        this.deliveryQuality = obj.deliveryQuality;
    }

    public long getId() {
        return id;
    }

    public RatingStars getFoodQuality() {
        return foodQuality;
    }

    public RatingStars getDeliveryQuality() {
        return deliveryQuality;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Rating rating = (Rating) object;
        return id == rating.id && foodQuality == rating.foodQuality && serviceQuality == rating.serviceQuality && atmosphereQuality == rating.atmosphereQuality && deliveryQuality == rating.deliveryQuality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, foodQuality, serviceQuality, atmosphereQuality, deliveryQuality);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +

                ", foodQuality=" + foodQuality +
                ", deliveryQuality=" + deliveryQuality +
                '}';
    }

    public static class Builder{
        private long id;



        private RatingStars foodQuality;

        public Builder setServiceQuality(RatingStars serviceQuality) {
            this.serviceQuality = serviceQuality;
            return this;
        }

        public Builder setAtmosphereQuality(RatingStars atmosphereQuality) {
            this.atmosphereQuality = atmosphereQuality;
            return this;
        }

        private RatingStars serviceQuality;

        private RatingStars atmosphereQuality;

        private RatingStars deliveryQuality;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }



        public Builder setFoodQuality(RatingStars foodQuality) {
            this.foodQuality = foodQuality;
            return this;
        }

        public Builder setDeliveryQuality(RatingStars deliveryQuality) {
            deliveryQuality = deliveryQuality;
            return this;
        }

        public Builder copy(Rating obj){
            this.id = obj.id;

            this.foodQuality = obj.foodQuality;
            this.deliveryQuality = obj.deliveryQuality;
            this.atmosphereQuality = obj.atmosphereQuality;
            this.serviceQuality = obj.serviceQuality;
            return this;
        }

        public Rating build(){
            return new Rating(this);
        }
    }
}