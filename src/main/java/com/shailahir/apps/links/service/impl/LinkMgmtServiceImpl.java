package com.shailahir.apps.links.service.impl;

import com.shailahir.apps.links.dao.LinkMgmtDao;
import com.shailahir.apps.links.dtos.CreateLinkReqDto;
import com.shailahir.apps.links.dtos.LinkResDto;
import com.shailahir.apps.links.dtos.UpdateLinkReqDto;
import com.shailahir.apps.links.entity.Link;
import com.shailahir.apps.links.exception.LinkUpdateFailedException;
import com.shailahir.apps.links.exception.ShortLinkAlreadyExistException;
import com.shailahir.apps.links.service.LinkMgmtService;
import com.shailahir.apps.links.service.UserMgmtService;
import com.shailahir.apps.links.transform.LinkTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkMgmtServiceImpl implements LinkMgmtService {

    private LinkMgmtDao linkMgmtDao;
    private UserMgmtService userMgmtService;
    private LinkTransformer linkTransformer;

    @Override
    public LinkResDto createNewLink(CreateLinkReqDto linkReq) {

        // TODO: check that the system and user allows to enter this function
        // TODO: check if the input is valid, including checking that the destination is a real URL

        String shortLink = linkReq.getShortLink();
        if (!this.doesShortLinkAlreadyExists(shortLink)) {
            throw new ShortLinkAlreadyExistException(shortLink);
        }

        String currentUser = this.userMgmtService.getCurrentUser();
        Link link = this.linkTransformer.toLink(linkReq, currentUser);
        Link savedLink = this.linkMgmtDao.saveNewLink(link);

        return this.linkTransformer.toLinkResDto(savedLink);
    }

    @Override
    public LinkResDto updateLink(UpdateLinkReqDto linkReq) {
        // TODO: check that the system and user allows to enter this function
        // TODO: check if the input is valid, including checking that the destination is a real URL

        String shortLink = linkReq.getShortLink();
        if (!this.doesShortLinkAlreadyExists(shortLink)) {
            throw new LinkUpdateFailedException("The short link " + shortLink + " does not exist");
        }

        String currentUser = this.userMgmtService.getCurrentUser();
        int newVersion = this.getNextAvailableVersion(shortLink);

        Link link = this.linkTransformer.toLink(linkReq, currentUser, newVersion);
        Link savedLink = this.linkMgmtDao.updateLink(link);

        return this.linkTransformer.toLinkResDto(savedLink);
    }

    private int getNextAvailableVersion(String shortLink) {
        // TODO: Implement
        return 2;
    }

    @Override
    public boolean doesShortLinkAlreadyExists(String shortLink) {
        // DB Magic
        return false;
    }

    @Autowired
    public void setLinkMgmtDao(LinkMgmtDao linkMgmtDao) {
        this.linkMgmtDao = linkMgmtDao;
    }

    @Autowired
    public void setUserMgmtService(UserMgmtService userMgmtService) {
        this.userMgmtService = userMgmtService;
    }

    @Autowired
    public void setLinkTransformer(LinkTransformer linkTransformer) {
        this.linkTransformer = linkTransformer;
    }
}
