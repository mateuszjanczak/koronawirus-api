package com.mateuszjanczak.koronawirus.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeathGender {
    private int male;
    private int female;
}
