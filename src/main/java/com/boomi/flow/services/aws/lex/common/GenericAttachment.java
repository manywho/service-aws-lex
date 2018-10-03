package com.boomi.flow.services.aws.lex.common;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

import java.util.List;

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

    @Type.Property(name = "Buttons", contentType = ContentType.List, bound = false)
    private List<Button> buttons;

    public GenericAttachment(String title, String subtitle, String attachmentLinkUrl, String imageUrl, List<Button> buttons) {
        this.title = title;
        this.subtitle = subtitle;
        this.attachmentLinkUrl = attachmentLinkUrl;
        this.imageUrl = imageUrl;
        this.buttons = buttons;
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

    public List<Button> getButtons() {
        return buttons;
    }
}
