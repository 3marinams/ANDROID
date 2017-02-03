package com.idi.marinamoreno.calculadora;

import android.app.NotificationManager;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraActivity extends BaseActivity implements View.OnClickListener {
    private double num_anterior;
    private String operacio="";
    private boolean clear = false;
    private boolean op = false;
    private boolean number = false;
    private double resultat = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        Button button0 = (Button) findViewById(R.id.boto_0);
        button0.setOnClickListener(this);

        Button button1 = (Button) findViewById(R.id.boto_1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.boto_2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.boto_3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.boto_4);
        button4.setOnClickListener(this);

        Button button5 = (Button) findViewById(R.id.boto_5);
        button5.setOnClickListener(this);

        Button button6 = (Button) findViewById(R.id.boto_6);
        button6.setOnClickListener(this);

        Button button7 = (Button) findViewById(R.id.boto_7);
        button7.setOnClickListener(this);

        Button button8 = (Button) findViewById(R.id.boto_8);
        button8.setOnClickListener(this);

        Button button9 = (Button) findViewById(R.id.boto_9);
        button9.setOnClickListener(this);

        Button buttonC = (Button) findViewById(R.id.boto_C);
        buttonC.setOnClickListener(this);

        Button buttonAC = (Button) findViewById(R.id.boto_AC);
        buttonAC.setOnClickListener(this);

        Button button100 = (Button) findViewById(R.id.boto_100);
        button100.setOnClickListener(this);

        Button buttonDivisio = (Button) findViewById(R.id.boto_divisio);
        buttonDivisio.setOnClickListener(this);

        Button buttonMultiplicacio = (Button) findViewById(R.id.boto_multiplicacio);
        buttonMultiplicacio.setOnClickListener(this);

        Button buttonResta = (Button) findViewById(R.id.boto_resta);
        buttonResta.setOnClickListener(this);

        Button buttonSuma = (Button) findViewById(R.id.boto_suma);
        buttonSuma.setOnClickListener(this);

        Button buttonResultat = (Button) findViewById(R.id.boto_resultat);
        buttonResultat.setOnClickListener(this);

        Button buttonComa = (Button) findViewById(R.id.boto_coma);
        buttonComa.setOnClickListener(this);

        Button buttonANS = (Button) findViewById(R.id.boto_ANS);
        buttonANS.setOnClickListener(this);

        ImageButton phone = (ImageButton) findViewById(R.id.phone);
        phone.setOnClickListener(this);

        ImageButton internet = (ImageButton) findViewById(R.id.internet);
        internet.setOnClickListener(this);

        /*TextView t = (TextView) findViewById(R.id.num);
        t.setOnLongClickListener((v)->
                v.setOnCreateContextMenuListener(menu, v, menuInfo)->{
                MenuInflater infl = getMenuInflater();
                infl.inflate(R.menu.menulong, menu);
                });

        return false;*/

    }

    protected void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);
        TextView t = (TextView) findViewById(R.id.num);
        outstate.putString("result",t.getText().toString());
        Log.v("resultat:", t.getText().toString());
    }

    protected void onRestoreInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);
        TextView t = (TextView) findViewById(R.id.num);
        t.setText(outstate.getString("result"));
        Log.v("RESTORE:", outstate.getString("result") );
    }

    public void onClick(View v){
        Log.v("ATENCIÓ", "ON CLICK");
        TextView t = (TextView) findViewById(R.id.num);
        String valor_actual = t.getText().toString();
        CharSequence aux = t.getText();
        switch(v.getId()){
            case R.id.internet:{
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, t.getText().toString());
                startActivity(intent);
                break;
            }
            case R.id.phone:{
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+t.getText().toString()));
                startActivity(intent);
                break;
            }
            case R.id.boto_0:
                if (clear){
                    t.setText("");
                    valor_actual = "";
                    clear= false;
                }
                if (op) {
                    t.setText("0");
                    op = false;
                }
                else t.setText(valor_actual+"0");
                number = true;
                Log.v("ATENCIÓ", "he clicat el botó 0");
                break;

            case R.id.boto_1:
                if (clear){
                    t.setText("");
                    valor_actual = "";
                    clear= false;
                }
                if (op) {
                    t.setText("1");
                    op =false;
                }
                else t.setText(valor_actual+"1");
                number = true;
                Log.v("ATENCIÓ", "he clicat el botó 1");
                break;

            case R.id.boto_2:
                if (clear){
                    t.setText("");
                    valor_actual = "";
                    clear= false;
                }
                if (op){
                    t.setText("2");
                    op =false;
                }
                else t.setText(valor_actual+"2");
                number = true;
                Log.v("ATENCIÓ", "he clicat el botó 2");
                break;

            case R.id.boto_3:
                if (clear){
                    t.setText("");
                    valor_actual = "";
                    clear= false;
                }
                if (op){
                    t.setText("3");
                    op =false;
                }
                else t.setText(valor_actual+"3");
                number = true;
                Log.v("ATENCIÓ", "he clicat el botó 3");
                break;

            case R.id.boto_4:
                if (clear){
                    t.setText("");
                    valor_actual = "";
                    clear= false;
                }
                if (op) {
                    t.setText("4");
                    op =false;
                }
                else t.setText(valor_actual+"4");
                number = true;
                Log.v("ATENCIÓ", "he clicat el botó 4");
                break;

            case R.id.boto_5:
                if (clear){
                    t.setText("");
                    valor_actual = "";
                    clear= false;
                }
                if (op){
                    t.setText("5");
                    op =false;
                }
                else t.setText(valor_actual+"5");
                number = true;
                Log.v("ATENCIÓ", "he clicat el botó 5");
                break;

            case R.id.boto_6:
                if (clear){
                    t.setText("");
                    valor_actual = "";
                    clear= false;
                }
                if (op) {
                    t.setText("6");
                    op =false;
                }
                else t.setText(valor_actual+"6");
                number = true;
                Log.v("ATENCIÓ", "he clicat el botó 6");
                break;

            case R.id.boto_7:
                if (clear){
                    t.setText("");
                    valor_actual = "";
                    clear= false;
                }
                if (op){
                    t.setText("7");
                    op =false;
                }
                else t.setText(valor_actual+"7");
                number = true;
                Log.v("ATENCIÓ", "he clicat el botó 7");
                break;

            case R.id.boto_8:
                if (clear){
                    Log.v("CLEAR?", "CLEAR ES TRUE");
                    t.setText("");
                    valor_actual = "";
                    clear= false;
                }
                if (op) {
                    t.setText("8");
                    op =false;
                }
                else t.setText(valor_actual+"8");
                number = true;
                Log.v("ATENCIÓ", "he clicat el botó 8");
                break;

            case R.id.boto_9:
                if (clear){
                    t.setText("");
                    valor_actual = "";
                    clear= false;
                }
                if (op) {
                    t.setText("9");
                    op =false;
                }
                else t.setText(valor_actual+"9");
                number = true;
                Log.v("ATENCIÓ", "he clicat el botó 9");
                break;

            case R.id.boto_C:
                if(number) {
                    operacio = "clear";
                    clear = true;
                    t.setText("0");
                    Log.v("ATENCIÓ", "he clicat el botó C");
                }
                else t.setText("");
                break;

            case R.id.boto_AC:
                if(number) {
                    if (t.length() > 0) {
                        int start = 0;
                        int end = t.length() - 1;
                        aux = aux.subSequence(start, end);
                        t.setText(aux);
                    }
                    Log.v("ATENCIÓ", "he clicat el botó DELETE");
                }
                else t.setText("");
            break;

            case R.id.boto_100:
                if(number) {
                    if (clear) {
                        t.setText("");
                        clear = false;
                    }
                    op = true;
                    num_anterior = Double.valueOf(t.getText().toString());
                    resultat = num_anterior/100.0;
                    t.setText(String.valueOf(resultat));
                    Log.v("ATENCIÓ", "he clicat el botó %");
                }
                else t.setText("");
                break;

            case R.id.boto_divisio:
                if(number) {
                    if (clear) {
                        t.setText("");
                        clear = false;
                    }
                    operacio = "divisio";
                    op = true;
                    num_anterior = Double.valueOf(t.getText().toString());
                    t.setText(String.valueOf(num_anterior));
                    Log.v("ATENCIÓ", "he clicat el botó divisio");
                }
                else t.setText("");
                break;

            case R.id.boto_multiplicacio:
                if(number) {
                    if (clear) {
                        t.setText("");
                        clear = false;
                    }
                    operacio = "multiplicacio";
                    op = true;
                    num_anterior = Double.valueOf(t.getText().toString());
                    t.setText(String.valueOf(num_anterior));
                    Log.v("ATENCIÓ", "he clicat el botó multiplicacio");
                }
                else t.setText("");
                break;

            case R.id.boto_resta:
                if(number) {
                    if (clear) {
                        t.setText("");
                        clear = false;
                    }
                    operacio = "resta";
                    op = true;
                    num_anterior = Double.valueOf(t.getText().toString());
                    t.setText(String.valueOf(num_anterior));
                    Log.v("ATENCIÓ", "he clicat el botó resta");
                }
                else t.setText("");
                break;

            case R.id.boto_suma:
                if(number) {
                    if (clear) {
                        t.setText("");
                        clear = false;
                    }
                    operacio = "suma";
                    op = true;
                    num_anterior = Double.valueOf(t.getText().toString());
                    t.setText(String.valueOf(String.valueOf(num_anterior)));
                    Log.v("ATENCIÓ", "he clicat el botó suma");

                }
                else t.setText("");
                break;
            case R.id.boto_ANS:{
                Log.v("ANS:", "he clicat ANS");
                if (op){
                    Log.v("ANS:", "OP");
                    System.out.println(resultat);
                    t.setText(String.valueOf(Double.valueOf(resultat)));
                }
                break;
            }
            case R.id.boto_resultat:
                if(number) {
                    if(operacio != "") {
                        switch (operacio) {
                            case "suma":
                                Log.v("num_anterior:", String.valueOf(num_anterior));
                                valor_actual = t.getText().toString();
                                Log.v("valor actual:", valor_actual);
                                resultat = num_anterior + Double.valueOf(valor_actual);
                                Log.v("resultat val:", String.valueOf(resultat));
                                t.setText(String.valueOf(String.valueOf(resultat)));
                                break;

                            case "resta":
                                Log.v("num_anterior:", String.valueOf(num_anterior));
                                valor_actual = t.getText().toString();
                                Log.v("valor actual:", valor_actual);
                                resultat = num_anterior - Double.valueOf(valor_actual);
                                t.setText(String.valueOf(String.valueOf(resultat)));
                                break;

                            case "multiplicacio":
                                valor_actual = t.getText().toString();
                                resultat = num_anterior * Double.valueOf(valor_actual);
                                t.setText(String.valueOf(String.valueOf(resultat)));
                                break;
                            case "divisio":
                                valor_actual = t.getText().toString();
                                SharedPreferences sp = this.getSharedPreferences("notificacions",0);
                                boolean b_toast = sp.getBoolean("notification_toast", false);


                                SharedPreferences sp_estat = this.getSharedPreferences("notificacions",0);
                                boolean b_estat = sp_estat.getBoolean("notification_estat", false);


                                if (Double.valueOf(valor_actual) == 0) {
                                    //Log.v("TAAAAAAAG", "SOC LA NURIA");
                                    //TOAST
                                    if(b_toast){
                                        Toast toast = Toast.makeText(getApplicationContext(), "Divisió per 0", Toast.LENGTH_SHORT);
                                        toast.show();
                                    }
                                    //ESTAT
                                    if(b_estat){
                                        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                                    NotificationCompat.Builder ncb = new NotificationCompat.Builder(this)
                                            .setSmallIcon(R.drawable.star_wars)
                                            .setContentTitle("CALCULADORA")
                                            .setContentText("Divisió per 0");

                                    nm.notify(0,ncb.build());
                                    }
                                    break;
                                }
                                else {
                                    resultat = num_anterior / Double.valueOf(valor_actual);
                                    t.setText(String.valueOf(String.valueOf(resultat)));
                                    break;
                                }
                        }
                        operacio="";
                        op=false;
                    }
                    else t.setText(String.valueOf(num_anterior));

                    number = false;
                }
                else t.setText("");

                op = false;
                clear=true;
                Log.v("ATENCIÓ", "he clicat el botó resultat");
                break;

            case R.id.boto_coma:
                if (clear){
                    t.setText("");
                    clear= false;
                }
                t.setText(valor_actual+".");
                Log.v("ATENCIÓ", "he clicat el botó coma");
                break;
            default:
                t.setText("0");
                break;
        }
    }

}
