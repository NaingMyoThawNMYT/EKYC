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
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.qbayar.app2.model.OkayID;
import com.qbayar.app2.retrofitHelper.OkayIDAPIRetrofitHelper;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int PERMISSION_REQUEST_CODE = 34434;
    private static final int PICK_IMAGE_REQUEST_CODE = 5656;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.img_v);

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

        if (requestCode == PICK_IMAGE_REQUEST_CODE) {
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

                callAPI(bitmapToBase64String(bitmap));
            } else {
                Log.d(TAG, "onActivityResult() : fail to choose image");
            }
        }
    }

    private String bitmapToBase64String(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();

        return Base64.encodeToString(b, Base64.DEFAULT).replaceAll("\n", "");
    }

    public void showImageChooser(View v) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST_CODE);
    }

    private void callAPI(String base64ImageString) {
        OkayID okayID = new OkayID();
        okayID.setApiKey("Ba0UkW6l1LJWuevMJn9gpBLajRqaA5Nx");
        okayID.setImageEnabled(true);
        okayID.setImageFormat(".jpg");
        okayID.setBase64ImageString(base64ImageString);

        OkayIDAPIRetrofitHelper okayIDAPIRetrofitHelper = new OkayIDAPIRetrofitHelper();
        okayIDAPIRetrofitHelper.post(okayID,
                new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.d(TAG, "onResponse() : response = " + response.raw());
                        Toast.makeText(MainActivity.this, "Yay", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e(TAG, "onFailure() : fail", t);
                    }
                });
    }
}
