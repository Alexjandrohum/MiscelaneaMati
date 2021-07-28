package ms.miscelanea.mati.address.repository;

import ms.miscelanea.mati.address.dto.AddressDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import ms.miscelanea.mati.address.dto.MessageGenericDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AddressRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ResponseEntity createAddress(AddressDto addressDto) {
        StoredProcedureQuery storedProcedureQuery = getStoredProcedure("SP_CREATE_ADDRESS");

        storedProcedureQuery.registerStoredProcedureParameter("A_ID", Integer.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("A_NAME", String.class, ParameterMode.INOUT);
        storedProcedureQuery.registerStoredProcedureParameter("A_NUMBER_INSIDE", String.class, ParameterMode.INOUT);
        storedProcedureQuery.registerStoredProcedureParameter("A_NUMBER_OUTSIDE", String.class, ParameterMode.INOUT);
        storedProcedureQuery.registerStoredProcedureParameter("A_CITY", String.class, ParameterMode.INOUT);
        storedProcedureQuery.registerStoredProcedureParameter("A_REGION", String.class, ParameterMode.INOUT);
        storedProcedureQuery.registerStoredProcedureParameter("A_POSTAL_CODE", Integer.class, ParameterMode.INOUT);
        storedProcedureQuery.registerStoredProcedureParameter("A_FAX", String.class, ParameterMode.INOUT);
        storedProcedureQuery.registerStoredProcedureParameter("A_PHONE", String.class, ParameterMode.INOUT);
        storedProcedureQuery.registerStoredProcedureParameter("CODE", Integer.class, ParameterMode.OUT);
        storedProcedureQuery.registerStoredProcedureParameter("MSG", String.class, ParameterMode.OUT);


        storedProcedureQuery.setParameter("A_NAME", addressDto.getNameAddress());
        storedProcedureQuery.setParameter("A_NUMBER_INSIDE", addressDto.getNumberInside());
        storedProcedureQuery.setParameter("A_NUMBER_OUTSIDE", addressDto.getNumberOutside());
        storedProcedureQuery.setParameter("A_CITY", addressDto.getCity());
        storedProcedureQuery.setParameter("A_REGION", addressDto.getRegion());
        storedProcedureQuery.setParameter("A_POSTAL_CODE", addressDto.getPostalCode());
        storedProcedureQuery.setParameter("A_FAX", addressDto.getFax());
        storedProcedureQuery.setParameter("A_PHONE", addressDto.getPhone());

        storedProcedureQuery.execute();

        Integer idAddress = (Integer) storedProcedureQuery.getOutputParameterValue("A_ID");
        String nameAddress = (String) storedProcedureQuery.getOutputParameterValue("A_NAME");
        String numberInside = (String) storedProcedureQuery.getOutputParameterValue("A_NUMBER_INSIDE");
        String numberOutside = (String) storedProcedureQuery.getOutputParameterValue("A_NUMBER_OUTSIDE");
        String city = (String) storedProcedureQuery.getOutputParameterValue("A_CITY");
        String region = (String) storedProcedureQuery.getOutputParameterValue("A_REGION");
        Integer postalCode = (Integer) storedProcedureQuery.getOutputParameterValue("A_POSTAL_CODE");
        String fax = (String) storedProcedureQuery.getOutputParameterValue("A_FAX");
        String phone = (String) storedProcedureQuery.getOutputParameterValue("A_PHONE");
        Integer code = (Integer) storedProcedureQuery.getOutputParameterValue("CODE");
        String msg = (String) storedProcedureQuery.getOutputParameterValue("MSG");

        if (code == 1) {
            throw new MessageGenericDto(HttpStatus.INTERNAL_SERVER_ERROR, msg, "Ocurrió un error interno en la aplicación.");
        }

        return new ResponseEntity(new AddressDto(idAddress, nameAddress, numberInside, numberOutside, city, region, postalCode, fax, phone), HttpStatus.ACCEPTED);
    }

    public List<AddressDto> getAddressList() {
        StoredProcedureQuery storedProcedureQuery = getStoredProcedure("SP_SELECT_ADDRESS");
        storedProcedureQuery.registerStoredProcedureParameter("cursor_address", Void.class, ParameterMode.REF_CURSOR);

        List<Object[]> listObject = storedProcedureQuery.getResultList();
        List<AddressDto> listAddress = new ArrayList<>();
        for (Object[] addressObject : listObject) {
            listAddress.add(
                    new AddressDto(
                            Integer.parseInt(addressObject[0].toString()),
                            addressObject[1].toString(),
                            (Optional.ofNullable(addressObject[2]).isPresent()) ? addressObject[2].toString() : "",
                            (Optional.ofNullable(addressObject[3]).isPresent()) ? addressObject[3].toString() : "",
                            (Optional.ofNullable(addressObject[4]).isPresent()) ? addressObject[4].toString() : "",
                            (Optional.ofNullable(addressObject[5]).isPresent()) ? addressObject[5].toString() : "",
                            (Optional.ofNullable(addressObject[6]).isPresent()) ? Integer.parseInt(addressObject[6].toString()) : 0,
                            (Optional.ofNullable(addressObject[7]).isPresent()) ? addressObject[7].toString() : "",
                            (Optional.ofNullable(addressObject[8]).isPresent()) ? addressObject[8].toString() : ""));
        }
        return listAddress;
    }

    private StoredProcedureQuery getStoredProcedure(String store) {
        return entityManager.createStoredProcedureQuery(store);
    }

}
