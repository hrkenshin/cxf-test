package com.tony.examples.cxf.context;

import com.tony.examples.cxf.Constants;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.security.Principal;

/**
 * Custom Security Context
 *
 * @author 이승백
 */
public class SecurityContext implements javax.ws.rs.core.SecurityContext, org.apache.cxf.security.SecurityContext {

    private final UserSession userSession;

    public SecurityContext(UserSession userSession) {
        this.userSession = userSession;
    }

    @Override
    public Principal getUserPrincipal() {
        return this.userSession;
    }

    @Override
    public boolean isUserInRole(String role) {
        if (userSession == null || !userSession.isActive()) {
            return false;
        }

        return userSession.getRole().getValue() >= Constants.USER_ROLE.valueOf(role).getValue();
    }

    @Override
    public boolean isSecure() {
        return this.userSession != null && this.userSession.isSecure();
    }

    @Override
    public String getAuthenticationScheme() {
        return SecurityContext.CLIENT_CERT_AUTH;
    }
}
