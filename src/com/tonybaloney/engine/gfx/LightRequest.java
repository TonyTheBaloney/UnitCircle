package com.tonybaloney.engine.gfx;

import com.tonybaloney.engine.gfx.Light;

public class LightRequest {

    public Light light;
    public int locX, locY;

    public LightRequest(Light light, int locX, int locY) {
        this.light = light;
        this.locX = locX;
        this.locY = locY;
    }
}
