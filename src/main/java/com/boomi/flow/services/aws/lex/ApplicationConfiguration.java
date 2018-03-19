package com.boomi.flow.services.aws.lex;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.configuration.Configuration;

public class ApplicationConfiguration implements Configuration {
    @Configuration.Setting(name = "Region", contentType = ContentType.String)
    private String region;

    @Configuration.Setting(name = "Access Key", contentType = ContentType.String)
    private String accessKey;

    @Configuration.Setting(name = "Secret Key", contentType = ContentType.Password)
    private String secretKey;

    public String getRegion() {
        return region;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
