package com.tp2.smsactionview;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    private EditText messageText;
    private String phoneNumber;
    private String message;
    private Button sendButton;
    private EditText phoneNumberField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageText = findViewById(R.id.editText);
        sendButton = findViewById(R.id.button);
        phoneNumberField = findViewById(R.id.editText2);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {sendSMS();}
        });
    }
    private void sendSMS() {
        phoneNumber = phoneNumberField.getText().toString();
        message = messageText.getText().toString();
        Uri uri = Uri.parse("smsto:" + phoneNumber);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.putExtra("sms_body", message);
        startActivity(intent);
    }
}
