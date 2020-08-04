package com.chaolemen.httpdemo.httpdemo.ergediandian;

import com.google.gson.JsonElement;

import java.util.List;

public class ErgeddResponse {


    /**
     * status : 200
     * record : {"upgrade":false,"upgrade_version":0,"upgrade_url":""}
     * messages : {"succeed":["成功"]}
     */

    private int status;
    private JsonElement record;
    private MessagesBean messages;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public JsonElement getRecord() {
        return record;
    }

    public void setRecord(JsonElement record) {
        this.record = record;
    }

    public MessagesBean getMessages() {
        return messages;
    }

    public void setMessages(MessagesBean messages) {
        this.messages = messages;
    }

    public static class MessagesBean {
        private List<String> succeed;

        public List<String> getSucceed() {
            return succeed;
        }

        public void setSucceed(List<String> succeed) {
            this.succeed = succeed;
        }
    }
}
