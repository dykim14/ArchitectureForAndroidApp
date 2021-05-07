package com.practice.architectureforandroidapp.chapter4.sub1;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class BindingAdapter extends RecyclerView.Adapter<BindingHolder<ViewDataBinding>> {

    @Override
    public int getItemCount() {
        return 0;
    }

    @NonNull
    @NotNull
    @Override
    public BindingHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BindingHolder<ViewDataBinding> holder, int position) {
//        holder.getBinding().setData(getItem(position));
//        holder.getBinding().setVariable(BR.user, item);
        holder.getBinding().executePendingBindings();
    }
}
