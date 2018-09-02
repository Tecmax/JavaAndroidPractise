package com.tecmax.henna.entities;

import java.util.List;

/**
 * Created by DELL PC on 05-Jan-18.
 */

public class Profile {
    private String name;
    private int age;
    private List<PhoneNu> phone;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<PhoneNu> getPhone() {
        return phone;
    }

    public void setPhone(List<PhoneNu> phone) {
        this.phone = phone;
    }

    public class PhoneNu {
        private String number;
        private String type;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public class Address {
        private String area;
        private String city;
        private String State;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return State;
        }

        public void setState(String state) {
            State = state;
        }
    }
}
