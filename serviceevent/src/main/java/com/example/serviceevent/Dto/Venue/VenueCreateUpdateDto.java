package com.example.serviceevent.Dto.Venue;
public class VenueCreateUpdateDto {

    private String name;
    private String address;
    private String city;
    private Integer capacity;
    private boolean indoor;
    private String description;

    public VenueCreateUpdateDto() {
    }

    public VenueCreateUpdateDto(String name, String address, String city,
                                Integer capacity, boolean indoor, String description) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.capacity = capacity;
        this.indoor = indoor;
        this.description = description;
    }

    // ----- Getters & Setters -----

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public boolean isIndoor() {
        return indoor;
    }

    public void setIndoor(boolean indoor) {
        this.indoor = indoor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
