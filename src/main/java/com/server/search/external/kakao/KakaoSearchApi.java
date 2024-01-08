package com.server.search.external.kakao;

import com.server.search.external.ExternalInterface;

public class KakaoSearchApi implements ExternalInterface {
    private ExternalInterface nextExternal;
    @Override
    public String search(String query, String sort) {
        return null;
    }

    @Override
    public void setNextExternal(ExternalInterface externalInterface) {
        nextExternal = externalInterface;
    }
}
