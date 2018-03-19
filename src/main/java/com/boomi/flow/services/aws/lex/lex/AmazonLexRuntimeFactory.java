package com.boomi.flow.services.aws.lex.lex;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lexruntime.AmazonLexRuntime;
import com.amazonaws.services.lexruntime.AmazonLexRuntimeClientBuilder;
import com.boomi.flow.services.aws.lex.ApplicationConfiguration;

public class AmazonLexRuntimeFactory {
    public static AmazonLexRuntime create(ApplicationConfiguration configuration) {
        AWSCredentials credentials = new BasicAWSCredentials(
                configuration.getAccessKey(),
                configuration.getSecretKey()
        );

        return AmazonLexRuntimeClientBuilder.standard()
                .withRegion(Regions.fromName(configuration.getRegion()))
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }
}
