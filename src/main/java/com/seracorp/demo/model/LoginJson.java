
package com.seracorp.demo.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apikey",
    "userkey",
    "username"
})
public class LoginJson {

    @JsonProperty("apikey")
    private String apikey;
    @JsonProperty("userkey")
    private String userkey;
    @JsonProperty("username")
    private String username;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("apikey")
    public String getApikey() {
        return apikey;
    }

    @JsonProperty("apikey")
    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public LoginJson withApikey(String apikey) {
        this.apikey = apikey;
        return this;
    }

    @JsonProperty("userkey")
    public String getUserkey() {
        return userkey;
    }

    @JsonProperty("userkey")
    public void setUserkey(String userkey) {
        this.userkey = userkey;
    }

    public LoginJson withUserkey(String userkey) {
        this.userkey = userkey;
        return this;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    public LoginJson withUsername(String username) {
        this.username = username;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public LoginJson withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("apikey", apikey).append("userkey", userkey).append("username", username).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(apikey).append(userkey).append(username).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LoginJson) == false) {
            return false;
        }
        LoginJson rhs = ((LoginJson) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(apikey, rhs.apikey).append(userkey, rhs.userkey).append(username, rhs.username).isEquals();
    }

}
