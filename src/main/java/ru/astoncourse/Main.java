package ru.astoncourse;

public class Main {
    public static void main(String[] args) {
       Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Apple iPhone 15", "15.09.2023",
                "Apple Inc.", "USA", 9999, true);
        productsArray[2] = new Product("Dell XPS 13", "10.11.2022",
                "Dell Technologies", "USA", 1200, false);
        productsArray[3] = new Product("Sony WH-1000XM5", "20.05.2024",
                "Sony Corporation", "Japan", 350, true);
        productsArray[4] = new Product("Samsung Galaxy Tab S8", "05.03.2023",
                "Samsung Electronics", "Korea", 850, true);

    }
}