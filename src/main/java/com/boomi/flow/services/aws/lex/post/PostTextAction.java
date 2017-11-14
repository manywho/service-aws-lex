package com.boomi.flow.services.aws.lex.post;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.actions.Action;

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

        public Output(String dialogState, String intentName, String message) {
            this.dialogState = dialogState;
            this.intentName = intentName;
            this.message = message;
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
    }
}
