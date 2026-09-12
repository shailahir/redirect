package com.shailahir.apps.links.dao;

import com.shailahir.apps.links.entity.Link;

public interface LinkMgmtDao {
    Link saveNewLink(Link link);

    Link updateLink(Link link);
}
