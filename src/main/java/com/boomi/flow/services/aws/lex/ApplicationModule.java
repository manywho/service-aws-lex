package com.boomi.flow.services.aws.lex;

import com.amazonaws.services.lexruntime.AmazonLexRuntime;
import com.boomi.flow.services.aws.lex.guice.AmazonLexRuntimeProvider;
import com.google.inject.AbstractModule;

public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AmazonLexRuntime.class).toProvider(AmazonLexRuntimeProvider.class);
    }
}