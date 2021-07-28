package ms.miscelanea.mati.address.service;

import ms.miscelanea.mati.address.dto.CompanyDto;
import ms.miscelanea.mati.address.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public ResponseEntity createCompany(CompanyDto companyDto) {
        return companyRepository.createCompany(companyDto);
    }
}
