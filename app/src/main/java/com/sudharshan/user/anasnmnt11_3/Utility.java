package com.sudharshan.user.anasnmnt11_3;

import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;

        import java.io.ByteArrayOutputStream;

/**
 * Created by Pri on 9/2/2017.
 */

public class Utility {
    // converting  from bitmap to byte array
    public static byte[] getBytes(Bitmap bitmap) {
        //Java ByteArrayOutputStream class is used to write common data into multiple files.
        // In this stream, the data is written into a byte array which can be written to multiple streams later.
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        //Specifies the known formats a bitmap can be compressed into
        bitmap.compress(Bitmap.CompressFormat.JPEG, 0, stream);
        return stream.toByteArray();//returns the converted object into byte array
    }

    // Now converting from byte array to bitmap
    public static Bitmap getPhoto(byte[] image) {
        //converting the image
        //Decode an immutable bitmap from the specified byte array.
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
}
