package com.boomi.flow.services.aws.lex.common;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

import java.util.List;

@Type.Element(name = "Response Card")
public class ResponseCard implements Type {
    @Type.Property(name = "Content Type", contentType = ContentType.String)
    private String contentType;

    @Type.Property(name = "Generic Attachments", contentType = ContentType.List)
    private List<GenericAttachment> genericAttachments;

    @Type.Property(name = "Version", contentType = ContentType.String)
    private String version;

    public ResponseCard(String contentType, List<GenericAttachment> genericAttachments, String version) {
        this.contentType = contentType;
        this.genericAttachments = genericAttachments;
        this.version = version;
    }

    public String getContentType() {
        return contentType;
    }

    public List<GenericAttachment> getGenericAttachments() {
        return genericAttachments;
    }

    public String getVersion() {
        return version;
    }
}
