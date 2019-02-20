package com.spaghettiteam.hotelapi.dto;

public class RoomDTO {

    private long roomId;
    private double pricePerDay;
    private String photoLink;
    private float rating;

    public RoomDTO() {
    }

    public RoomDTO(long roomId, double pricePerDay, String photoLink, float rating) {
        this.roomId = roomId;
        this.pricePerDay = pricePerDay;
        this.photoLink = photoLink;
        this.rating = rating;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
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


    public static final class RoomDTOBuilder {
        private long roomId;
        private double pricePerDay;
        private String photoLink;
        private float rating;

        private RoomDTOBuilder() {
        }

        public static RoomDTOBuilder aRoomDTO() {
            return new RoomDTOBuilder();
        }

        public RoomDTOBuilder withRoomId(long roomId) {
            this.roomId = roomId;
            return this;
        }

        public RoomDTOBuilder withPricePerDay(double pricePerDay) {
            this.pricePerDay = pricePerDay;
            return this;
        }

        public RoomDTOBuilder withPhotoLink(String photoLink) {
            this.photoLink = photoLink;
            return this;
        }

        public RoomDTOBuilder withRating(float rating) {
            this.rating = rating;
            return this;
        }

        public RoomDTO build() {
            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setRoomId(roomId);
            roomDTO.setPricePerDay(pricePerDay);
            roomDTO.setPhotoLink(photoLink);
            roomDTO.setRating(rating);
            return roomDTO;
        }
    }
}
