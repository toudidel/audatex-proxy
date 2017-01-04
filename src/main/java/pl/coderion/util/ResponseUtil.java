package pl.coderion.util;

import com.audatex.b2b.serviceinterface_v1.B2BMessage;
import pl.coderion.model.BaseResponse;
import pl.coderion.model.BaseResponseMessage;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class ResponseUtil {

    public static BaseResponse parseMessages(BaseResponse response, Collection<B2BMessage> messages) {
        for (B2BMessage message : messages) {
            BaseResponseMessage baseResponseMessage = new BaseResponseMessage();
            baseResponseMessage.setAdditionalInfo(new ArrayList<String>());
            baseResponseMessage.setMessageCode(message.getMessageCode());
            baseResponseMessage.setSeverity(message.getSeverity());
            baseResponseMessage.setText(message.getText());

            for (String additionalInfo : message.getAdditionalInfo()) {
                baseResponseMessage.getAdditionalInfo().add(additionalInfo);
            }

            response.getMessages().add(baseResponseMessage);
        }

        return response;
    }
}
