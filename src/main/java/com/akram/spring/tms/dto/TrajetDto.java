package com.akram.spring.tms.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrajetDto {
    private Long id;
    private String pointDepart;
    private String pointArrivee;
    private String dateDepart;
    private String dateArrivee;
    private Long conducteurId;
    private Long vehiculeId;
}
