package com.boomi.flow.services.aws.lex.post;

import com.amazonaws.services.lexruntime.model.PostTextRequest;
import com.amazonaws.services.lexruntime.model.PostTextResult;
import com.boomi.flow.services.aws.lex.ApplicationConfiguration;
import com.boomi.flow.services.aws.lex.lex.AmazonLexRuntimeFactory;
import com.boomi.flow.services.aws.lex.post.PostTextAction.Input;
import com.boomi.flow.services.aws.lex.post.PostTextAction.Output;
import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.services.actions.ActionCommand;
import com.manywho.sdk.services.actions.ActionResponse;

public class PostTextCommand implements ActionCommand<ApplicationConfiguration, PostTextAction, Input, Output> {
    @Override
    public ActionResponse<Output> execute(ApplicationConfiguration configuration, ServiceRequest request, Input input) {
        PostTextResult result = AmazonLexRuntimeFactory.create(configuration).postText(
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
