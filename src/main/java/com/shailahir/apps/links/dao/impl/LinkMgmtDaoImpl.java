package com.shailahir.apps.links.dao.impl;

import com.shailahir.apps.links.dao.AbstractDao;
import com.shailahir.apps.links.dao.LinkMgmtDao;
import com.shailahir.apps.links.entity.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class LinkMgmtDaoImpl extends AbstractDao implements LinkMgmtDao {

    @Autowired
    public LinkMgmtDaoImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public Link saveNewLink(Link link) {
        // TODO: Implement DAO function
        return link;
    }

    @Override
    public Link updateLink(Link link) {
        // TODO: Implement DAO function
        return null;
    }
}
