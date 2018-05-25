package org.mvpigs.proyectoFinalBD.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;

    @Entity
    @Table(name = "PRODUCTS")
    public class Product {
        @Column(name="ID_PRODUCT")
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name="NAME")
        @NotNull
        private String name;

        @Column(name="DESCRIPTION")
        private String description;

        @Column(name="PRICE")
        @NotNull
        private Double price;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }
