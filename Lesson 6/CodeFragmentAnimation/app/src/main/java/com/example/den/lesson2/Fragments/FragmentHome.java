package com.example.den.lesson2.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.den.lesson2.ArticleActivity;
import com.example.den.lesson2.GalleryActivity;
import com.example.den.lesson2.Holders.ViewHolderArticle;
import com.example.den.lesson2.Holders.ViewHolderGallery;
import com.example.den.lesson2.Items.ItemArticle;
import com.example.den.lesson2.Items.ItemBase;
import com.example.den.lesson2.Items.ItemGallery;
import com.example.den.lesson2.R;

import static com.example.den.lesson2.Items.ItemBase.isArticle;
import static com.example.den.lesson2.Items.ItemBase.isGallery;

public class FragmentHome extends Fragment {

    public interface OnHomeFragmentListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(int position);
    }

    private OnHomeFragmentListener mListener;
    public ItemBase[] itemsArray;


    public FragmentHome() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_home, container, false);
        setupListViewAdvanced(view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnHomeFragmentListener) {
            mListener = (OnHomeFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void setupListViewAdvanced(View contentView) {

        ListView listView = contentView.findViewById(R.id.listView);

        final ArrayAdapter<ItemBase> itemsArrayAdapter =
                new ArrayAdapter<ItemBase>(getContext(), 0, itemsArray) {
                    @Override
                    public View getView(int position,
                                        View convertView,
                                        ViewGroup parent) {

                        if(isArticle(itemsArray[position])) {
                            ItemArticle currentArticle =  (ItemArticle)itemsArray[position];
                            convertView = setupArticleView(convertView, currentArticle);

                        } else if (isGallery(itemsArray[position])) {
                            ItemGallery currentGallery = (ItemGallery) itemsArray[position];
                            convertView = setupGalleryView(convertView, currentGallery);
                        }
                        return convertView;
                    }
                };

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long rowId) {

                if (mListener != null) {
                    mListener.onFragmentInteraction(position);
                }
            }
        });

        listView.setAdapter(itemsArrayAdapter);
    }

    private View setupArticleView(View convertView, ItemArticle currentArticle) {
        // Inflate only once
        if (convertView == null || convertView.getTag().getClass().equals(ViewHolderGallery.class)) {
            convertView = getLayoutInflater()
                    .inflate(R.layout.item_article, null, false);
        }

        if(convertView.getTag() == null) {
            ViewHolderArticle viewHolder = new ViewHolderArticle();
            viewHolder.textViewTitle = convertView.findViewById(R.id.textViewTitle);
            viewHolder.textViewDescription = convertView.findViewById(R.id.textViewDescription);
            convertView.setTag(viewHolder);
        }

        TextView textViewTitle =
                ((ViewHolderArticle) convertView.getTag()).textViewTitle;
        TextView textViewDescription =
                ((ViewHolderArticle) convertView.getTag()).textViewDescription;

        textViewTitle.setText(currentArticle.getTitle());
        textViewDescription.setText(currentArticle.getDescription());

        return convertView;
    }

    private View setupGalleryView(View convertView, ItemGallery currentGallery) {
        // Inflate only once
        if (convertView == null || convertView.getTag().getClass().equals(ViewHolderArticle.class)) {
            convertView = getLayoutInflater()
                    .inflate(R.layout.item_gallery, null, false);
        }

        if(convertView.getTag() == null) {
            ViewHolderGallery viewHolder = new ViewHolderGallery();
            viewHolder.imageView = convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);
        }

        ImageView imageView =
                ((ViewHolderGallery) convertView.getTag()).imageView;

        imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), currentGallery.imgResoureID()));
        return convertView;
    }
}
