package com.hitansh.firstjobapp.Company.impl;

import com.hitansh.firstjobapp.Company.Company;
import com.hitansh.firstjobapp.Company.CompanyRepository;
import com.hitansh.firstjobapp.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImp implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImp(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
