package za.ac.cput.factory;

import za.ac.cput.domain.Orders;
import za.ac.cput.domain.Rating;
import za.ac.cput.domain.enums.RatingStars;

public class RatingFactory {

    public static Rating buildRating(RatingStars foodQuality, RatingStars deliveryQuality, RatingStars atmosphereQuality, RatingStars serviceQuality){
        if(foodQuality !=null && deliveryQuality !=null){
            return new Rating.Builder()
                    .setFoodQuality(foodQuality)
                    .setDeliveryQuality(deliveryQuality)
                    .setAtmosphereQuality(atmosphereQuality)
                    .setServiceQuality(serviceQuality)
                    .build();
        }
        return null;
    }
    public static Rating buildRating(Long id, RatingStars foodQuality, RatingStars deliveryQuality,  RatingStars atmosphereQuality, RatingStars serviceQuality){
        if(id>0 && foodQuality !=null && deliveryQuality !=null){
            return new Rating.Builder()
                    .setId(id)
                    .setFoodQuality(foodQuality)
                    .setDeliveryQuality(deliveryQuality)
                    .setAtmosphereQuality(atmosphereQuality)
                    .setServiceQuality(serviceQuality)
                    .build();
        }
        return null;
    }
}
