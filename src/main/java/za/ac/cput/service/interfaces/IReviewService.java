package za.ac.cput.service.interfaces;

import za.ac.cput.domain.Review;

import java.util.List;

public interface IReviewService extends IService<Review, Long>{
    List<Review> getReviewsByCustomerEmail(String email);
}
