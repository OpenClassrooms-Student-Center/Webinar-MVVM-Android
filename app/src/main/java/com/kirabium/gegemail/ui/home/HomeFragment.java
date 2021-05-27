package com.kirabium.gegemail.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.kirabium.gegemail.R;
import com.kirabium.gegemail.di.DI;
import com.kirabium.gegemail.events.AddMailEvent;
import com.kirabium.gegemail.events.DeleteMailEvent;
import com.kirabium.gegemail.service.MailApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class HomeFragment extends Fragment {

    private static final MailApiService service = DI.getMailApiService();
    TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        textView = root.findViewById(R.id.text_home);
        updateUI();
        return root;
    }

    private void updateUI(){
        String text = "Vous avez " + service.getMails().size() + " mail" + (service.getMails().size() > 1 ? "s" : "");
        textView.setText(text);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(DeleteMailEvent event) {
        updateUI();
    };

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAddEvent(AddMailEvent event) {
        updateUI();
    };

}