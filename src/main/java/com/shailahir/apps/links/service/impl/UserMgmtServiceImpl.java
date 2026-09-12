package com.shailahir.apps.links.service.impl;

import com.shailahir.apps.links.service.UserMgmtService;
import org.springframework.stereotype.Service;

@Service
public class UserMgmtServiceImpl implements UserMgmtService {

    @Override
    public String getCurrentUser() {
        // TODO: POC the third party user systems.
        return "SYSTEM";
    }
}
