package mx.unam.horaribus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

//librerías para seleccion de tiempo
import android.widget.TimePicker;
import java.util.Calendar;
import java.util.Properties;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;

//Librerías para correo electrónico
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




public class ReporteActivity extends Activity implements OnClickListener{

    Session session = null;
    ProgressDialog pdialog = null;
    Context context = null;
    EditText  numerocuenta,nombre, ruta, reporte, horario;

    String rec, subject, textMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reporte);

        context = this;

        horario = (EditText) findViewById(R.id.time);

        Button login = (Button) findViewById(R.id.btn_submit);
        numerocuenta = (EditText) findViewById(R.id.numerocuenta);
        nombre = (EditText) findViewById(R.id.nombre);
        ruta =  (EditText) findViewById(R.id.ruta);
        horario = (EditText) findViewById(R.id.horario);
        reporte = (EditText) findViewById(R.id.descripcion);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        rec = "erickmarteln@gmail.com";
        StringBuilder sb1 =new StringBuilder();
        sb1.append("Reporte del transporte ");
        sb1.append(numerocuenta.getText().toString());
        subject = sb1.toString();
        StringBuilder sb =  new StringBuilder();
        sb.append("Numero de cuenta: ");
        sb.append(numerocuenta.getText().toString());
        sb.append("\nNombre: ");
        sb.append(nombre.getText().toString());
        sb.append("\nRuta: ");
        sb.append(ruta.getText().toString());
        sb.append("\nHorario: ");
        sb.append(horario.getText().toString());
        sb.append("\nDescripcion de lo sucedido: ");
        sb.append(reporte.getText().toString());
        textMessage =  sb.toString();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("horaribus.unam.fesc@gmail.com", "horaribus8");
            }
        });

        pdialog = ProgressDialog.show(context, "", "Enviando Reporte...", true);

        RetreiveFeedTask task = new RetreiveFeedTask();
        task.execute();
    }

    class RetreiveFeedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try{
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("testfrom354@gmail.com"));
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
            numerocuenta.setText("");
            nombre .setText("");
            ruta.setText("");
            horario.setText("");
            reporte.setText("");
            Intent objI = new Intent (ReporteActivity.this,MainActivity.class);
            startActivity(objI);
            Toast.makeText(getApplicationContext(), "Reporte Enviado", Toast.LENGTH_LONG).show();
        }
    }

    public void inicio (View view) {
        Intent objI = new Intent (ReporteActivity.this,MainActivity.class);
        startActivity(objI);
    }
    // perform click event listener on edit text
    public void reloj(View v) {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(ReporteActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                horario.setText(selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();

    }
}
