package ms.miscelanea.mati.address.service;

import ms.miscelanea.mati.address.dto.CompanyDto;
import org.springframework.http.ResponseEntity;

public interface CompanyService {

    ResponseEntity createCompany(CompanyDto companyDto);

}
