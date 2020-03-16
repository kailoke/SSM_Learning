package A3_RequestParameters;

// 作为User类的内联属性，级联访问时 类修饰符必须=public，otherwise can not access
public class Address {
    private String province;
    private String city;

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
