package com.boomi.flow.services.aws.lex.post;

import com.boomi.flow.services.aws.lex.common.ResponseCard;
import com.boomi.flow.services.aws.lex.common.SessionAttribute;
import com.boomi.flow.services.aws.lex.common.Slot;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.actions.Action;

import java.util.List;

@Action.Metadata(name = "Post Text", summary = "Send text to Amazon Lex, for it to interpret using the machine learning model built for a bot", uri = "post/text")
public class PostTextAction implements Action {
    public static class Input {
        @Action.Input(name = "Bot Alias", contentType = ContentType.String)
        private String botAlias;

        @Action.Input(name = "Bot Name", contentType = ContentType.String)
        private String botName;

        @Action.Input(name = "Text", contentType = ContentType.String)
        private String text;

        public String getBotAlias() {
            return botAlias;
        }

        public String getBotName() {
            return botName;
        }

        public String getText() {
            return text;
        }
    }

    public static class Output {
        @Action.Output(name = "Dialog State", contentType = ContentType.String)
        private String dialogState;

        @Action.Output(name = "Intent Name", contentType = ContentType.String)
        private String intentName;

        @Action.Output(name = "Message", contentType = ContentType.String)
        private String message;

        @Action.Output(name = "Message Format", contentType = ContentType.String)
        private String messageFormat;

        @Action.Output(name = "Response Card", contentType = ContentType.Object)
        private ResponseCard responseCard;

        @Action.Output(name = "Session Attributes", contentType = ContentType.List)
        private List<SessionAttribute> sessionAttributes;

        @Action.Output(name = "Slots", contentType = ContentType.List)
        private List<Slot> slots;

        @Action.Output(name = "Slot to Elicit", contentType = ContentType.String)
        private String slotToElicit;

        public Output(String dialogState, String intentName, String message, String messageFormat, ResponseCard responseCard, List<SessionAttribute> sessionAttributes, List<Slot> slots, String slotToElicit) {
            this.dialogState = dialogState;
            this.intentName = intentName;
            this.message = message;
            this.messageFormat = messageFormat;
            this.responseCard = responseCard;
            this.sessionAttributes = sessionAttributes;
            this.slots = slots;
            this.slotToElicit = slotToElicit;
        }

        public String getDialogState() {
            return dialogState;
        }

        public String getIntentName() {
            return intentName;
        }

        public String getMessage() {
            return message;
        }

        public String getMessageFormat() {
            return messageFormat;
        }

        public ResponseCard getResponseCard() {
            return responseCard;
        }

        public List<SessionAttribute> getSessionAttributes() {
            return sessionAttributes;
        }

        public List<Slot> getSlots() {
            return slots;
        }

        public String getSlotToElicit() {
            return slotToElicit;
        }
    }
}
