package com.example.wwjwe.fragmentwithrecycleview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentContact extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private List<Contact> contactList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.contact_fragment,container,false);
        recyclerView = v.findViewById(R.id.rvContact);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),contactList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactList= new ArrayList<>();
        contactList.add(new Contact("A","1",R.drawable.ic_contacts_white_24dp));
        contactList.add(new Contact("B","2",R.drawable.ic_contacts_white_24dp));
        contactList.add(new Contact("C","3",R.drawable.ic_contacts_white_24dp));
    }
}
