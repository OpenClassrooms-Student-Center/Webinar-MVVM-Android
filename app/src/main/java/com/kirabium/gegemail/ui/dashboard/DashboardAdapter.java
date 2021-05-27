package com.kirabium.gegemail.ui.dashboard;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kirabium.gegemail.R;
import com.kirabium.gegemail.events.DeleteMailEvent;
import com.kirabium.gegemail.model.Mail;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;


public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {

    private ArrayList<Mail> mails;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView object;
        private final TextView text;
        private final TextView expeditor;
        private ImageView delete;

        public ImageView getDelete() {
            return delete;
        }

        public TextView getObject() {
            return object;
        }

        public TextView getText() {
            return text;
        }

        public TextView getExpeditor() {
            return expeditor;
        }


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            object = (TextView) view.findViewById(R.id.object);
            text = (TextView) view.findViewById(R.id.text);
            expeditor = (TextView) view.findViewById(R.id.expeditor);
            delete = (ImageView) view.findViewById(R.id.delete);

        }
    }

    public DashboardAdapter(ArrayList<Mail> mails) {
        this.mails = mails;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dashboard, parent, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getText().setText(mails.get(position).getText());
        viewHolder.getObject().setText(mails.get(position).getObject());
        viewHolder.getExpeditor().setText(mails.get(position).getExpeditor());
        viewHolder.getDelete().setOnClickListener(view ->
                EventBus.getDefault().post(new DeleteMailEvent(mails.get(position)))
        );
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mails.size();
    }
}
