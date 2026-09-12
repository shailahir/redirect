package com.shailahir.apps.links.entity.builder;

import com.shailahir.apps.links.entity.Link;

import java.time.LocalDateTime;
import java.util.List;

public class LinkBuilder {
    private String id;
    private String shortLink;
    private String destination;
    private String description;
    private List<String> tags;

    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime updatedDate;

    private int version;

    public LinkBuilder id(String id) {
        this.id = id;
        return this;
    }

    public LinkBuilder shortLink(String shortLink) {
        this.shortLink = shortLink;
        return this;
    }

    public LinkBuilder destination(String destination) {
        this.destination = destination;
        return this;
    }

    public LinkBuilder description(String description) {
        this.description = description;
        return this;
    }

    public LinkBuilder tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public LinkBuilder createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public LinkBuilder createdDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public LinkBuilder updatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public LinkBuilder updatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public LinkBuilder version(int version) {
        this.version = version;
        return this;
    }

    public Link build() {
        Link link = new Link();
        link.setId(this.id);
        link.setShortLink(this.shortLink);
        link.setDestination(this.destination);
        link.setDescription(this.description);
        link.setTags(this.tags);
        link.setCreatedBy(this.createdBy);
        link.setCreatedDate(this.createdDate);
        link.setUpdatedBy(this.updatedBy);
        link.setUpdatedDate(this.updatedDate);
        link.setVersion(this.version);
        return link;
    }
}
