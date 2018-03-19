package com.boomi.flow.services.aws.lex.common;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

@Type.Element(name = "Slot", summary = "A map of key-value intent slots that Amazon Lex detected from the user input in a conversation")
public class Slot implements Type {
    @Property(name = "Key", contentType = ContentType.String)
    private String key;

    @Property(name = "Value", contentType = ContentType.String)
    private String value;

    public Slot(String key, String value) {
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
