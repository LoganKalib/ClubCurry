package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;
import za.ac.cput.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public class ReviewController {

    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    // Builds a new Review & saves it
    @PostMapping("/save")
    public ResponseEntity<Review> save(@RequestBody Review obj){
        Review review1 = ReviewFactory.buildReview(obj.getId(), obj.getRating(), obj.getCustomer(), obj.getNote());
        if(review1 ==null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.save(review1));
    }

    // Retrieves a Review by ID
    @GetMapping("/read/{id}")
    public ResponseEntity<Review> read(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.read(id));
    }

    // Updates an existing Review
    @PutMapping("/update")
    public ResponseEntity<Review> update(@RequestBody Review obj){
        Review review1 = ReviewFactory.buildReview(obj.getId(), obj.getRating(), obj.getCustomer(), obj.getNote());
        if(review1 == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);

        }
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.update(review1));
    }

    // Deletes a Review by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.delete(id));
    }

    // Retrieve a List of Reviews
    @GetMapping("/getAll")
    public ResponseEntity<List<Review>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getAll());
    }

    @GetMapping("/getAllByCustomerEmail/{email}")
    public ResponseEntity<List<Review>> getAllByCustomerEmail(@PathVariable String email){
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getReviewsByCustomerEmail(email));
    }
}
