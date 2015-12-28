package info.izumin.android.viewborderhelper;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/**
 * Created by izumin on 15/05/13.
 */
public enum ViewBorder {
    ALL(
            R.styleable.ViewBorderHelper_borderColor,
            R.styleable.ViewBorderHelper_borderWidth,
            R.styleable.ViewBorderHelper_borderDashWidth,
            R.styleable.ViewBorderHelper_borderDashGap
    ),
    LEFT(
            R.styleable.ViewBorderHelper_borderLeftColor,
            R.styleable.ViewBorderHelper_borderLeftWidth,
            R.styleable.ViewBorderHelper_borderLeftDashWidth,
            R.styleable.ViewBorderHelper_borderLeftDashGap
    ),
    TOP(
            R.styleable.ViewBorderHelper_borderTopColor,
            R.styleable.ViewBorderHelper_borderTopWidth,
            R.styleable.ViewBorderHelper_borderTopDashWidth,
            R.styleable.ViewBorderHelper_borderTopDashGap
    ),
    RIGHT(
            R.styleable.ViewBorderHelper_borderRightColor,
            R.styleable.ViewBorderHelper_borderRightWidth,
            R.styleable.ViewBorderHelper_borderRightDashWidth,
            R.styleable.ViewBorderHelper_borderRightDashGap
    ),
    BOTTOM(
            R.styleable.ViewBorderHelper_borderBottomColor,
            R.styleable.ViewBorderHelper_borderBottomWidth,
            R.styleable.ViewBorderHelper_borderBottomDashWidth,
            R.styleable.ViewBorderHelper_borderBottomDashGap
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
