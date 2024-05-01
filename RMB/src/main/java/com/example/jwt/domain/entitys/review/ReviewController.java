package com.example.jwt.domain.entitys.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;


    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> findById(@PathVariable UUID id) {
      Review review = reviewService.findById(id);
      return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<Review>> findAll(){
        List<Review> reviews = reviewService.findAll();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    //ACHTUNG, PK funktioniert noch nicht... Kann vorerst nur mit neuen Companys verwendet werden
    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@Validated @RequestBody Review review){
        Review review1 = reviewService.save(review);
        return new ResponseEntity<>(review1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable UUID id, @Validated @RequestBody Review review){
        Review review1 = reviewService.updateById(id, review);
        return new ResponseEntity<>(review1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        reviewService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
