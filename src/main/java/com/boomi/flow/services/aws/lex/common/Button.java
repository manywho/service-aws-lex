package com.boomi.flow.services.aws.lex.common;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

@Type.Element(name = "Button")
public class Button implements Type {
    @Type.Property(name = "Text", contentType = ContentType.String, bound = false)
    private String text;

    @Type.Property(name = "Value", contentType = ContentType.String, bound = false)
    private String value;

    public Button(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}
