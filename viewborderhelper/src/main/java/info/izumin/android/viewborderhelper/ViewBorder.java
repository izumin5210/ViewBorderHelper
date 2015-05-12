package info.izumin.android.viewborderhelper;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/**
 * Created by izumin on 15/05/13.
 */
public enum ViewBorder {
    ALL(
            R.styleable.ViewBorderHelper_border_color,
            R.styleable.ViewBorderHelper_border_width,
            R.styleable.ViewBorderHelper_border_dash_width,
            R.styleable.ViewBorderHelper_border_dash_gap
    ),
    LEFT(
            R.styleable.ViewBorderHelper_border_left_color,
            R.styleable.ViewBorderHelper_border_left_width,
            R.styleable.ViewBorderHelper_border_left_dash_width,
            R.styleable.ViewBorderHelper_border_left_dash_gap
    ),
    TOP(
            R.styleable.ViewBorderHelper_border_top_color,
            R.styleable.ViewBorderHelper_border_top_width,
            R.styleable.ViewBorderHelper_border_top_dash_width,
            R.styleable.ViewBorderHelper_border_top_dash_gap
    ),
    RIGHT(
            R.styleable.ViewBorderHelper_border_right_color,
            R.styleable.ViewBorderHelper_border_right_width,
            R.styleable.ViewBorderHelper_border_right_dash_width,
            R.styleable.ViewBorderHelper_border_right_dash_gap
    ),
    BOTTOM(
            R.styleable.ViewBorderHelper_border_bottom_color,
            R.styleable.ViewBorderHelper_border_bottom_width,
            R.styleable.ViewBorderHelper_border_bottom_dash_width,
            R.styleable.ViewBorderHelper_border_bottom_dash_gap
    );

    private static final int DEFAULT_COLOR = 0x00000000;
    private static final int DEFAULT_WIDTH = 0;
    private static final int DEFAULT_DASH_WIDTH = 0;
    private static final int DEFAULT_DASH_GAP = 0;

    private int colorId;
    private int widthId;
    private int dashWidthId;
    private int dashGapId;

    private ViewBorder(final int colorId, final int widthId, final int dashWidthId, final int dashGapId) {
        this.colorId = colorId;
        this.widthId = widthId;
        this.dashWidthId = dashWidthId;
        this.dashGapId = dashGapId;
    }

    private boolean isAll() {
        return name().equals(ALL.name());
    }

    public int getColor(TypedArray a) {
        return a.getColor(colorId, (isAll() ? DEFAULT_COLOR : ALL.getColor(a)));
    }

    public int getWidth(TypedArray a) {
        return a.getDimensionPixelSize(widthId, (isAll() ? DEFAULT_WIDTH : ALL.getWidth(a)));
    }

    public int getDashWidth(TypedArray a) {
        return a.getDimensionPixelSize(dashWidthId, (isAll() ? DEFAULT_DASH_WIDTH : ALL.getDashWidth(a)));
    }

    public int getDashGap(TypedArray a) {
        return a.getDimensionPixelSize(dashGapId, (isAll() ? DEFAULT_DASH_GAP : ALL.getDashGap(a)));
    }

    public boolean isDash(TypedArray a) {
        return (getDashWidth(a) != DEFAULT_DASH_WIDTH) && (getDashGap(a) != DEFAULT_DASH_GAP);
    }

    public boolean exists(TypedArray a) {
        return (getColor(a) != DEFAULT_COLOR) && (getWidth(a) != DEFAULT_COLOR);
    }

    public Drawable getDrawable(TypedArray a) {
        if (!exists(a)) return null;

        GradientDrawable drawable = new GradientDrawable();
        if (isDash(a)) {
            drawable.setStroke(getWidth(a), getColor(a), getDashWidth(a), getDashGap(a));
        } else {
            drawable.setStroke(getWidth(a), getColor(a));
        }
        return drawable;
    }
}
