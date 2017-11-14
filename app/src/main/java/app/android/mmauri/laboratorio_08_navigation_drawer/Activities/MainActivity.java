package app.android.mmauri.laboratorio_08_navigation_drawer.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import app.android.mmauri.laboratorio_08_navigation_drawer.Fragments.AlertsFragment;
import app.android.mmauri.laboratorio_08_navigation_drawer.Fragments.EmailFragment;
import app.android.mmauri.laboratorio_08_navigation_drawer.Fragments.InfoFragment;
import app.android.mmauri.laboratorio_08_navigation_drawer.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindUI();
        setToolbar();
        setDefaultFragment();

        // Configurar comportamiento de las opciones del menu
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setDefaultFragment() {
        changeFragment(new EmailFragment(), navigationView.getMenu().getItem(0));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        boolean fragmentTx = false;
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.menu_mail:
                fragment = new EmailFragment();
                fragmentTx = true;
                break;
            case R.id.menu_alerts:
                fragment = new AlertsFragment();
                fragmentTx = true;
                break;
            case R.id.menu_info:
                fragment = new InfoFragment();
                fragmentTx = true;
                break;
        }

        if (fragmentTx) {
            changeFragment(fragment, item);
        }

        return true;
    }

    private void changeFragment(Fragment fragment, MenuItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

        // Marca el item como clickeado
        item.setChecked(true);
        // Actualizamos el titulo del toolbar
        getSupportActionBar().setTitle(item.getTitle());
        // Cerramos el menu
        drawerLayout.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void bindUI() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navView);
    }
}
