package ms.miscelanea.mati.address.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Blob;

public class CompanyDto {

    private int idCompany;
    @NotNull(message = "es requerido.")
    private String companyName;

    @NotNull(message = "es requerido.")
    private String contactName;

    @NotNull(message = "es requerido.")
    private String contactTitle;

    @NotNull(message = "es requerido")
    @Pattern(regexp = "/^[0-9]$/", message = "El número de celular debe de ser numérico.")
    private String phone;

    @NotNull(message = "es requerido")
    @Pattern(regexp = "/^[0-9]$/", message = "El identificador de dirección debe de ser numérico.")
    private int idAddress;

    private Blob photo;

    public CompanyDto(int idCompany, String companyName, String contactName, String contactTitle, String phone, int idAddress, Blob photo) {
        this.idCompany = idCompany;
        this.companyName = companyName;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.phone = phone;
        this.idAddress = idAddress;
        this.photo = photo;
    }

    public CompanyDto(String companyName, String contactName, String contactTitle, String phone, int idAddress, Blob photo) {
        this.companyName = companyName;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.phone = phone;
        this.idAddress = idAddress;
        this.photo = photo;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "CompanyDto{" +
                "idCompany=" + idCompany +
                ", companyName='" + companyName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactTitle='" + contactTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", idAddress=" + idAddress +
                ", photo=" + photo +
                '}';
    }
}
