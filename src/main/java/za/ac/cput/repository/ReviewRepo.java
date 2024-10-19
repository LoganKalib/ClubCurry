package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Review;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long>{
    List<Review> getReviewsByCustomer_Email(String email);
}
