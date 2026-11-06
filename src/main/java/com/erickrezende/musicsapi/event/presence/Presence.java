package com.erickrezende.musicsapi.event.presence;

import org.bson.types.ObjectId;

import lombok.Data;

@Data 
public class Presence {

    private ObjectId user;
    private boolean present;

    public Presence(ObjectId user, boolean present) {
        this.user = user;
        this.present = present;
    }

    public Presence(String userId, boolean present) {
        this.user = new ObjectId(userId);
        this.present = present;
    }    

    @Deprecated 
    public Presence() {}
}
