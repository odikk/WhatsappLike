package laurarg4.whatsapplike;

//Authors: Laura Ripoll and Arnald Vilella

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Message;
import android.view.View;
import android.util.Log;

import java.util.logging.Logger;
import java.util.ArrayList;


public class ActivityChat extends Activity{

    private ListView conversation;
    private EditText input_text;
    private AdapterWhatsappLike adapter_wl;
    private ArrayList<String> messages;
    //private boolean align_to_the_right;

    @Override
    protected void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);
        setContentView(R.layout.activity_chat);

        String[] string_array = readArgs();

        TextView nick = (TextView) findViewById(R.id.text_nick);
        nick.setText(string_array[0] + "@" + string_array[1] + ":" + string_array[2]);

        //scrollView = (ScrollView)findViewById(R.id.scrollview);
        conversation = (ListView) findViewById(R.id.conversation);
        messages = new ArrayList<String>();
        adapter_wl = new AdapterWhatsappLike(this, messages);
        conversation.setAdapter(adapter_wl);
        input_text = (EditText) findViewById(R.id.input);

    }

    String[] readArgs()
    {

        Bundle extra_bundle = getIntent().getExtras();
        String[] ret = extra_bundle.getStringArray("Arguments");

        return ret;
    }

    public void addText(final View view) {

        if(input_text.getEditableText().toString().equals(""))
            return;

        messages.add(input_text.getEditableText().toString());
        input_text.setText("");
        conversation.post(new Runnable() {
            @Override
            public void run() {
                conversation.setSelection(conversation.getCount() - 1);
                }
        });

        adapter_wl.notifyDataSetChanged();
    }
}
