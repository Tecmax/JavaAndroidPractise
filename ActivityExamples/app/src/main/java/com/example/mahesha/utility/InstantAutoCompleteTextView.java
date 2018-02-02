package com.example.mahesha.utility;

/**
 * Created by selva on 8/5/2016.
 */
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by PasiMatalamaki on 7.9.2015.
 */
public class InstantAutoCompleteTextView extends android.support.v7.widget.AppCompatAutoCompleteTextView {

    private boolean showAlways;

    public InstantAutoCompleteTextView(Context context) {
        super(context);
    }

    public InstantAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InstantAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    public InstantAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    public void setShowAlways(boolean showAlways) {
        this.showAlways = showAlways;
    }

    @Override
    public boolean enoughToFilter() {
        return showAlways || super.enoughToFilter();
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);

        showDropDownIfFocused();
    }

    private void showDropDownIfFocused() {
        if (enoughToFilter() && isFocused() && getWindowVisibility() == View.VISIBLE) {

            showDropDown();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        showDropDownIfFocused();
    }

}