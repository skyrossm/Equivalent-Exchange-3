package com.pahimar.ee3.api;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.pahimar.ee3.emc.EmcValue;
import com.pahimar.ee3.item.WrappedStack;

public class StackValueMapping {

    private static Gson gsonSerializer = new Gson();
    
    public final WrappedStack wrappedStack;
    public final EmcValue emcValue;
    
    public StackValueMapping(Object object, EmcValue emcValue) {
        this.wrappedStack = new WrappedStack(object);
        this.emcValue = emcValue;
    }
    
    public static StackValueMapping createFromJson(String jsonStackValueMapping) {
        
        try {
            return (StackValueMapping) gsonSerializer.fromJson(jsonStackValueMapping, StackValueMapping.class);
        }
        catch (JsonSyntaxException exception) {
            // TODO Log something regarding the failed parse
        }

        return null;
    }
    
    public String toJson() {
        return gsonSerializer.toJson(this);
    }
}
