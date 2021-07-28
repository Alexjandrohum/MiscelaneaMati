package ms.miscelanea.mati.address.repository;

import ms.miscelanea.mati.address.dto.CompanyDto;
import ms.miscelanea.mati.address.dto.MessageGenericDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.sql.Blob;

@Repository
public class CompanyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ResponseEntity createCompany(CompanyDto companyDto) {
        StoredProcedureQuery spq = getStoredProcedure("SP_CREATE_COMPANY");

        spq.registerStoredProcedureParameter("C_ID", Integer.class, ParameterMode.OUT);
        spq.registerStoredProcedureParameter("C_NAME", String.class, ParameterMode.INOUT);
        spq.registerStoredProcedureParameter("C_CONTACT_NAME", String.class, ParameterMode.INOUT);
        spq.registerStoredProcedureParameter("C_CONTACT_TITLE", String.class, ParameterMode.INOUT);
        spq.registerStoredProcedureParameter("C_PHONE", String.class, ParameterMode.INOUT);
        spq.registerStoredProcedureParameter("C_ID_ADDRESS", Integer.class, ParameterMode.INOUT);
        spq.registerStoredProcedureParameter("C_PHOTO", Blob.class, ParameterMode.INOUT);
        spq.registerStoredProcedureParameter("CODE", Integer.class, ParameterMode.OUT);
        spq.registerStoredProcedureParameter("MSG", String.class, ParameterMode.OUT);

        spq.setParameter("C_NAME",companyDto.getCompanyName());
        spq.setParameter("C_CONTACT_NAME", companyDto.getContactName());
        spq.setParameter("C_CONTACT_TITLE", companyDto.getContactTitle());
        spq.setParameter("C_PHONE", companyDto.getPhone());
        spq.setParameter("C_ID_ADDRESS", companyDto.getIdAddress());
        spq.setParameter("C_PHOTO", companyDto.getPhoto());

        spq.execute();

        Integer idCompany = (Integer) spq.getOutputParameterValue("C_ID");
        String companyName = (String) spq.getOutputParameterValue("C_NAME");
        String contactName = (String) spq.getOutputParameterValue("C_CONTACT_NAME");
        String contactTitle = (String) spq.getOutputParameterValue("C_CONTACT_TITLE");
        String companyPhone = (String) spq.getOutputParameterValue("C_PHONE");
        Integer idAddress = (Integer) spq.getOutputParameterValue("C_ID_ADDRESS");
        Blob companyPhoto = (Blob) spq.getOutputParameterValue("C_PHOTO");
        Integer code = (Integer) spq.getOutputParameterValue("CODE");
        String msg = (String) spq.getOutputParameterValue("MSG");

        if(code == 0){
            return new ResponseEntity(new CompanyDto(idCompany, companyName, contactName, contactTitle, companyPhone, idAddress, companyPhoto), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new MessageGenericDto(HttpStatus.INTERNAL_SERVER_ERROR,msg, "No se pudo procesar la petición"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private StoredProcedureQuery getStoredProcedure(String store) {
        return entityManager.createStoredProcedureQuery(store);
    }

}
