package com.hroniko.pnl.entities.tmf.quote;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Message implements Serializable {


    private final String code; // TODO we need more finals for God of finals
    private final String defaultMessage;
    private final Map<String, String> params;


    //only for json (de)serialization
    @JsonCreator
    public Message(@JsonProperty("code") String code, @JsonProperty(value = "defaultMessage", required = true) String defaultMessage, @JsonProperty("params") Map<String, String> params) {
        this.code = code;
        this.defaultMessage = defaultMessage;
        this.params = params != null ? Collections.unmodifiableMap(new HashMap<>(params)) : null;
    }

    public String getCode() {
        return code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public Map<String, String> getParams() {
        return params;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) {
            return false;
        }
        if (o.getClass() != getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(getCode(), message.getCode()) &&
                Objects.equals(getDefaultMessage(), message.getDefaultMessage()) &&
                Objects.equals(getParams(), message.getParams());
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, defaultMessage, params);
    }

    @Override
    public String toString() {
        return "Message{" +
                "code='" + code + '\'' +
                ", defaultMessage='" + defaultMessage + '\'' +
                ", params=" + params +
                '}';
    }
}
