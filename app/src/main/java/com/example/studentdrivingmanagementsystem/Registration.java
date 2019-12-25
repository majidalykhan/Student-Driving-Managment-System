package com.example.studentdrivingmanagementsystem;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Registration extends AppCompatActivity {

    EditText studentNo, name, address, postalCode, email, mobileNo,
             drivingLicenseNo, medicalCondition, reference, note, editdate;
    CheckBox provisionalDrivingLicenseChkbox, theoryTestPassedChkbox, previousDrivingChkbox, eyesightChkbox;
    ImageButton uploadBtn , dateBtn, submitRegBtn;








































    //EditText
    private static final String KEY_STUDENTNO = "student_no";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_POSTALCODE = "postalCode";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_MOBILENO = "mobileNo";
    private static final String KEY_drivingLicenseNo = "drivingLicenseNo";
    private static final String KEY_medicalCondition = "medicalCondition";
    private static final String KEY_reference = "reference";
    private static final String KEY_note = "note";
    //CheckBoxes
    private static final String KEY_provisionalDrivingLicenseChkbox = "provisionalDrivingLicense";
    private static final String KEY_theoryTestPassedChkbox = "theoryTestPassed";
    private static final String KEY_previousDrivingChkbox = "previousDriving";
    private static final String KEY_eyesightChkbox = "eyesight";
    //date
    private static final String KEY_date = "date";
    //Upload
    private static final String KEY_upload = "upload";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//    }

    private void SaveData(){
        String no = studentNo.getText().toString().trim();
        String Name = name.getText().toString().trim();
        String Address = address.getText().toString().trim();
        String postal = postalCode.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String mobile = mobileNo.getText().toString().trim();
        String licenseNo = drivingLicenseNo.getText().toString().trim();
        String medical = medicalCondition.getText().toString().trim();
        String referenc = reference.getText().toString().trim();
        String Note = note.getText().toString().trim();
        String date = editdate.getText().toString().trim();


        CollectionReference studentsdb = db.collection("students");

        studentData student = new studentData(
                no, Name, Address, postal, Email, mobile, licenseNo, medical, referenc, Note, date
        ){};

        studentsdb.add(student).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(Registration.this,"Register Successful",Toast.LENGTH_LONG).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Registration.this,"Register Failed",Toast.LENGTH_LONG).show();

            }
        });





    }
    Toolbar toolbar;
    Button btn_get_sign, mClear, mGetSign, mCancel;

    File file;
    Dialog dialog;
    LinearLayout mContent;
    View view;
    signature mSignature;
    Bitmap bitmap;

    // Creating Separate Directory for saving Generated Images
    String DIRECTORY = Environment.getExternalStorageDirectory().getPath() + "/DigitSign/";
    String pic_name = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
    String StoredPath = DIRECTORY + pic_name + ".png";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        studentNo = findViewById(R.id.studentNo);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        postalCode = findViewById(R.id.postalCode);
        email = findViewById(R.id.email);
        mobileNo = findViewById(R.id.mobileNo);
        drivingLicenseNo = findViewById(R.id.drivingLicenseNo);
        medicalCondition = findViewById(R.id.medicalCondition);
        reference = findViewById(R.id.reference);
        note = findViewById(R.id.note);
        editdate = findViewById(R.id.editDate);


        provisionalDrivingLicenseChkbox = findViewById(R.id.provisionalDrivingLicenseChkbox);
        theoryTestPassedChkbox = findViewById(R.id.theoryTestPassedChkbox);
        previousDrivingChkbox = findViewById(R.id.previousDrivingChkbox);
        eyesightChkbox = findViewById(R.id.eyesightChkbox);

        boolean checked = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("checkBox1", false);
        provisionalDrivingLicenseChkbox.setChecked(checked);


        uploadBtn = findViewById(R.id.uploadBtn);
        dateBtn = findViewById(R.id.date);
        submitRegBtn = findViewById(R.id.submitRegBtn);


        //For Date Input
        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel(){
                String myFormat = "dd-MM-yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                editdate.setText(sdf.format(myCalendar.getTime()));
            }
        };

        dateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(Registration.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        submitRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();

                Intent a = new Intent(Registration.this,RegisteredStudents.class);
                startActivity(a);
            }
        });










        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Setting ToolBar as ActionBar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Button to open signature panel
        btn_get_sign = (Button) findViewById(R.id.signaturee);

        // Method to create Directory, if the Directory doesn't exists
        file = new File(DIRECTORY);
        if (!file.exists()) {
            file.mkdir();
        }

        // Dialog Function
        dialog = new Dialog(Registration.this);
        // Removing the features of Normal Dialogs
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_signature);
        dialog.setCancelable(true);

        btn_get_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Function call for Digital Signature
                dialog_action();

            }
        });
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    // Function for Digital Signature
    public void dialog_action() {

        mContent = (LinearLayout) dialog.findViewById(R.id.linearLayout);
        mSignature = new signature(getApplicationContext(), null);
        mSignature.setBackgroundColor(Color.WHITE);
        // Dynamically generating Layout through java code
        mContent.addView(mSignature, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mClear = (Button) dialog.findViewById(R.id.clear);
        mGetSign = (Button) dialog.findViewById(R.id.getsign);
        mGetSign.setEnabled(false);
        mCancel = (Button) dialog.findViewById(R.id.cancel);
        view = mContent;

        mClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("tag", "Panel Cleared");
                mSignature.clear();
                mGetSign.setEnabled(false);
            }
        });
        mGetSign.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Log.v("tag", "Panel Saved");
                view.setDrawingCacheEnabled(true);
                mSignature.save(view, StoredPath);
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Successfully Saved", Toast.LENGTH_SHORT).show();
                // Calling the same class
                recreate();
            }
        });
        mCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("tag", "Panel Cancelled");
                dialog.dismiss();
                // Calling the same class
                recreate();
            }
        });
        dialog.show();
    }

    public class signature extends View {
        private static final float STROKE_WIDTH = 5f;
        private static final float HALF_STROKE_WIDTH = STROKE_WIDTH / 2;
        private Paint paint = new Paint();
        private Path path = new Path();

        private float lastTouchX;
        private float lastTouchY;
        private final RectF dirtyRect = new RectF();

        public signature(Context context, AttributeSet attrs) {
            super(context, attrs);
            paint.setAntiAlias(true);
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeWidth(STROKE_WIDTH);
        }

        @SuppressLint("WrongThread")
        public void save(View v, String StoredPath) {
            Log.v("tag", "Width: " + v.getWidth());
            Log.v("tag", "Height: " + v.getHeight());
            if (bitmap == null) {
                bitmap = Bitmap.createBitmap(mContent.getWidth(), mContent.getHeight(), Bitmap.Config.RGB_565);
            }
            Canvas canvas = new Canvas(bitmap);
            try {
                // Output the file
                FileOutputStream mFileOutStream = new FileOutputStream(StoredPath);
                v.draw(canvas);
                // Convert the output file to Image such as .png
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, mFileOutStream);
                mFileOutStream.flush();
                mFileOutStream.close();
            } catch (Exception e) {
                Log.v("log_tag", e.toString());
            }
        }

        public void clear() {
            path.reset();
            invalidate();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawPath(path, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float eventX = event.getX();
            float eventY = event.getY();
            mGetSign.setEnabled(true);

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(eventX, eventY);
                    lastTouchX = eventX;
                    lastTouchY = eventY;
                    return true;

                case MotionEvent.ACTION_MOVE:

                case MotionEvent.ACTION_UP:
                    resetDirtyRect(eventX, eventY);
                    int historySize = event.getHistorySize();
                    for (int i = 0; i < historySize; i++) {
                        float historicalX = event.getHistoricalX(i);
                        float historicalY = event.getHistoricalY(i);
                        expandDirtyRect(historicalX, historicalY);
                        path.lineTo(historicalX, historicalY);
                    }
                    path.lineTo(eventX, eventY);
                    break;
                default:
                    debug("Ignored touch event: " + event.toString());
                    return false;
            }

            invalidate((int) (dirtyRect.left - HALF_STROKE_WIDTH),
                    (int) (dirtyRect.top - HALF_STROKE_WIDTH),
                    (int) (dirtyRect.right + HALF_STROKE_WIDTH),
                    (int) (dirtyRect.bottom + HALF_STROKE_WIDTH));

            lastTouchX = eventX;
            lastTouchY = eventY;

            return true;
        }

        private void debug(String string) {
            Log.v("log_tag", string);
        }

        private void expandDirtyRect(float historicalX, float historicalY) {
            if (historicalX < dirtyRect.left) {
                dirtyRect.left = historicalX;
            } else if (historicalX > dirtyRect.right) {
                dirtyRect.right = historicalX;
            }

            if (historicalY < dirtyRect.top) {
                dirtyRect.top = historicalY;
            } else if (historicalY > dirtyRect.bottom) {
                dirtyRect.bottom = historicalY;
            }
        }

        private void resetDirtyRect(float eventX, float eventY) {
            dirtyRect.left = Math.min(lastTouchX, eventX);
            dirtyRect.right = Math.max(lastTouchX, eventX);
            dirtyRect.top = Math.min(lastTouchY, eventY);
            dirtyRect.bottom = Math.max(lastTouchY, eventY);
        }
    }








}
