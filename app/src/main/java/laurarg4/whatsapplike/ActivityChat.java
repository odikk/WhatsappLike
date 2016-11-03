package laurarg4.whatsapplike;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.os.Message;

import java.util.ArrayList;


public class ActivityChat extends Activity{
    protected void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);
        setContentView(R.layout.activity_chat);

        String[] string_array = readArgs();

        TextView nick = (TextView) findViewById(R.id.text_nick);
        nick.setText(string_array[0] + "@" + string_array[1] + ":" + string_array[2]);


        ArrayList<Message> msg = null;
        Message sñ = new Message();
        Bundle sl = new Bundle();
        sl.putString("","hola");
        sñ.setData(sl);
        //msg.add(sñ);

        //AdapterWhatsappLike adapter_wl = new AdapterWhatsappLike(this, R.id.message, msg);

    }

    String[] readArgs()
    {

        Bundle extra_bundle = getIntent().getExtras();
        String[] ret = extra_bundle.getStringArray("Arguments");

        return ret;
    }
}
