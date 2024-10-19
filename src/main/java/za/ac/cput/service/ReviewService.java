package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.ReviewRepo;
import za.ac.cput.service.interfaces.IReviewService;

import java.util.List;

@Service
public class ReviewService implements IReviewService{

    private ReviewRepo reviewRepo;


    @Autowired
    public ReviewService(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public Review save(Review obj) {
        return reviewRepo.save(obj);
    }

    @Override
    public Review read(Long aLong) {
        return reviewRepo.findById(aLong).orElse(null);
    }

    @Override
    public Review update(Review obj) {
        if(reviewRepo.existsById(obj.getId())){
            return reviewRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        if (reviewRepo.existsById(aLong)) {
            reviewRepo.deleteById(aLong);
            return true;
        }
        return false;
    }

    @Override
    public List<Review> getAll() {
        return reviewRepo.findAll();
    }

    @Override
    public List<Review> getReviewsByCustomerEmail(String email) {
        return reviewRepo.getReviewsByCustomer_Email(email);
    }
}
