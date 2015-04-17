package com.tony.examples.cxf.provider;

import com.tony.examples.cxf.Constants;
import com.tony.examples.cxf.context.SecurityContext;
import com.tony.examples.cxf.context.UserSession;
import org.apache.commons.lang.time.DateUtils;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.jaxrs.model.OperationResourceInfo;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.message.Message;
import org.springframework.util.StringUtils;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Date;

/**
 * Security Context Filter Provider
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class SecurityContextRequestFilter implements ContainerRequestFilter {

    public static final String SESSION_ID = "sessionid";

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        Message message = JAXRSUtils.getCurrentMessage();
        ClassResourceInfo cri = message.getExchange().get(OperationResourceInfo.class).getClassResourceInfo();

        String sessionId = containerRequestContext.getHeaderString(SESSION_ID);

        UserSession userSession = null;

        if (StringUtils.isEmpty(sessionId)) {
            // 디폴트 유저 세션
            userSession = new UserSession();
            userSession.setSessionId(sessionId);
            userSession.setAuthKey(null);
            userSession.setSno(null);
            userSession.setUserId(null);
            userSession.setCountry("KR");
            userSession.setMarketType(1);
            userSession.setName("Guest");
            userSession.setActive(true);
            userSession.setSecure(true);
            userSession.setCreateTime(new Date());
            userSession.setExpireTime(DateUtils.addMilliseconds(userSession.getCreateTime(), 1000));
            userSession.setRole(Constants.USER_ROLE.GUEST);
        }

        SecurityContext securityContext = new SecurityContext(userSession);
        containerRequestContext.setSecurityContext(securityContext);
        message.put(org.apache.cxf.security.SecurityContext.class, securityContext);
    }
}