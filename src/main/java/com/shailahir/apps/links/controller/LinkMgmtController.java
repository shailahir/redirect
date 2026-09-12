package com.shailahir.apps.links.controller;

import com.shailahir.apps.links.dtos.CreateLinkReqDto;
import com.shailahir.apps.links.dtos.LinkResDto;
import com.shailahir.apps.links.dtos.PaginatedResDto;
import com.shailahir.apps.links.dtos.UpdateLinkReqDto;
import com.shailahir.apps.links.service.LinkMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/links/mgmt")
public class LinkMgmtController {

    private LinkMgmtService linkMgmtService;

    @PostMapping
    public ResponseEntity<LinkResDto> createLink(@RequestBody CreateLinkReqDto linkReq) {

        LinkResDto res = this.linkMgmtService.createNewLink(linkReq);
        return ResponseEntity.ok().body(res);
    }

    @PutMapping
    public ResponseEntity<LinkResDto> updateLink(@RequestBody UpdateLinkReqDto linkReq) {

        LinkResDto res = this.linkMgmtService.updateLink(linkReq);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping
    public ResponseEntity<PaginatedResDto<LinkResDto>> getAllLinks(
            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "100") int pageSize) {

        PaginatedResDto<LinkResDto> res = this.linkMgmtService.getAllLinks(pageNumber, pageSize);
        return ResponseEntity.ok().body(res);
    }

//    @GetMapping
//    public ResponseEntity<PaginatedResDto<LinkResDto>> getMyLinks(
//            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
//            @RequestParam(value = "pageSize", defaultValue = "100") int pageSize) {
//
//        PaginatedResDto<LinkResDto> res = this.linkMgmtService.getMyLinks(pageNumber, pageSize);
//        return ResponseEntity.ok().body(res);
//    }

    @Autowired
    public void setLinkMgmtService(LinkMgmtService linkMgmtService) {
        this.linkMgmtService = linkMgmtService;
    }
}
