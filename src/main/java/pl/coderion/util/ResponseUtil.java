package pl.coderion.util;

import com.audatex.b2b.serviceinterface_v1.B2BMessage;
import com.audatex.b2b.serviceinterface_v1.B2BResponse;
import pl.coderion.model.BaseResponse;
import pl.coderion.model.BaseResponseMessage;

import java.util.ArrayList;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class ResponseUtil {

    public static BaseResponse parseMessages(BaseResponse baseResponse, B2BResponse b2BResponse) {
        baseResponse.setHostName(b2BResponse.getHostName());
        baseResponse.setReturnCode(b2BResponse.getReturnCode());
        baseResponse.setTimestamp(b2BResponse.getTimestamp().toGregorianCalendar().getTime());

        for (B2BMessage message : b2BResponse.getMessage()) {
            BaseResponseMessage baseResponseMessage = new BaseResponseMessage();
            baseResponseMessage.setAdditionalInfo(new ArrayList<String>());
            baseResponseMessage.setMessageCode(message.getMessageCode());
            baseResponseMessage.setSeverity(message.getSeverity());
            baseResponseMessage.setText(message.getText());
            baseResponseMessage.setLocalizedText(message.getLocalizedText());

            for (String additionalInfo : message.getAdditionalInfo()) {
                baseResponseMessage.getAdditionalInfo().add(additionalInfo);
            }

            baseResponse.getMessages().add(baseResponseMessage);
        }

        return baseResponse;
    }
}
