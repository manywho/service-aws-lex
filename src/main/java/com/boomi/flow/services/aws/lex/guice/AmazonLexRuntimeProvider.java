package com.boomi.flow.services.aws.lex.guice;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lexruntime.AmazonLexRuntime;
import com.amazonaws.services.lexruntime.AmazonLexRuntimeClientBuilder;
import com.google.inject.Provider;

public class AmazonLexRuntimeProvider implements Provider<AmazonLexRuntime> {
    @Override
    public AmazonLexRuntime get() {
        AWSCredentials credentials = new BasicAWSCredentials(
                System.getenv("AWS_ACCESS_KEY"),
                System.getenv("AWS_SECRET_KEY")
        );

        return AmazonLexRuntimeClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }
}
