package com.reactnativecommunity.webview.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Event emitted when there is an error in loading.
 */
public class TopMessageEvent extends Event<TopMessageEvent> {

  public static final String EVENT_NAME = "topMessage";
  private WritableMap mEventData;

  public TopMessageEvent(int viewId, WritableMap eventData) {
    super(viewId);
    mEventData = eventData;
  }

  @Override
  public String getEventName() {
    return EVENT_NAME;
  }

  @Override
  public boolean canCoalesce() {
    return false;
  }

  @Override
  public short getCoalescingKey() {
    // All events for a given view can be coalesced.
    return 0;
  }

  @Override
  public void dispatch(RCTEventEmitter rctEventEmitter) {
    rctEventEmitter.receiveEvent(getViewTag(), EVENT_NAME, mEventData);
  }
}
