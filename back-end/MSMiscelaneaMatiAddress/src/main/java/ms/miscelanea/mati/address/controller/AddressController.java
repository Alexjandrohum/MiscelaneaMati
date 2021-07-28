package ms.miscelanea.mati.address.controller;

import ms.miscelanea.mati.address.dto.AddressDto;
import ms.miscelanea.mati.address.service.AddressService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/address", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AddressController {

    @Autowired
    private AddressService service;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> createAddress(@RequestBody AddressDto addressDto) {
        return service.createAddress(addressDto);
    }

    @GetMapping(value = "/getAddress", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<AddressDto>> createAddress() {
        return new ResponseEntity<>(service.getListAddress(), HttpStatus.OK);
    }
}
