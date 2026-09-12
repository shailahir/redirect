package com.shailahir.apps.links.service;

import com.shailahir.apps.links.dtos.CreateLinkReqDto;
import com.shailahir.apps.links.dtos.LinkResDto;
import com.shailahir.apps.links.dtos.UpdateLinkReqDto;

public interface LinkMgmtService {

    LinkResDto createNewLink(CreateLinkReqDto linkReq);

    boolean doesShortLinkAlreadyExists(String shortLink);

    LinkResDto updateLink(UpdateLinkReqDto linkReq);
}
