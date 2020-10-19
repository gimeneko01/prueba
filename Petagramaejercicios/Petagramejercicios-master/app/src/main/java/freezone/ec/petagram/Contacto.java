package freezone.ec.petagram;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class Contacto extends AppCompatActivity implements OnClickListener {

    Session session = null;
    ProgressDialog pdialog = null;
    Context context = null;
    TextInputEditText tieNombre, tieEmail, tieMensaje;
    //EditText reciep, sub, msg;
    String rec, subject, textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        context = this;

        Button EnviarMensaje = (Button) findViewById(R.id.BtEnviarComentario);
        tieEmail = (TextInputEditText) findViewById(R.id.tieEmail);
        tieNombre = (TextInputEditText) findViewById(R.id.tieNombre);
        tieMensaje = (TextInputEditText) findViewById(R.id.tieMensaje);

        EnviarMensaje.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        rec = tieEmail.getText().toString();
        subject = tieNombre.getText().toString();
        textMessage = tieMensaje.getText().toString();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("edi09migue@gmail.com", "EdissonIbarra1994");
            }
        });

        pdialog = ProgressDialog.show(context, "", "Enviando Mensaje...", true);

        RetreiveFeedTask task = new RetreiveFeedTask();
        task.execute();
    }

    class RetreiveFeedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try{
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("edi09migue@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rec));
                message.setSubject(subject);
                message.setContent(textMessage, "text/html; charset=utf-8");
                Transport.send(message);
            } catch(MessagingException e) {
                e.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            pdialog.dismiss();
            tieNombre.setText("");
            tieMensaje.setText("");
            tieEmail.setText("");
            Toast.makeText(getApplicationContext(), "Mensaje Enviado", Toast.LENGTH_LONG).show();
        }
    }


}