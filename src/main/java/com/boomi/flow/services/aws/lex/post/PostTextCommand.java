package com.boomi.flow.services.aws.lex.post;

import com.amazonaws.services.lexruntime.model.PostTextRequest;
import com.amazonaws.services.lexruntime.model.PostTextResult;
import com.boomi.flow.services.aws.lex.ApplicationConfiguration;
import com.boomi.flow.services.aws.lex.common.GenericAttachment;
import com.boomi.flow.services.aws.lex.common.ResponseCard;
import com.boomi.flow.services.aws.lex.common.SessionAttribute;
import com.boomi.flow.services.aws.lex.common.Slot;
import com.boomi.flow.services.aws.lex.lex.AmazonLexRuntimeFactory;
import com.boomi.flow.services.aws.lex.post.PostTextAction.Input;
import com.boomi.flow.services.aws.lex.post.PostTextAction.Output;
import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.services.actions.ActionCommand;
import com.manywho.sdk.services.actions.ActionResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        // Now we have to map over all the returned response from Lex, and convert to types
        ResponseCard responseCard = Optional.ofNullable(result.getResponseCard())
                .map(PostTextCommand::convertResponseCard)
                .orElse(null);

        List<SessionAttribute> sessionAttributes = Optional.ofNullable(result.getSessionAttributes())
                .map(s -> s.entrySet().stream().map(attribute -> new SessionAttribute(attribute.getKey(), attribute.getValue())))
                .map(s -> s.collect(Collectors.toList()))
                .orElse(new ArrayList<>());

        List<Slot> slots = Optional.ofNullable(result.getSlots())
                .map(s -> s.entrySet().stream().map(slot -> new Slot(slot.getKey(), slot.getValue())))
                .map(s -> s.collect(Collectors.toList()))
                .orElse(new ArrayList<>());

        Output output = new Output(
                result.getDialogState(),
                result.getIntentName(),
                result.getMessage(),
                result.getMessageFormat(),
                responseCard,
                sessionAttributes,
                slots,
                result.getSlotToElicit()
        );

        return new ActionResponse<>(output, InvokeType.Forward);
    }

    private static ResponseCard convertResponseCard(com.amazonaws.services.lexruntime.model.ResponseCard responseCard) {
        List<GenericAttachment> genericAttachments = Optional.ofNullable(responseCard.getGenericAttachments())
                .map(attachments -> attachments.stream().map(attachment -> new GenericAttachment(
                        attachment.getTitle(),
                        attachment.getSubTitle(),
                        attachment.getAttachmentLinkUrl(),
                        attachment.getImageUrl()
                )))
                .map(attachments -> attachments.collect(Collectors.toList()))
                .orElse(new ArrayList<>());

        return new ResponseCard(responseCard.getContentType(), genericAttachments, responseCard.getVersion());
    }
}
