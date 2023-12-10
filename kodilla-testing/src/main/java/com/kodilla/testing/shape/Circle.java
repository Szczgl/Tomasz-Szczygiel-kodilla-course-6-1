package com.kodilla.testing.shape;

public class Circle implements Shape {

    private double radius;
    private String name;
    private final static double PI = 3.14;

    public Circle(String name, double radius) {
        this.radius = radius;
        this.name = name;
    }

    public String getShapeName(){
        return name;
    }

    public double getField() {
        return radius * radius * PI;
    }

    public double getRadius() {
        return radius;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Circle circle)) return false;

        if (Double.compare(getRadius(), circle.getRadius()) != 0) return false;
        return getName() != null ? getName().equals(circle.getName()) : circle.getName() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getRadius());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
