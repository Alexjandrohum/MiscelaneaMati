package ms.miscelanea.mati.address.service;

import ms.miscelanea.mati.address.dto.AddressDto;
import ms.miscelanea.mati.address.dto.MessageGenericDto;
import ms.miscelanea.mati.address.repository.AddressRepository;
import ms.miscelanea.mati.address.util.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public ResponseEntity createAddress(AddressDto addressDto) {
        //Validations.getValidationAddress(addressDto);
        return addressRepository.createAddress(addressDto);
    }

    @Override
    public List<AddressDto> getListAddress() {
        return addressRepository.getAddressList();
    }
}
