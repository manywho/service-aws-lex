package com.boomi.flow.services.aws.lex.common;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

@Type.Element(name = "Session Attribute", summary = "A map of key-value pairs from Amazon Lex that represents session-specific context information")
public class SessionAttribute implements Type {
    @Type.Property(name = "Key", contentType = ContentType.String, bound = false)
    private String key;

    @Type.Property(name = "Value", contentType = ContentType.String, bound = false)
    private String value;

    public SessionAttribute(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
