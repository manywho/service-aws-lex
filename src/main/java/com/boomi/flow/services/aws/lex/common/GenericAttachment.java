package com.boomi.flow.services.aws.lex.common;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

@Type.Element(name = "Generic Attachment")
public class GenericAttachment implements Type {
    @Type.Property(name = "Title", contentType = ContentType.String, bound = false)
    private String title;

    @Type.Property(name = "Subtitle", contentType = ContentType.String, bound = false)
    private String subtitle;

    @Type.Property(name = "Attachment Link URL", contentType = ContentType.String, bound = false)
    private String attachmentLinkUrl;

    @Type.Property(name = "Image URL", contentType = ContentType.String, bound = false)
    private String imageUrl;

    public GenericAttachment(String title, String subtitle, String attachmentLinkUrl, String imageUrl) {
        this.title = title;
        this.subtitle = subtitle;
        this.attachmentLinkUrl = attachmentLinkUrl;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getAttachmentLinkUrl() {
        return attachmentLinkUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
