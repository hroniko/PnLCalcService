package com.hroniko.pnl.entities.tmf;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface Listener {
    String getId();
    void setId(String iId);

    String getCallback();
    void setCallback(String callback);

    String getQuery();
    void setQuery(String query);
}
