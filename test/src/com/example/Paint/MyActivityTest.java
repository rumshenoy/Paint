package com.example.Paint;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageButton;

/**
 * Created by ramyashenoy on 12/10/14.
 */

@SuppressLint("NewApi")
public class MyActivityTest extends ActivityInstrumentationTestCase2<MyActivity> {

    public MyActivityTest() {
        super("com.example.Paint", MyActivity.class);
    }

    private MyActivity myActivity;
    private ImageButton newPicButton;
    private ImageButton savePicButton;
    private ImageButton drawButton;
    private ImageButton eraseButton;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        myActivity = getActivity();
        newPicButton = (ImageButton) myActivity.findViewById(R.id.new_btn);
        savePicButton = (ImageButton) myActivity.findViewById(R.id.save_btn);
        drawButton = (ImageButton) myActivity.findViewById(R.id.draw_btn);
        eraseButton = (ImageButton) myActivity.findViewById(R.id.erase_btn);
    }

    public void testNewButtonDrawable() {
        final Drawable.ConstantState expected = myActivity.getResources().getDrawable(R.drawable.new_pic).getConstantState();
        final Drawable.ConstantState actual = newPicButton.getDrawable().getConstantState();
        assertEquals(expected, actual);
    }

    public void testSaveButtonDrawable() {
        final Drawable.ConstantState expected = myActivity.getResources().getDrawable(R.drawable.save).getConstantState();
        final Drawable.ConstantState actual = savePicButton.getDrawable().getConstantState();
        assertEquals(expected, actual);
    }

    public void testDrawButtonDrawable() {
        final Drawable.ConstantState expected = myActivity.getResources().getDrawable(R.drawable.brush).getConstantState();
        final Drawable.ConstantState actual = drawButton.getDrawable().getConstantState();
        assertEquals(expected, actual);
    }

    public void testEraseButtonDrawable() {
        final Drawable.ConstantState expected = myActivity.getResources().getDrawable(R.drawable.eraser).getConstantState();
        final Drawable.ConstantState actual = eraseButton.getDrawable().getConstantState();
        assertEquals(expected, actual);
    }


}
