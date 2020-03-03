package com.company.exercise4.part2;

public class Candy implements Sweets{
        String name;
        int price;
        int weight;

        String additionalInformation;

        public Candy(String name, int price, int weight, String additionalInformation){
            this.name = name;
            this.price = price;
            this.weight =  weight;
            this.additionalInformation = additionalInformation;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getAdditionalInformation() {
            return additionalInformation;
        }

        public void setAdditionalInformation(String additionalInformation) {
            this.additionalInformation = additionalInformation;
        }
    }

