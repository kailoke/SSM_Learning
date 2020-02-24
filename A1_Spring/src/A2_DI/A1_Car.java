package A2_DI;

public class A1_Car {
    private String brand;
    private String corp;
    private Double price;

    public A1_Car() {
        System.out.println("Constructor()... invoked");
    }

    public A1_Car(String brand, String corp, Double price) {
        System.out.println("Constructor(s,s,d)... invoked");
        this.brand = brand;
        this.corp = corp;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("serBrand(): " + brand);
        this.brand = brand;
    }

    public String getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        System.out.println("serCorp(): " + corp);
        this.corp = corp;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        System.out.println("serPrice(): " + price);
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", corp='" + corp + '\'' +
                ", price=" + price +
                '}';
    }
}
