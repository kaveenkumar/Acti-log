package com.example.admin.save2;

import android.graphics.Bitmap;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.Rect;
        import android.os.Environment;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.LinearLayout;
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.Locale;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        final LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
                Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Bitmap bitmap = getBitmap(layout);
                    saveChart(bitmap, layout.getMeasuredHeight(), layout.getMeasuredWidth());
            }
        });
    }
    public void saveChart(Bitmap getbitmap, float height, float width){
            File folder = new File(Environment
            .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
            "myfolder");
        boolean success = false;
        if (!folder.exists())
                {
                success = folder.mkdirs();
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File file = new File(folder.getPath() + File.separator + "/"+timeStamp+".png");
        if ( !file.exists() )
                {
        try {
                success = file.createNewFile();
        } catch (IOException e) {
                e.printStackTrace();
        }
        }
        FileOutputStream ostream = null;
        try{
            ostream = new FileOutputStream(file);
            System.out.println(ostream);
            Bitmap well = getbitmap;
                    Bitmap save = Bitmap.createBitmap((int) width, (int) height, Bitmap.Config.ARGB_8888);
                    Paint paint = new Paint();
                    paint.setColor(Color.WHITE);
                    Canvas now = new Canvas(save);
                    now.drawRect(new Rect(0,0,(int) width, (int) height), paint);
                    now.drawBitmap(well,
                    new Rect(0,0,well.getWidth(),well.getHeight()),
                    new Rect(0,0,(int) width, (int) height), null);
            if(save == null) {
                    System.out.println("NULL bitmap save\n");
            }
                    save.compress(Bitmap.CompressFormat.PNG, 100, ostream);
        }
        catch (NullPointerException e){
            e.printStackTrace();
            //Toast.makeText(getApplicationContext(), &quot;Null error&quot;, Toast.LENGTH_SHORT).show();<br />
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            // Toast.makeText(getApplicationContext(), &quot;File error&quot;, Toast.LENGTH_SHORT).show();<br />
        }
        catch (IOException e){
            e.printStackTrace();
            // Toast.makeText(getApplicationContext(), &quot;IO error&quot;, Toast.LENGTH_SHORT).show();<br />
        }
    }
    public Bitmap getBitmap(LinearLayout layout){
        layout.setDrawingCacheEnabled(true);
                layout.buildDrawingCache();
                Bitmap bmp = Bitmap.createBitmap(layout.getDrawingCache());
                layout.setDrawingCacheEnabled(false);
        return bmp;
    }
}