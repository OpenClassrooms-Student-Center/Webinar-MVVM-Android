package com.kirabium.gegemail;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kirabium.gegemail.di.DI;
import com.kirabium.gegemail.events.AddMailEvent;
import com.kirabium.gegemail.events.DeleteMailEvent;
import com.kirabium.gegemail.model.Mail;
import com.kirabium.gegemail.service.MailApiService;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private void initUI() {
        setContentView(R.layout.activity_main);
        initBottomNavigationView();
        setButton();
    }

    private void setButton(){
        FloatingActionButton floatingActionButton = findViewById(R.id.button);
        floatingActionButton.setOnClickListener(view -> {
            EventBus.getDefault().post(new AddMailEvent(new Mail("Webinar", "nouveau webinar demain soir à 19h", "Openclassrooms")));
        });
    }

    private void initBottomNavigationView() {
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }


}