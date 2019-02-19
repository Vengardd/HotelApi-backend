package com.spaghettiteam.hotelapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String roomNumber;
    private double pricePerDay;
    private int capacity;
    private boolean petFriendly;
    private String description;
    private String photoLink;
    private float rating;

    public Room() {
    }

    public Room(String roomNumber, double pricePerDay, int capacity, boolean petFriendly, String description, String photoLink, float rating) {
        this.roomNumber = roomNumber;
        this.pricePerDay = pricePerDay;
        this.capacity = capacity;
        this.petFriendly = petFriendly;
        this.description = description;
        this.photoLink = photoLink;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public static final class RoomBuilder {
        private long id;
        private String roomNumber;
        private double pricePerDay;
        private int capacity;
        private boolean petFriendly;
        private String description;
        private String photoLink;
        private float rating;

        private RoomBuilder() {
        }

        public static RoomBuilder aRoom() {
            return new RoomBuilder();
        }

        public RoomBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public RoomBuilder withRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public RoomBuilder withPricePerDay(double pricePerDay) {
            this.pricePerDay = pricePerDay;
            return this;
        }

        public RoomBuilder withCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public RoomBuilder withPetFriendly(boolean petFriendly) {
            this.petFriendly = petFriendly;
            return this;
        }

        public RoomBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public RoomBuilder withPhotoLink(String photoLink) {
            this.photoLink = photoLink;
            return this;
        }

        public RoomBuilder withRating(float rating) {
            this.rating = rating;
            return this;
        }

        public Room build() {
            Room room = new Room();
            room.setId(id);
            room.setRoomNumber(roomNumber);
            room.setPricePerDay(pricePerDay);
            room.setCapacity(capacity);
            room.setPetFriendly(petFriendly);
            room.setDescription(description);
            room.setPhotoLink(photoLink);
            room.setRating(rating);
            return room;
        }
    }
}
