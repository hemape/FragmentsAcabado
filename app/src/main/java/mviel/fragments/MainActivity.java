package mviel.fragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements Fragment2.Comunicador, Fragment2.OnFragmentInteractionListener2,Fragment3.OnFragmentInteractionListener3 {

    //Variable Global del contador
    public static int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction2(Uri uri) {

    }

    @Override
    public boolean estaFragment3EnActivity() {
        Fragment3 f3= (Fragment3)getFragmentManager().findFragmentById(R.id.canto_inferior_dret);
        if(f3==null)
            return false;
        else
            return true;
    }

    public boolean estaFragment2EnActivity() {
        Fragment2 f2= (Fragment2)getFragmentManager().findFragmentById(R.id.canto_superior_dret);
        if(f2==null)
            return false;
        else
            return true;
    }

    @Override
    public void onFragmentInteraction3(Uri uri) {

    }

    @Override
    public void onBackPressed() {
        FragmentTransaction ft;
        FragmentManager fm;
        fm = getFragmentManager();
        ft = fm.beginTransaction();

        if (estaFragment3EnActivity()){
            ft.remove(getFragmentManager().findFragmentById(R.id.canto_inferior_dret));
            ft.commit();

            mostrarToast("Ha desaparecido el Fragment 3");
        } else if (estaFragment2EnActivity()){
            ft.remove(getFragmentManager().findFragmentById(R.id.canto_superior_dret));
            ft.commit();

            mostrarToast("Ha desaparecido el Fragment 2");
        } else {
            super.onBackPressed();
        }

    }

    public void mostrarToast(String mensaje){
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
    }

    @Override
    public void comunicat(int cont) {
        contador = cont;
    }
}