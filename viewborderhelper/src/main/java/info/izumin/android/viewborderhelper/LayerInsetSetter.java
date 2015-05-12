package info.izumin.android.viewborderhelper;

import android.graphics.drawable.LayerDrawable;

/**
 * Created by izumin on 15/05/13.
 */
public enum LayerInsetSetter {
    ALL(false, false, false, false),
    LEFT(false, true, true, true),
    TOP(true, false, true, true),
    RIGHT(true, true, false, true),
    BOTTOM(true, true, true, false);

    private final boolean l, t, r, b;

    private LayerInsetSetter(boolean l, boolean t, boolean r, boolean b) {
        this.l = l;
        this.t = t;
        this.r = r;
        this.b = b;
    }

    public LayerDrawable set(int index, int borderWidth, LayerDrawable layers) {
        layers.setLayerInset(
                index,
                (l ? -borderWidth : 0),
                (t ? -borderWidth : 0),
                (r ? -borderWidth : 0),
                (b ? -borderWidth : 0)
        );
        return layers;
    }
}
