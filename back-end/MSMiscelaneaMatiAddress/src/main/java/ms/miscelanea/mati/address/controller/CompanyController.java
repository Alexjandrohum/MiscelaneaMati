package ms.miscelanea.mati.address.controller;

import ms.miscelanea.mati.address.dto.CompanyDto;
import ms.miscelanea.mati.address.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/company/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CompanyController {

    @Autowired
    private CompanyService serviceComoany;

    @PostMapping("/create")
    public ResponseEntity createCompany(CompanyDto companyDto) {
        return serviceComoany.createCompany(companyDto);
    }
}
