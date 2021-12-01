package com.training.spring.order.models;


public class SendMessageEvent {

    private String destination;
    private String message;
    private int    type;

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(final String destinationParam) {
        this.destination = destinationParam;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String messageParam) {
        this.message = messageParam;
    }

    public int getType() {
        return this.type;
    }

    public void setType(final int typeParam) {
        this.type = typeParam;
    }

    @Override
    public String toString() {
        return "SendMessageEvent [destination="
               + this.destination
               + ", message="
               + this.message
               + ", type="
               + this.type
               + "]";
    }


}
