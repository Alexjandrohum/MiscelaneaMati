package ms.miscelanea.mati.address.dto;

public class AddressDto {

    private Integer idAddress;
    private String nameAddress;
    private String numberInside;
    private String numberOutside;
    private String city;
    private String region;
    private int postalCode;
    private String fax;
    private String phone;

    public AddressDto() {
    }

    public AddressDto(Integer idAddress, String nameAddress, String numberInside, String numberOutside, String city, String region, int postalCode, String fax, String phone) {
        this.idAddress = idAddress;
        this.nameAddress = nameAddress;
        this.numberInside = numberInside;
        this.numberOutside = numberOutside;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.fax = fax;
        this.phone = phone;
    }

    public AddressDto(String nameAddress, String numberInside, String numberOutside, String city, String region, int postalCode, String fax, String phone) {
        this.nameAddress = nameAddress;
        this.numberInside = numberInside;
        this.numberOutside = numberOutside;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.fax = fax;
        this.phone = phone;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public String getNameAddress() {
        return nameAddress;
    }

    public void setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
    }

    public String getNumberInside() {
        return numberInside;
    }

    public void setNumberInside(String numberInside) {
        this.numberInside = numberInside;
    }

    public String getNumberOutside() {
        return numberOutside;
    }

    public void setNumberOutside(String numberOutside) {
        this.numberOutside = numberOutside;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "idAddress=" + idAddress +
                ", nameAddress='" + nameAddress + '\'' +
                ", numberInside='" + numberInside + '\'' +
                ", numberOutside='" + numberOutside + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", postalCode=" + postalCode +
                ", fax='" + fax + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
