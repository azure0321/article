package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AnswerModel {
    @Id
    private int seq;
    private String content;
}
