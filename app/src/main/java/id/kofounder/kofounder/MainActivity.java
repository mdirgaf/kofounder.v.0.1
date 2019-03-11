package id.kofounder.kofounder;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import id.kofounder.kofounder.Fragments.AkunFragment;
import id.kofounder.kofounder.Fragments.HomeFragment;
import id.kofounder.kofounder.Fragments.MentorFragment;
import id.kofounder.kofounder.Fragments.NetworkFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom_navigation;
    Fragment selectedfragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom_navigation = findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedfragment = new HomeFragment();
                            break;
                        case R.id.nav_network:
                            selectedfragment = new NetworkFragment();
                            break;
                        case R.id.nav_mentor:
                            selectedfragment = new MentorFragment();
                            break;
                        case R.id.nav_akun:
                            selectedfragment = new AkunFragment();
                            break;
                    }

                    if (selectedfragment != null){
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedfragment).commit();
                    }
                    return true;
                }
            };
}
