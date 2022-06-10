/*
package com.finalProject.Project.config;

import com.finalProject.Project.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SaveContextOnUpdateOrErrorResponseWrapper;
import org.springframework.security.web.context.SecurityContextRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.stream.Stream;

public class CookieSecurityContextRepository implements SecurityContextRepository {
    private static final String EMPTY_CREDENTIALS = "";
    private static final String ANONYMOUS_USER = "anonymousUser";

    private final String cookieHmacKey;

    public CookieSecurityContextRepository(@Value("${auth.cookie.hmac-key}") String cookieHmacKey) {
        this.cookieHmacKey = cookieHmacKey;
    }

    @Override
    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        HttpServletRequest request = requestResponseHolder.getRequest();
        HttpServletResponse response = requestResponseHolder.getResponse();
        requestResponseHolder.setResponse(new SaveToCookieResponseWrapper(request, response));

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        readUserInfoFromCookie(request).ifPresent(userInfo -> {
             context.setAuthentication(new UsernamePasswordAuthenticationToken(userInfo, EMPTY_CREDENTIALS, userInfo.getAuthorities()));
        });

        return context;
    }

    @Override
    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
        SaveToCookieResponseWrapper responseWrapper = (SaveToCookieResponseWrapper) response;
        if (!responseWrapper.isContextSaved()) {
            responseWrapper.saveContext(context);
        }
    }

    @Override
    public boolean containsContext(HttpServletRequest request) {
        return readUserInfoFromCookie(request).isPresent();
    }

    private Optional<User> readUserInfoFromCookie(HttpServletRequest request) {
        return (Optional<User>) readCookieFromRequest(request)
                .map(this::createUserInfo);
    }

    private Optional<Cookie> readCookieFromRequest(HttpServletRequest request) {
        if (request.getCookies() == null) {
            return Optional.empty();
        }

        Optional<Cookie> maybeCookie = Stream.of(request.getCookies())
                .filter(c -> SignedUserInfoCookie.NAME.equals(c.getName()))
                .findFirst();

        return maybeCookie;
    }

    private User createUserInfo(Cookie cookie) {
        return new SignedUserInfoCookie(cookie, cookieHmacKey).getUserInfo();
    }

    private class SaveToCookieResponseWrapper extends SaveContextOnUpdateOrErrorResponseWrapper {
        private final HttpServletRequest request;

        SaveToCookieResponseWrapper(HttpServletRequest request, HttpServletResponse response) {
            super(response, true);
            this.request = request;
        }

        @Override
        protected void saveContext(SecurityContext securityContext) {
            HttpServletResponse response = (HttpServletResponse) getResponse();
            Authentication authentication = securityContext.getAuthentication();

            // some checks, see full sample code

            var userInfo = (User) authentication.getPrincipal();
            SignedUserInfoCookie cookie = new SignedUserInfoCookie(userInfo, cookieHmacKey);
            cookie.setSecure(request.isSecure());
            response.addCookie(cookie);
        }
    }

}

*/
