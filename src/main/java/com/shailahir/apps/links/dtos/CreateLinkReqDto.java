package com.shailahir.apps.links.dtos;

import java.util.List;

public class CreateLinkReqDto {
    private String shortLink;
    private String destination;
    private String description;
    private List<String> tags;

    public CreateLinkReqDto() {
    }

    public CreateLinkReqDto(String shortLink, String destination, String description, List<String> tags) {
        this.shortLink = shortLink;
        this.destination = destination;
        this.description = description;
        this.tags = tags;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
