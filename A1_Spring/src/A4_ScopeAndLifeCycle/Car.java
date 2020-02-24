package A4_ScopeAndLifeCycle;

import javax.sound.midi.Soundbank;

/**
 * Bean作用域 及 生命周期 测试类
 */

public class Car {
    private String brand;
    private Double price;

    public Car() {
        System.out.println("default Constructor invoked");
    }

    // <init-method 属性进行方法指定
    public void init(){
        System.out.println("init-method invoked");
    }

    // IOC容器关闭，销毁所有Bean
    public void destroy() {
        System.out.println("destroy-method invoked");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
        System.out.println("setMethod invoked");
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
