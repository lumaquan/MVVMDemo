package com.ivan.mvvmdemo.ui.albums.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ivan.mvvmdemo.R;
import com.ivan.mvvmdemo.ui.albums.model.Album;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private List<Album> albums;

    public AlbumAdapter(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_item, parent, false);
        if (viewType == 1) {
            view.setBackgroundColor(parent.getResources().getColor(R.color.colorAccent));
        }
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        holder.onBind(albums.get(position));
    }

    @Override
    public int getItemCount() {
        return albums != null
                ? albums.size()
                : 0;
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView title;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void onBind(Album album) {
            title.setText(album.getTitle());
        }
    }
}
