package com.tonybaloney.engine.gfx;

import com.tonybaloney.engine.gfx.Image;

public class ImageRequest {
    public Image image;
    public int zDepth;
    public int offX, offY;

    public ImageRequest(Image image, int zDepth, int offX, int offY) {
        this.image = image;
        this.offX = offX;
        this.offY = offY;
        this.zDepth = zDepth;
    }
}
