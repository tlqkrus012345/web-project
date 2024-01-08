package com.server.search.external;

public interface ExternalInterface {
    String search (String query, String sort);
    void setNextExternal(ExternalInterface externalInterface);
}
