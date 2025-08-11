package ru.astoncourse;

import lombok.Data;

@Data
public class Product {
    private String nameProduct;
    private String dateOfManufacture;
    private String manufacturer;
    private String countryOfOrigin;
    private int price;
    private boolean theStatusOfTheBookingByTheBuyer;

    public Product(String nameProduct, String dateOfManufacture, String manufacturer, String countryOfOrigin, int price, boolean theStatusOfTheBookingByTheBuyer) {
        this.nameProduct = nameProduct;
        this.dateOfManufacture = dateOfManufacture;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.theStatusOfTheBookingByTheBuyer = theStatusOfTheBookingByTheBuyer;
    }

    @Override
    public String toString() {
        return "Название: " + nameProduct
                + "\nДата производства: " + dateOfManufacture
                + "\nПроизводитель: " + manufacturer
                + "\nСтрана происхождения: " + countryOfOrigin
                + "\nЦена: " + price
                + "\nСостояние бронирования покупателем: " + theStatusOfTheBookingByTheBuyer;
    }
}
