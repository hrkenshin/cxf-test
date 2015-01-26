package com.tony.examples.cxf.context;

import com.tony.examples.cxf.Constants;

import java.io.Serializable;
import java.security.Principal;
import java.util.Date;

/**
 * 로그인 사용자 세션 정보 클래스
 *
 * @author 이승백
 */
public class UserSession implements Serializable, Principal {

    private static final long serialVersionUID = 7643286864979350209L;

    private String sessionId;
    private String authKey;
    private String sno;
    private String userId;
    private String name;
    private String country;
    private int marketType;

    private boolean active;
    private boolean secure;

    private Date createTime;
    private Date expireTime;

    private Constants.USER_ROLE role;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getMarketType() {
        return marketType;
    }

    public void setMarketType(int marketType) {
        this.marketType = marketType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Constants.USER_ROLE getRole() {
        return role;
    }

    public void setRole(Constants.USER_ROLE role) {
        this.role = role;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserSession{");
        sb.append("sessionId='").append(sessionId).append('\'');
        sb.append(", authKey='").append(authKey).append('\'');
        sb.append(", sno='").append(sno).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", marketType=").append(marketType);
        sb.append(", active=").append(active);
        sb.append(", secure=").append(secure);
        sb.append(", createTime=").append(createTime);
        sb.append(", expireTime=").append(expireTime);
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}