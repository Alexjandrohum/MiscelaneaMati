package ms.miscelanea.mati.address.dto;

import org.springframework.http.HttpStatus;

public class ErrorRequest {

    private HttpStatus codeError;
    private String nameError;
    private String descriptionError;
    private String detailError;

    public ErrorRequest() {
    }

    public ErrorRequest(HttpStatus codeError, String nameError, String descriptionError, String detailError) {
        this.codeError = codeError;
        this.nameError = nameError;
        this.descriptionError = descriptionError;
        this.detailError = detailError;
    }

    public HttpStatus getCodeError() {
        return codeError;
    }

    public void setCodeError(HttpStatus codeError) {
        this.codeError = codeError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public String getDetailError() {
        return detailError;
    }

    public void setDetailError(String detailError) {
        this.detailError = detailError;
    }
}
