package br.berbert.capstone.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.List;

import br.berbert.capstone.CapstoneApplication;
import br.berbert.capstone.R;
import br.berbert.capstone.Utilities;

/**
 * Created by Felipe Berbert for the Udacity Android Nanodegree capstone project on 17/08/2016.
 *
 */
public class AttributionsAdapter extends RecyclerView.Adapter<AttributionsAdapter.AttributionsViewHolder> {

    Context mContext;
    Tracker mTracker;
    List<String> mAttributionsList;

    public AttributionsAdapter(CapstoneApplication app, Context context, List<String> attributionsList) {
        mTracker = app.getDefaultTracker();
        mContext = context;
        mAttributionsList = attributionsList;
    }

    @Override
    public AttributionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = new TextView(parent.getContext());
        return new AttributionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AttributionsViewHolder holder, int position) {
        final String attribution = mAttributionsList.get(position);
        holder.tvText.setText(Html.fromHtml(attribution));
        holder.tvText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mTracker.send(new HitBuilders.EventBuilder()
                            .setCategory("Click")
                            .setAction("Attribution")
                            .setLabel(attribution)
                            .build());
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Utilities.extractUriFromAttribution(attribution));
                    mContext.startActivity(intent);
                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(mContext, mContext.getString(R.string.msg_error_link), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAttributionsList.size();
    }

    public static class AttributionsViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;

        public AttributionsViewHolder(View itemView) {
            super(itemView);
            tvText = (TextView) itemView;
            tvText.setLinkTextColor(itemView.getContext().getResources().getColor(R.color.colorPrimary));
        }
    }
}
