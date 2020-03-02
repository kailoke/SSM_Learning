package A5_POJO;

public class Address {
    public String province;
    private String city;

    public Address() {
        System.out.println("abstract constructor");
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", street='" + city + '\'' +
                '}';
    }
}
