package com.hitansh.firstjobapp.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Long id,Company company);

}
