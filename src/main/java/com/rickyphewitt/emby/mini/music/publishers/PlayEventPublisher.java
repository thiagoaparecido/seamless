package com.rickyphewitt.emby.mini.music.publishers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.rickyphewitt.emby.api.data.SongSet;
import com.rickyphewitt.emby.mini.music.events.SetPlayQueueEvent;

@Component
public class PlayEventPublisher {

	@Autowired
    private ApplicationEventPublisher applicationEventPublisher;
 
    public void setQueue(SongSet songs) {
        SetPlayQueueEvent setQueueEvent = new SetPlayQueueEvent(this, songs);
        applicationEventPublisher.publishEvent(setQueueEvent);
    }

}
