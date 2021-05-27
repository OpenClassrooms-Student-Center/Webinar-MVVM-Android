package com.kirabium.gegemail.ui.notifications;

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
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kirabium.gegemail.R;
import com.kirabium.gegemail.di.DI;
import com.kirabium.gegemail.events.AddMailEvent;
import com.kirabium.gegemail.events.DeleteMailEvent;
import com.kirabium.gegemail.model.Mail;
import com.kirabium.gegemail.service.MailApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private static final MailApiService service = DI.getMailApiService();
    private ArrayList<Mail> mails;

    private RecyclerView mRecyclerView;

    private void initData(){
        mails = new ArrayList<>(service.getMails());
    }

    private void initRecyclerView(View root) {
        mRecyclerView = (RecyclerView) root.findViewById(R.id.recyclerview);
        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        NotificationAdapter mAdapter = new NotificationAdapter(mails);
        // Set CustomAdapter as the adapter for RecyclerView.
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                layoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        initData();
        initRecyclerView(root);
        return root;
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
    public void onDeleteEvent(DeleteMailEvent event) {
        mails.clear();
        mails.addAll(service.getMails());
        mRecyclerView.getAdapter().notifyDataSetChanged();
    };

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAddEvent(AddMailEvent event) {
        mails.clear();
        mails.addAll(service.getMails());
        mRecyclerView.getAdapter().notifyDataSetChanged();
    };

}