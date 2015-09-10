package com.afeiluo.practiceproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.EventListener;

/**
 * Created by qiaolinfei on 2015/8/6.
 */
public class IntentActivity extends Activity {
    private static final String TAG = "IntentActivity";
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_SELECT_CONTACT = 2;
    static final int REQUEST_SELECT_PHONE_NUMBER = 3;
    static final int REQUEST_IMAGE_GET = 4;
    static final int REQUEST_IMAGE_OPEN = 5;
    static final Uri mLocationForPhotos = Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath());
    private Button alarmBtn;
    private Button timerBtn;
    private Button eventBtn;
    private Button capPhoto;
    private Button capPhotoImageMode;
    private Button slectContactBtn;
    private Button selectPhoneBtn;
    private Button selectPhotoBtn;
    private Button openFileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_activity);
        alarmBtn = (Button) findViewById(R.id.alarm_intent);
        alarmBtn.setOnClickListener(new MyClickListener());
        timerBtn = (Button) findViewById(R.id.timer_intent);
        timerBtn.setOnClickListener(new MyClickListener());
        eventBtn = (Button) findViewById(R.id.event_intent);
        eventBtn.setOnClickListener(new MyClickListener());
        capPhoto = (Button) findViewById(R.id.pic_video_intent);
        capPhoto.setOnClickListener(new MyClickListener());
        capPhotoImageMode = (Button) findViewById(R.id.cam_image_intent);
        capPhotoImageMode.setOnClickListener(new MyClickListener());
        slectContactBtn = (Button) findViewById(R.id.select_contact_intent);
        slectContactBtn.setOnClickListener(new MyClickListener());
        selectPhoneBtn = (Button) findViewById(R.id.select_phone_number);
        selectPhoneBtn.setOnClickListener(new MyClickListener());
        selectPhotoBtn = (Button) findViewById(R.id.select_file_image);
        selectPhotoBtn.setOnClickListener(new MyClickListener());
        openFileBtn = (Button) findViewById(R.id.open_file_image);
        openFileBtn.setOnClickListener(new MyClickListener());
    }

    class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.alarm_intent) {
                createAlarm("test alarm", 0, 0);
            } else if (id == R.id.timer_intent) {
                startTimer("ssss", 12);
            } else if (id == R.id.event_intent) {
                Calendar now = Calendar.getInstance();
                Calendar tom = Calendar.getInstance();
                tom.add(Calendar.DAY_OF_WEEK, 1);
                addEvent("xxx", "gz", now, tom);
            } else if (id == R.id.pic_video_intent) {
                capturePhoto("test.jpg");
            } else if (id == R.id.cam_image_intent) {
                capturePhoto();
            } else if (id == R.id.select_contact_intent) {
                selectContact();
            } else if (id == R.id.select_phone_number) {
                selectContactPhone();
            } else if (id == R.id.select_file_image) {
                selectImage();
            } else if (id == R.id.open_file_image) {
                selectImageOPEN();
            }
        }
    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void startTimer(String message, int seconds) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, seconds)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void addEvent(String title, String location, Calendar begin, Calendar end) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void capturePhoto(String targetFilename) {
        //Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                Uri.withAppendedPath(mLocationForPhotos, targetFilename));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void capturePhoto() {
        // Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        Intent intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void selectContact() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT);
        }
    }

    public void selectContactPhone() {
        // Start an activity for the user to pick a phone number from contacts
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_PHONE_NUMBER);
        }
    }

    public void viewContact(Uri contactUri) {
        Intent intent = new Intent(Intent.ACTION_VIEW, contactUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void selectImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_GET);
        }
    }

    public void selectImageOPEN() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        // Only the system receives the ACTION_OPEN_DOCUMENT, so no need to test.
        startActivityForResult(intent, REQUEST_IMAGE_OPEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // Bitmap thumbnail = data.getParcelable("data");
            // Do other work with full size photo saved in mLocationForPhotos
            // ...
            Log.i(TAG, "xxxx");
        } else if (requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK) {
            Uri contactUri = data.getData();
            // Do something with the selected contact at contactUri
            // ...
        } else if (requestCode == REQUEST_SELECT_PHONE_NUMBER && resultCode == RESULT_OK) {
            // Get the URI and query the content provider for the phone number
            Uri contactUri = data.getData();
            if (contactUri != null) {
                viewContact(contactUri);
            }
            String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
            Cursor cursor = getContentResolver().query(contactUri, projection,
                    null, null, null);
            // If the cursor returned is valid, get the phone number
            if (cursor != null && cursor.moveToFirst()) {
                int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(numberIndex);
                // Do something with the phone number
                // ...
                Log.i(TAG, "number");
            }
        } else if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {
            Uri fullPhotoUri = data.getData();
            // Do work with full size photo saved at fullPhotoUri
            //...
        } else if (requestCode == REQUEST_IMAGE_OPEN && resultCode == RESULT_OK) {
            Uri fullPhotoUri = data.getData();
            // Do work with full size photo saved at fullPhotoUri
            //...
        }
    }
}
