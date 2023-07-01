package SomethingElse;

import java.util.Date;

public class Car {
    String model;
    String mark;
    Date productionAt;
    int enginePower;

    public Car(String model, String mark, Date productionAt, int enginePower) {
        this.model = model;
        this.mark = mark;
        this.productionAt = productionAt;
        this.enginePower = enginePower;
    }
    @Override
    public String toString() {
        return "SomethingElse.Car model '" + model + '\'' +
                ", mark '" + mark + '\'' +
                ", production at " + productionAt +
                ", enginePower is " + enginePower;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Date getProductionAt() {
        return productionAt;
    }

    public void setProductionAt(Date productionAt) {
        this.productionAt = productionAt;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }
}
