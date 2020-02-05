package com.qbayar.ekyc;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.qbayar.app2.callback.OkayDocMyKadPostAPICallback;
import com.qbayar.app2.callback.OkayIDPostAPICallback;
import com.qbayar.app2.model.OkayDocMyKad;
import com.qbayar.app2.model.OkayDocMyKadResponse;
import com.qbayar.app2.model.OkayID;
import com.qbayar.app2.model.OkayIDResponse;
import com.qbayar.app2.retrofitHelper.OkayDocAPIRetrofitHelper;
import com.qbayar.app2.retrofitHelper.OkayIDAPIRetrofitHelper;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int PERMISSION_REQUEST_CODE = 34434;
    private static final int PICK_IMAGE_REQUEST_CODE_FOR_OKAY_ID = 5656;
    private static final int PICK_IMAGE_REQUEST_CODE_FOR_OKAY_DOC_MY_KAD = 7733;

    private Button btnOkayId, btnOkayDocMyKad;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOkayId = findViewById(R.id.btn_okay_id);
        btnOkayDocMyKad = findViewById(R.id.btn_okay_doc_my_kad);
        imageView = findViewById(R.id.img_v);

        btnOkayId.setOnClickListener(this);
        btnOkayDocMyKad.setOnClickListener(this);

        requestPermission();
    }

    private void requestPermission() {
        List<String> requirePermissions = new ArrayList<>();

        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == -1) {
            requirePermissions.add("android.permission.READ_EXTERNAL_STORAGE");
        }

        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == -1) {
            requirePermissions.add("android.permission.CAMERA");
        }

        if (requirePermissions.isEmpty()) return;

        ActivityCompat.requestPermissions(this, requirePermissions.toArray(new String[]{}), PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            Uri imageUri = data.getData();

            if (imageUri == null) {
                Log.d(TAG, "onActivityResult() : imageUri is null");
                return;
            }

            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(imageUri, filePathColumn, null, null, null);

            if (cursor == null) {
                Log.d(TAG, "onActivityResult() : cursor is null");
                return;
            }

            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String imgDecodableString = cursor.getString(columnIndex);
            cursor.close();
            Bitmap bitmap = BitmapFactory.decodeFile(imgDecodableString);

            imageView.setImageBitmap(bitmap);

            switch (requestCode) {
                case PICK_IMAGE_REQUEST_CODE_FOR_OKAY_ID: {
                    postOkayIDAPI(bitmapToBase64String(bitmap));
                    break;
                }
                case PICK_IMAGE_REQUEST_CODE_FOR_OKAY_DOC_MY_KAD: {
                    postOkayDocMyKad(bitmapToBase64String(bitmap));
                    break;
                }
            }
        } else {
            Log.d(TAG, "onActivityResult() : fail to choose image");
        }
    }

    private String bitmapToBase64String(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();

        return Base64.encodeToString(b, Base64.DEFAULT).replaceAll("\n", "");
    }

    public void showImageChooser(int requestCode) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), requestCode);
    }

    private void postOkayIDAPI(String base64ImageString) {
        OkayID okayID = new OkayID();
        okayID.setApiKey("Ba0UkW6l1LJWuevMJn9gpBLajRqaA5Nx");
        okayID.setImageEnabled(true);
        okayID.setImageFormat(".jpg");
        okayID.setBase64ImageString(base64ImageString);

        OkayIDAPIRetrofitHelper.post(okayID,
                new OkayIDPostAPICallback() {
                    @Override
                    public void onResponse(OkayIDResponse okayIDResponse) {
                        Toast.makeText(MainActivity.this, "postOkayIDAPI() : onResponse", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(MainActivity.this, "postOkayIDAPI() : onFailure", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void postOkayDocMyKad(String base64ImageString) {
        OkayDocMyKad okayDocMyKad = new OkayDocMyKad();
        okayDocMyKad.setApiKey("Ba0UkW6l1LJWuevMJn9gpBLajRqaA5Nx");
        okayDocMyKad.setIdImageBase64Image(base64ImageString);
        okayDocMyKad.setPhotoSubstitutionCheck(true);
        okayDocMyKad.setEdgeDetection(true);
        okayDocMyKad.setFontCheck(true);
        okayDocMyKad.setHologram(true);
        okayDocMyKad.setColorMode(true);
        okayDocMyKad.setIcTypeCheck(true);
        okayDocMyKad.setLandmarkCheck(true);
        okayDocMyKad.setMicroprintCheck(true);

        OkayDocAPIRetrofitHelper.postMyKad(okayDocMyKad,
                new OkayDocMyKadPostAPICallback() {
                    @Override
                    public void onResponse(OkayDocMyKadResponse okayDocMyKadResponse) {
                        Toast.makeText(MainActivity.this, "postOkayDocMyKad() : onResponse", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(MainActivity.this, "postOkayDocMyKad() : onFailure", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_okay_id: {
                showImageChooser(PICK_IMAGE_REQUEST_CODE_FOR_OKAY_ID);
                break;
            }
            case R.id.btn_okay_doc_my_kad: {
                showImageChooser(PICK_IMAGE_REQUEST_CODE_FOR_OKAY_DOC_MY_KAD);
                break;
            }
        }
    }
}
