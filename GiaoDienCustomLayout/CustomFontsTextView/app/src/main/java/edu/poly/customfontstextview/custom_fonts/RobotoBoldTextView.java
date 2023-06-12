package edu.poly.customfontstextview.custom_fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class RobotoBoldTextView extends AppCompatTextView { // biến thành text view

    public RobotoBoldTextView(@NonNull Context context) {
        super(context);
        setFontsTextView(context);
    }

    public RobotoBoldTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFontsTextView(context);
    }

    public RobotoBoldTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontsTextView(context);
    }

    // set typeface để biến fontTextView
    private void setFontsTextView(Context context) {
        Typeface typeface = ClassTypeFace.getRobotoRegularTypeface(context);
        setTypeface(typeface);
    }
}
