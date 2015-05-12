package info.izumin.android.viewborderhelper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by izumin on 15/05/13.
 */
public class ViewBorderHelper {
    private static final String TAG = ViewBorderHelper.class.getSimpleName();

    private Context context;
    private AttributeSet attrs;

    public ViewBorderHelper(Context context, AttributeSet attrs) {
        this.context = context;
        this.attrs = attrs;
    }

    public void setBorder(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(getDrawable());
        } else {
            view.setBackgroundDrawable(getDrawable());
        }
    }

    private Drawable getDrawable() {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ViewBorderHelper);

        List<ViewBorder> borders = new ArrayList<>();
        for (ViewBorder border: ViewBorder.values()) {
            if (border.exists(a)) borders.add(border);
        }

        Drawable[] layers = new Drawable[borders.size()];
        for (int i = 0; i < borders.size(); i++) {
            layers[i] = borders.get(i).getDrawable(a);
        }

        LayerDrawable layerDrawable = new LayerDrawable(layers);
        for (int i = 0; i < borders.size(); i++) {
            ViewBorder border = borders.get(i);
            LayerInsetSetter setter = LayerInsetSetter.valueOf(border.name());
            layerDrawable = setter.set(i, border.getWidth(a), layerDrawable);
        }

        return layerDrawable;
    }
}
