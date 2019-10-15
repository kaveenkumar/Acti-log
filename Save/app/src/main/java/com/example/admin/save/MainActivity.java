<br />
import android.graphics.Bitmap;<br />
import android.graphics.Canvas;<br />
import android.graphics.Color;<br />
import android.graphics.Paint;<br />
import android.graphics.Rect;<br />
import android.os.Environment;<br />
import android.support.v7.app.AppCompatActivity;<br />
import android.os.Bundle;<br />
import android.view.View;<br />
import android.widget.Button;<br />
import android.widget.LinearLayout;<br />
import java.io.File;<br />
import java.io.FileNotFoundException;<br />
import java.io.FileOutputStream;<br />
import java.io.IOException;<br />
import java.text.SimpleDateFormat;<br />
import java.util.Date;<br />
import java.util.Locale;</p>
        <p>public class MainActivity extends AppCompatActivity {</p>
<p>    @Override<br />
    protected void onCreate(Bundle savedInstanceState) {<br />
            super.onCreate(savedInstanceState);<br />
            setContentView(R.layout.activity_main);<br />
        final LinearLayout layout = (LinearLayout) findViewById(R.id.layout);<br />
                Button button = (Button) findViewById(R.id.button1);</p>
<p>        button.setOnClickListener(new View.OnClickListener() {<br />
            @Override<br />
            public void onClick(View v) {<br />
                    Bitmap bitmap = getBitmap(layout);<br />
                    saveChart(bitmap, layout.getMeasuredHeight(), layout.getMeasuredWidth());</p>
<p>            }<br />
        });<br />
    }</p>
<p>    public void saveChart(Bitmap getbitmap, float height, float width){<br />
            File folder = new File(Environment<br />
            .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),<br />
            &quot;myfolder&quot;);<br />
        boolean success = false;<br />
        if (!folder.exists())<br />
                {<br />
                success = folder.mkdirs();<br />
        }</p>
<p>        String timeStamp = new SimpleDateFormat(&quot;yyyyMMdd_HHmmss&quot;,<br />
                Locale.getDefault()).format(new Date());</p>
<p>        File file = new File(folder.getPath() + File.separator + &quot;/&quot;+timeStamp+&quot;.png&quot;);</p>
<p>        if ( !file.exists() )<br />
                {<br />
        try {<br />
                success = file.createNewFile();<br />
        } catch (IOException e) {<br />
                e.printStackTrace();<br />
        }<br />
        }</p>
<p>        FileOutputStream ostream = null;</p>
<p>        try{</p>
<p>            ostream = new FileOutputStream(file);</p>
<p>            System.out.println(ostream);</p>
<p>            Bitmap well = getbitmap;<br />
                    Bitmap save = Bitmap.createBitmap((int) width, (int) height, Bitmap.Config.ARGB_8888);<br />
                    Paint paint = new Paint();<br />
                    paint.setColor(Color.WHITE);<br />
                    Canvas now = new Canvas(save);<br />
                    now.drawRect(new Rect(0,0,(int) width, (int) height), paint);<br />
                    now.drawBitmap(well,<br />
                    new Rect(0,0,well.getWidth(),well.getHeight()),<br />
                    new Rect(0,0,(int) width, (int) height), null);</p>
<p>            if(save == null) {<br />
                    System.out.println(&quot;NULL bitmap save\n&quot;);<br />
            }<br />
                    save.compress(Bitmap.CompressFormat.PNG, 100, ostream);<br />
        }<br />
        catch (NullPointerException e){</p>
<p>            e.printStackTrace();<br />
            //Toast.makeText(getApplicationContext(), &quot;Null error&quot;, Toast.LENGTH_SHORT).show();<br />
        }<br />
        catch (FileNotFoundException e){</p>
<p>            e.printStackTrace();<br />
            // Toast.makeText(getApplicationContext(), &quot;File error&quot;, Toast.LENGTH_SHORT).show();<br />
        }<br />
        catch (IOException e){</p>
<p>            e.printStackTrace();<br />
            // Toast.makeText(getApplicationContext(), &quot;IO error&quot;, Toast.LENGTH_SHORT).show();<br />
        }<br />
    }</p>
<p>    public Bitmap getBitmap(LinearLayout layout){</p>
<p>        layout.setDrawingCacheEnabled(true);<br />
                layout.buildDrawingCache();<br />
                Bitmap bmp = Bitmap.createBitmap(layout.getDrawingCache());<br />
                layout.setDrawingCacheEnabled(false);</p>
<p>        return bmp;<br />
    }<br />
}<br />