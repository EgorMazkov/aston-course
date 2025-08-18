package ru.astoncourse;

public class Park {
    private String parkName;
    private String location;
    private String openingPark;
    private String closingPark;

    public Park(String parkName, String location, String openingPark, String closingPark) {
        this.parkName = parkName;
        this.location = location;
        this.openingPark = openingPark;
        this.closingPark = closingPark;
    }

    public class Attractions {
        private String nameAttraction;
        private String typeAttraction;
        private int priceAttraction;
        private String openingTime;
        private String closingTime;

        public Attractions(String nameAttraction, String typeAttraction, int priceAttraction, String openingTime, String closingTime) {
            this.nameAttraction = nameAttraction;
            this.typeAttraction = typeAttraction;
            this.priceAttraction = priceAttraction;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
        }
    }
}
