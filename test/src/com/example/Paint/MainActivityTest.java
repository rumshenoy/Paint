package com.example.Paint;

import android.annotation.SuppressLint;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.example.Paint.MainActivityTest \
 * com.example.Paint.tests/android.test.InstrumentationTestRunner
 */
@SuppressLint("NewApi")
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super("com.example.Paint", MainActivity.class);
    }

    private MainActivity mainActivity;
    private Button mFirstButton;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainActivity = getActivity();
        mFirstButton = (Button) mainActivity.findViewById(R.id.new_paintings_btn);
    }

    public void testMView_labelText() {
        final String expected = "New Painting";
        final String actual = mFirstButton.getText().toString();
        assertEquals(expected, actual);
    }
}
