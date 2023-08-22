package com.metrodata.entities.models;

import lombok.Data;

@Data
public class SpeakerData {

    private String name;
    private String photoUrl;
    private String jobTitle;
    private String company;
    private Long sponsorId;
}
