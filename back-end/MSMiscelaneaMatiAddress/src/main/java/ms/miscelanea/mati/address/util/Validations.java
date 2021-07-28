/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.miscelanea.mati.address.util;

import ms.miscelanea.mati.address.dto.AddressDto;
import ms.miscelanea.mati.address.dto.MessageGenericDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author alexjandrohum
 */
public class Validations {

    public static void getValidationAddress(AddressDto addressDto) {
        System.out.println("Entrando a validaciones: city: "+addressDto.getCity());
        if (addressDto.getNameAddress().equals("")) {
            throw new MessageGenericDto(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(), "El nombre es requerido");
        } else if (addressDto.getNumberInside().equals("")) {
            throw new MessageGenericDto(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(), "El numero interior es requerido");
        } else if (addressDto.getCity().equals("")) {
            throw new MessageGenericDto(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(), "La ciudad es requerida");
        } else if (addressDto.getPostalCode() == 0) {
            throw new MessageGenericDto(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(), "El código postal es requerido");
        } else if (addressDto.getRegion().equals("")) {
            throw new MessageGenericDto(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(), "La región es requerida");
        } else if (addressDto.getPhone().equals("")) {
            throw new MessageGenericDto(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.name(), "El teléfono es requerido");
        }

    }

}
