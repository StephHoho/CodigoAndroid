package laweafome.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Comunicacion com;
    Button izq;
    Button der;
    Button ini;
    Button inst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        com= new Comunicacion();
        Thread hilo= new Thread(com);
        hilo.start();
        izq = (Button)findViewById(R.id.izq);
        der = (Button) findViewById(R.id.der);
        ini = (Button) findViewById(R.id.jugar);
        inst = (Button) findViewById(R.id.inst);
        izq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje= "izq";
                com.getInstance().enviar(mensaje);
            }
        });
        der.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mensaje= "der";
                com.getInstance().enviar(mensaje);
            }
        });
        ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje= "ini";
                com.getInstance().enviar(mensaje);
            }
        });
        inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje= "instrucciones";
                com.getInstance().enviar(mensaje);
            }
        });
    }
    public void onClick(View view) {

    }
}
