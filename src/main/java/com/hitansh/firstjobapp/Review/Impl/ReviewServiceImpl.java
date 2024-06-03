package com.hitansh.firstjobapp.Review.Impl;

import com.hitansh.firstjobapp.Review.Review;
import com.hitansh.firstjobapp.Review.ReviewRepository;
import com.hitansh.firstjobapp.Review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public  List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }
}
