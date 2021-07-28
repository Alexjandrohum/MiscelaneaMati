package ms.miscelanea.mati.address.service;

import ms.miscelanea.mati.address.dto.AddressDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AddressService {

    ResponseEntity createAddress(AddressDto addressDto);

    List<AddressDto> getListAddress();
}
