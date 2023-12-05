package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ContentModel {
    @Id
    private int seq;
    private String title;
    private String content;
}