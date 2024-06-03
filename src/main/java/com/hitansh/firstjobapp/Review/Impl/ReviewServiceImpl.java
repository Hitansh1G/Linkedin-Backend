package com.hitansh.firstjobapp.Review.Impl;

import com.hitansh.firstjobapp.Company.Company;
import com.hitansh.firstjobapp.Company.CompanyService;
import com.hitansh.firstjobapp.Review.Review;
import com.hitansh.firstjobapp.Review.ReviewRepository;
import com.hitansh.firstjobapp.Review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService1) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService1;
    }

//    public ReviewServiceImpl(ReviewRepository reviewRepository) {
//        this.reviewRepository = reviewRepository;
//    }

    @Override
    public  List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review>reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId()
                        .equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if(companyService.getCompanyById(companyId)!=null){
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.getCompanyById(companyId)!=null && reviewRepository.existsById(reviewId)){
            Review review = reviewRepository.findById(reviewId).orElse(null);
            assert review != null;
            Company company = review.getCompany();
            company.getReviews().remove(review);
            companyService.updateCompany(companyId, company);
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;

    }


}
