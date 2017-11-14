package com.boomi.flow.services.aws.lex.post;

import com.amazonaws.services.lexruntime.AmazonLexRuntime;
import com.amazonaws.services.lexruntime.model.PostTextRequest;
import com.amazonaws.services.lexruntime.model.PostTextResult;
import com.boomi.flow.services.aws.lex.ApplicationConfiguration;
import com.boomi.flow.services.aws.lex.post.PostTextAction.Input;
import com.boomi.flow.services.aws.lex.post.PostTextAction.Output;
import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.services.actions.ActionCommand;
import com.manywho.sdk.services.actions.ActionResponse;

import javax.inject.Inject;

public class PostTextCommand implements ActionCommand<ApplicationConfiguration, PostTextAction, Input, Output> {
    private final AmazonLexRuntime amazonLexRuntime;

    @Inject
    public PostTextCommand(AmazonLexRuntime amazonLexRuntime) {
        this.amazonLexRuntime = amazonLexRuntime;
    }

    @Override
    public ActionResponse<Output> execute(ApplicationConfiguration configuration, ServiceRequest request, Input input) {
        PostTextResult result = amazonLexRuntime.postText(
                new PostTextRequest()
                        .withInputText(input.getText())
                        .withBotAlias(input.getBotAlias())
                        .withBotName(input.getBotName())
                        .withUserId(request.getStateId().toString())
        );

        Output output = new Output(result.getDialogState(), result.getIntentName(), result.getMessage());

        return new ActionResponse<>(output, InvokeType.Forward);
    }
}
