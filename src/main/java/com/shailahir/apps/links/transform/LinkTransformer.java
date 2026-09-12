package com.shailahir.apps.links.transform;

import com.shailahir.apps.links.constants.LinkMgmtConstants;
import com.shailahir.apps.links.dtos.CreateLinkReqDto;
import com.shailahir.apps.links.dtos.LinkResDto;
import com.shailahir.apps.links.dtos.UpdateLinkReqDto;
import com.shailahir.apps.links.entity.Link;
import com.shailahir.apps.links.entity.builder.LinkBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class LinkTransformer {

    public Link toLink(CreateLinkReqDto req, String currentUser) {
        String shortLink = req.getShortLink();

        return new LinkBuilder()
                .shortLink(shortLink)
                .description(req.getDescription())
                .destination(req.getDestination())
                .createdBy(currentUser)
                .createdDate(LocalDateTime.now())
                .updatedBy(currentUser)
                .updatedDate(LocalDateTime.now())
                .id(UUID.randomUUID().toString())
                .tags(req.getTags())
                .version(LinkMgmtConstants.V1)
                .build();
    }

    public Link toLink(UpdateLinkReqDto req, String currentUser, int newVersion) {
        String shortLink = req.getShortLink();

        return new LinkBuilder()
                .shortLink(shortLink)
                .description(req.getDescription())
                .destination(req.getDestination())
                .updatedBy(currentUser)
                .updatedDate(LocalDateTime.now())
                .id(req.getId())
                .tags(req.getTags())
                .version(newVersion)
                .build();
    }

    public LinkResDto toLinkResDto(Link link) {
        LinkResDto linkResDto = new LinkResDto();
        linkResDto.setId(link.getId());
        linkResDto.setShortLink(link.getShortLink());
        linkResDto.setDescription(link.getDescription());
        linkResDto.setDestination(link.getDestination());
        linkResDto.setCreatedBy(link.getCreatedBy());
        linkResDto.setCreatedDate(link.getCreatedDate());
        linkResDto.setUpdatedBy(link.getUpdatedBy());
        linkResDto.setUpdatedDate(link.getUpdatedDate());
        linkResDto.setVersion(link.getVersion());

        return linkResDto;
    }
}
