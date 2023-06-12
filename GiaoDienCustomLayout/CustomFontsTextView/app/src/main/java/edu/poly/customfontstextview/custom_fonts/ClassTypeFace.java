package edu.poly.customfontstextview.custom_fonts;

import android.content.Context;
import android.graphics.Typeface;

public class ClassTypeFace {
    // typeface giúp ta custom fonts text view(Tạo ra fonts text view)
    private static Typeface aboretoRegularTypeface;
    private static Typeface qwitcherGrypenBoldTypeface;
    private static Typeface qwitcherGrypenRegularTypeface;
    private static Typeface robotoRegularTypeface;


    // dùng static để dùng chung nếu chưa tạo thì tạo đỡ phải tạo nhiều
    public static Typeface getAboretoRegularTypeface(Context context) {
        if(aboretoRegularTypeface == null) {
            aboretoRegularTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/Aboreto-Regular.ttf");
        }
        return aboretoRegularTypeface;
    }

    public static Typeface getQwitcherGrypenBoldTypeface(Context context) {
        if(qwitcherGrypenBoldTypeface == null) {
            qwitcherGrypenBoldTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/QwitcherGrypen-Bold.ttf");
        }
        return qwitcherGrypenBoldTypeface;
    }

    public static Typeface getQwitcherGrypenRegularTypeface(Context context) {
        if(qwitcherGrypenRegularTypeface == null) {
            qwitcherGrypenRegularTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/QwitcherGrypen-Regular.ttf");
        }
        return qwitcherGrypenRegularTypeface;
    }

    public static Typeface getRobotoRegularTypeface(Context context) {
        if(robotoRegularTypeface == null) {
            robotoRegularTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Bold.ttf");
        }
        return robotoRegularTypeface;
    }
}
