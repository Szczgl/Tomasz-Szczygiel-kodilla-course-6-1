package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private double height;
    private double base;
    private String name;

    public Triangle(String name, double height, double base) {
        this.height = height;
        this.base = base;
        this.name = name;
    }

    public String getShapeName(){
        return name;
    }

    public double getField() {
        return 0.5 * height * base;
    }

    public double getHeight() {
        return height;
    }

    public double getBase() {
        return base;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Triangle triangle)) return false;

        if (Double.compare(getHeight(), triangle.getHeight()) != 0) return false;
        if (Double.compare(getBase(), triangle.getBase()) != 0) return false;
        return getName().equals(triangle.getName());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getHeight());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getBase());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getName().hashCode();
        return result;
    }
}
