package ms.miscelanea.mati.address.dto;

import org.springframework.http.HttpStatus;

public class MessageGenericDto extends RuntimeException{

    private HttpStatus codigo;
    private String mensaje;
    private String info;

    public MessageGenericDto(HttpStatus codigo, String mensaje, String info) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.info = info;
    }

    public HttpStatus getCodigo() {
        return codigo;
    }

    public void setCodigo(HttpStatus codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "MessageGenericDto{" +
                "codigo='" + codigo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
