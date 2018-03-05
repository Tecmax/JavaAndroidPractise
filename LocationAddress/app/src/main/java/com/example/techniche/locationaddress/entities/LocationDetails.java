package com.example.techniche.locationaddress.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mahesh on 22-08-2017.
 */

public class LocationDetails {
    @SerializedName("results")
    private List<Address> addresses;
    @SerializedName("status")
    private String status;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public class Address {
        @SerializedName("address_components")
        private List<AddressComponents> addressComponentsList;
        @SerializedName("formatted_address")
        private String formattedAddress;
        @SerializedName("place_id")
        private String placeId;
        @SerializedName("geometry")
        private Geometry geometry;
        @SerializedName("types")
        private List<String> types;
        @SerializedName("partial_match")
        private boolean partialMatch;

        public boolean isPartialMatch() {
            return partialMatch;
        }

        public void setPartialMatch(boolean partialMatch) {
            this.partialMatch = partialMatch;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }

        public String getPlaceId() {
            return placeId;
        }

        public void setPlaceId(String placeId) {
            this.placeId = placeId;
        }

        public List<AddressComponents> getAddressComponentsList() {
            return addressComponentsList;
        }

        public void setAddressComponentsList(List<AddressComponents> addressComponentsList) {
            this.addressComponentsList = addressComponentsList;
        }

        public String getFormattedAddress() {
            return formattedAddress;
        }

        public void setFormattedAddress(String formattedAddress) {
            this.formattedAddress = formattedAddress;
        }

        public Geometry getGeometry() {
            return geometry;
        }

        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }
    }

    public class Geometry {
        @SerializedName("location")
        private AddressLatLong latLong;
        @SerializedName("short_name")
        private String locationType;
        @SerializedName("viewport")
        private ViewPort viewport;
        @SerializedName("bounds")
        private ViewPort bounds;

        public ViewPort getBounds() {
            return bounds;
        }

        public void setBounds(ViewPort bounds) {
            this.bounds = bounds;
        }

        public AddressLatLong getLatLong() {
            return latLong;
        }

        public void setLatLong(AddressLatLong latLong) {
            this.latLong = latLong;
        }

        public String getLocationType() {
            return locationType;
        }

        public void setLocationType(String locationType) {
            this.locationType = locationType;
        }

        public ViewPort getViewport() {
            return viewport;
        }

        public void setViewport(ViewPort viewport) {
            this.viewport = viewport;
        }
    }

    public class AddressComponents {
        @SerializedName("long_name")
        private String longName;
        @SerializedName("short_name")
        private String shortName;
        @SerializedName("status")
        private List<String> types;

        public String getLongName() {
            return longName;
        }

        public void setLongName(String longName) {
            this.longName = longName;
        }

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }
    }

    public class AddressLatLong {
        @SerializedName("lat")
        private String latitude;
        @SerializedName("lng")
        private String longitude;

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }
    }

    public class ViewPort {
        @SerializedName("northeast")
        private AddressLatLong northEast;
        @SerializedName("southwest")
        private AddressLatLong southWest;

        public AddressLatLong getNorthEast() {
            return northEast;
        }

        public void setNorthEast(AddressLatLong northEast) {
            this.northEast = northEast;
        }

        public AddressLatLong getSouthWest() {
            return southWest;
        }

        public void setSouthWest(AddressLatLong southWest) {
            this.southWest = southWest;
        }
    }
}

