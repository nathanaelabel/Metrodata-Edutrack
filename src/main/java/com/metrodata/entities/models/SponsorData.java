package com.metrodata.entities.models;

import com.metrodata.entities.enums.SponsorCategory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class SponsorData {

    private String name;
    private String logoUrl;

    @Enumerated(EnumType.STRING)
    private SponsorCategory sponsorCategory;
    private Long eventId;
}
