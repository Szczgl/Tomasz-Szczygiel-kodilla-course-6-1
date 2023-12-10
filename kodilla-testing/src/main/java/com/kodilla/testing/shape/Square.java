package com.kodilla.testing.shape;

public class Square implements Shape {

    private double said;
    private String name;
    public Square (String name, double said) {
        this.name = name;
        this.said = said;
    }

    public String getShapeName(){
        return name;
    }

    public double getField() {
        return said * said;
    }

    public double getSaid() {
        return said;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Square square)) return false;

        if (Double.compare(getSaid(), square.getSaid()) != 0) return false;
        return getName() != null ? getName().equals(square.getName()) : square.getName() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getSaid());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
